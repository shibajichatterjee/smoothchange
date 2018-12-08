package com.rest.smoothchange.reports.repository.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoEnumRecordsFoundException;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingDto;
import com.rest.smoothchange.business.benefit.mapping.entity.BusinessBenefitMapping;
import com.rest.smoothchange.business.benefit.mapping.service.BusinessBenefitMappingService;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysis;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.impact.analysis.service.ImpactAnalysisService;
import com.rest.smoothchange.implementation.strategy.dto.ImplementationStrategyDto;
import com.rest.smoothchange.implementation.strategy.service.ImplementationStrategyService;
import com.rest.smoothchange.organization.info.dto.OrganizationInfoDto;
import com.rest.smoothchange.organization.info.service.OrganizationInfoService;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.service.ProjectStakeholdersService;
import com.rest.smoothchange.report.dto.StakeHolder;
import com.rest.smoothchange.report.template.dto.ReportTemplateDto;
import com.rest.smoothchange.report.template.service.ReportTemplateService;
import com.rest.smoothchange.reports.repository.dto.ReportsRepositoryDto;
import com.rest.smoothchange.reports.repository.dto.ReportsRepositoryRequestDto;
import com.rest.smoothchange.reports.repository.entity.ReportsRepository;
import com.rest.smoothchange.reports.repository.service.ReportsRepositoryService;
import com.rest.smoothchange.util.CommonUtil;
import com.rest.smoothchange.util.DateUtil;
import com.rest.smoothchange.util.GeneratedOrUploaded;
import com.rest.smoothchange.util.ImageUtil;
import com.rest.smoothchange.util.ReportType;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/reportsRepositoryAPI")
@Api(value = "Reports Repository", description = "Operations For Reports Repository")

@Transactional
public class ReportsRepositoryController {

	private static final String dateFormatter = "yyyy-MM-dd";

	private static final String dateFormatter_with_min_ss = "yyyyMMddHHssssss";

	@Value("${BUSINESS_BENEFITS_MAPPING_TEMPLATE_FROM_DATABASE}")
	private String businessBenefitsMappingTemplateFromDatabasePath;

	@Value("${BUSINESS_BENEFITS_MAPPING_GENERATED_REPORT_TO_DATABASE}")
	private String businessBenefitsMappingGeneratedReporToDatabase;

	@Autowired
	private ReportsRepositoryService reportsRepositoryService;

	@Autowired
	private ProjectBackgroundService projectBackgroundService;

	@Autowired
	private ReportTemplateService reportTemplateService;

	@Autowired
	private OrganizationInfoService organizationInfoService;

	@Autowired
	private BusinessBenefitMappingService bsinessBenefitMappingService;

	@Autowired
	private ProjectStakeholdersService projectStakeholdersService;
	@Autowired
	private ImpactAnalysisService impactAnalysisService;
	@Autowired
	private ImplementationStrategyService implementationStrategyService;
	@Autowired
	private CommonUtil commonUtil;

	@ApiOperation(value = "Upload Reports Repository")
	@RequestMapping(value = "/uploadReportsRepository", method = RequestMethod.POST)
	public ResponseEntity uploadReportsRepository(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("report") MultipartFile file, @RequestParam("projectId") long projectId,
			@RequestParam("reportType") String reportType,

			@RequestParam("comment") String comment, @RequestParam("userId") String userId) throws IOException,
			UnauthorizedException, ParseException, NoRecordsFoundException, NoEnumRecordsFoundException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();

		ReportType reportType2 = ReportType.getValue(reportType);
		if (reportType2 == null) {
			throw new NoEnumRecordsFoundException("Report type Not Present");
		}

		commonUtil.getProjectBackGround(Long.toString(projectId));
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(projectId);
		if (projectBackgroundDto != null && projectBackgroundDto.getId() != null) {
			projectBackgroundDto.setId(projectId);
			ReportsRepository reportsRepository = new ReportsRepository();
			byte[] byteArray = ImageUtil.getByteArrayFromMaltipartFormData(file);
			ReportsRepositoryDto reportsRepositoryDto = new ReportsRepositoryDto();
			reportsRepositoryDto.setComment(comment);
			reportsRepositoryDto.setDateTime(new Date());
			reportsRepositoryDto.setGeneratedOrUploaded(GeneratedOrUploaded.Uploaded.getGeneratedUpload());
			reportsRepositoryDto.setProjectBackground(projectBackgroundDto);
			reportsRepositoryDto.setReportFile(byteArray);
			reportsRepositoryDto.setReportFileSize(file.getSize());
			reportsRepositoryDto.setReportType(reportType);
			reportsRepositoryDto.setUserId(userId);
			long reportsRepositoryId = (Long) reportsRepositoryService.create(reportsRepositoryDto);
			reportsRepository.setId(reportsRepositoryId);
			reportsRepository.setReportFileSize(reportsRepositoryDto.getReportFileSize());
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "download Reports Repository")
	@RequestMapping(value = "downloadReportsRepository", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadReportsRepository(@RequestParam("API-KEY") String apiKey,
			@RequestParam("id") long id, HttpServletResponse httpServletResponse)
			throws IOException, UnauthorizedException, ParseException, NoRecordsFoundException {

		ResponseBean responseBean = new ResponseBean();
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ReportsRepositoryDto reportsRepository = reportsRepositoryService.getById(id);
		if (reportsRepository == null && reportsRepository.getId() == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());

		}
		String fileName = reportsRepository.getReportType()
				+ DateUtil.getFormattedDateStringFromDate(new Date(), dateFormatter_with_min_ss) + "-"
				+ reportsRepository.getId();
		ByteArrayResource resource = new ByteArrayResource(reportsRepository.getReportFile());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".docx")
				.contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(reportsRepository.getReportFile().length)
				.body(resource);
	}

	@ApiOperation(value = "Get Report Detail By Report Type And Project Id")
	@RequestMapping(value = "getAllReportInfoByTypeAndProjectId", method = RequestMethod.GET)
	public ResponseEntity getAllReportInfoByTypeAndProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("type") String reportType, @RequestParam("projectId") long projectId)
			throws NoEnumRecordsFoundException, NoRecordsFoundException, ParseException, UnauthorizedException {

		ResponseBean responseBean = new ResponseBean();
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ReportType reportType2 = ReportType.getValue(reportType);
		if (reportType2 == null) {
			throw new NoEnumRecordsFoundException("Report type Not Present");
		}
		commonUtil.getProjectBackGround(Long.toString(projectId));

		List<ReportsRepositoryRequestDto> reportsRepositoryRequestDtoList = new ArrayList<>();
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(projectId);
		if (projectBackgroundDto != null && projectBackgroundDto.getId() != null) {
			List<ReportsRepositoryDto> reportsRepositoryDtoList = reportsRepositoryService
					.getReportReposetoryDetailByTypeAndProjectId(reportType2, projectId);
			if (reportsRepositoryDtoList != null && reportsRepositoryDtoList.size() > 0) {
				for (ReportsRepositoryDto reportsRepositoryDto : reportsRepositoryDtoList) {
					reportsRepositoryRequestDtoList.add(mapReportsRepositoryDtoToRequestDto(reportsRepositoryDto));
				}
				responseBean.setBody(reportsRepositoryRequestDtoList);
			} else {
				throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			}
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Report")
	@RequestMapping(value = "deleteReportInfo", method = RequestMethod.DELETE)
	public ResponseEntity getAllReportInfoByTypeAndProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("id") long id)
			throws NoEnumRecordsFoundException, NoRecordsFoundException, ParseException, UnauthorizedException {
		ResponseBean responseBean = new ResponseBean();
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ReportsRepositoryDto reportsRepository = reportsRepositoryService.getById(id);
		if (reportsRepository != null && reportsRepository.getId() != null) {
			reportsRepositoryService.delete(reportsRepository);
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	/*
	 * @ApiOperation(value="Generate Business Benifit Report")
	 * 
	 * @RequestMapping(value="businessBenifitMappingReport",method =
	 * RequestMethod.POST) public ResponseEntity
	 * businessBenifitMappingReport(@RequestParam("projectId") long projectId
	 * , @RequestParam("reportType") String reportType , @RequestParam("userId")
	 * String userId , @RequestParam("comment") String comment) throws
	 * ParseException, IOException, XDocReportException,
	 * NoRecordsFoundException, NoEnumRecordsFoundException {
	 * 
	 * byte [] uploadFile = {}; ResponseBean responseBean = new ResponseBean();
	 * 
	 * ReportType reportType2 = ReportType.getValue(reportType); if (reportType2
	 * == null) { throw new NoEnumRecordsFoundException(
	 * "Report type Not Present"); }
	 * 
	 * List<ReportTemplateDto> reportTemplateDtoList =
	 * reportTemplateService.getReportTemplateDetailByTypeAndProjectId(
	 * reportType2); if(reportTemplateDtoList==null ||
	 * reportTemplateDtoList.size()==0) { throw new
	 * NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
	 * }
	 * 
	 * ProjectBackgroundDto projectBackgroundDto =
	 * projectBackgroundService.getById(projectId);
	 * if(projectBackgroundDto==null || projectBackgroundDto.getId()==null) {
	 * throw new
	 * NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.
	 * getMessage()); }
	 * 
	 * if("Business Benefits Mapping"
	 * .equalsIgnoreCase(reportType2.getReportType())) { OrganizationInfoDto
	 * organizationInfoDto = organizationInfoService.getById(1L);
	 * List<BusinessBenefitMappingDto> businessBenefitMappingDtolist =
	 * bsinessBenefitMappingService.getBusinessBenefitMappingListByProjectId(
	 * projectId); uploadFile =
	 * generateBusinessBenefitMapping(reportTemplateDtoList.get(0),
	 * businessBenefitMappingDtolist, organizationInfoDto,
	 * projectBackgroundDto); }
	 * 
	 * if(uploadFile!=null && uploadFile.length>0) { ReportsRepositoryDto
	 * reportsRepositoryDto = new ReportsRepositoryDto();
	 * reportsRepositoryDto.setComment(comment);
	 * reportsRepositoryDto.setDateTime(new Date());
	 * reportsRepositoryDto.setGeneratedOrUploaded(GeneratedOrUploaded.Generated
	 * .getGeneratedUpload());
	 * reportsRepositoryDto.setProjectBackground(projectBackgroundDto);
	 * reportsRepositoryDto.setReportFile(uploadFile);
	 * reportsRepositoryDto.setReportFileSize(0l);
	 * reportsRepositoryDto.setReportType(reportType);
	 * reportsRepositoryDto.setUserId(userId); long reportsRepositoryId = (Long)
	 * reportsRepositoryService.create(reportsRepositoryDto);
	 * responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage()); }
	 * return new ResponseEntity(responseBean, HttpStatus.OK); }
	 * 
	 * private byte[] generateBusinessBenefitMapping(ReportTemplateDto
	 * reportTemplateDto, List<BusinessBenefitMappingDto>
	 * businessBenefitMappingDtolist , OrganizationInfoDto organizationObj ,
	 * ProjectBackgroundDto projectObj) throws IOException, XDocReportException,
	 * ParseException {
	 * 
	 * String fileName = reportTemplateDto.getReportType() + "-" +
	 * DateUtil.getFormattedDateStringFromDate(new Date(),
	 * dateFormatter_with_min_ss) + "-" + reportTemplateDto.getId() + ".docx";
	 * FileUtils.writeByteArrayToFile(new
	 * File(businessBenefitsMappingTemplateFromDatabasePath +
	 * fileName),reportTemplateDto.getTemplateFile()); InputStream inputStream =
	 * new FileInputStream( new
	 * File(businessBenefitsMappingTemplateFromDatabasePath + fileName));
	 * IXDocReport report =
	 * XDocReportRegistry.getRegistry().loadReport(inputStream,
	 * TemplateEngineKind.Velocity); FieldsMetadata metadata =
	 * report.createFieldsMetadata(); metadata.load("businessbenefitmapping",
	 * BusinessBenefitMappingDto.class, true); IContext context =
	 * report.createContext();
	 * generationBusinessBenifitMappingReportData(businessBenefitMappingDtolist,
	 * projectObj, organizationObj); context.put("organization",
	 * organizationObj); context.put("project", projectObj);
	 * context.put("businessbenefitmapping", businessBenefitMappingDtolist);
	 * OutputStream out = new FileOutputStream(new
	 * File(businessBenefitsMappingGeneratedReporToDatabase + fileName));
	 * report.process(context, out); out.close(); return
	 * FileUtils.readFileToByteArray(new
	 * File(businessBenefitsMappingGeneratedReporToDatabase + fileName)); }
	 */

	@ApiOperation(value = "Generate and Download Report")
	@RequestMapping(value = "generateDownloadReport", method = RequestMethod.POST)
	public ResponseEntity generateDownloadReport(@RequestHeader("API-KEY") String apiKey,@RequestParam("projectId") long projectId,
			@RequestParam("reportType") String reportType, @RequestParam("userId") String userId,
			@RequestParam("comment") String comment) throws ParseException, IOException, XDocReportException,
			NoRecordsFoundException, NoEnumRecordsFoundException, UnauthorizedException {

		byte[] uploadFile = {};
		ResponseBean responseBean = new ResponseBean();
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ReportType reportType2 = ReportType.getValue(reportType);
		if (reportType2 == null) {
			throw new NoEnumRecordsFoundException("Report type Not Present");
		}

		List<ReportTemplateDto> reportTemplateDtoList = reportTemplateService
				.getReportTemplateDetailByTypeAndProjectId(reportType2);
		if (reportTemplateDtoList == null || reportTemplateDtoList.size() == 0) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}

		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(projectId);
		if (projectBackgroundDto == null || projectBackgroundDto.getId() == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}

		if ("Business Benefits Mapping".equalsIgnoreCase(reportType2.getReportType())) {
			OrganizationInfoDto organizationInfoDto = organizationInfoService.getById(1L);
			List<BusinessBenefitMappingDto> businessBenefitMappingDtolist = bsinessBenefitMappingService
					.getBusinessBenefitMappingListByProjectId(projectId);
			uploadFile = generateBusinessBenefitMapping(reportTemplateDtoList.get(0), businessBenefitMappingDtolist,
					organizationInfoDto, projectBackgroundDto);
		}
		if ("Stakeholder Analysis".equalsIgnoreCase(reportType2.getReportType())) {
			OrganizationInfoDto organizationInfoDto = organizationInfoService.getById(1L);
			List<ProjectStakeholdersDto> stakeHolderDtolist = projectStakeholdersService
					.getStakeHolderListByProjectId(projectId);
			uploadFile = generateStakeHolderAnalysis(reportTemplateDtoList.get(0), stakeHolderDtolist,
					organizationInfoDto, projectBackgroundDto);
		}
		if ("Impact Analysis".equalsIgnoreCase(reportType2.getReportType())) {
			OrganizationInfoDto organizationInfoDto = organizationInfoService.getById(1L);
			List<ImpactAnalysisDto> impactAnalysisDtolist = impactAnalysisService
					.getImpactAnalysisListByProjectId(projectId);
			uploadFile = generateImpactAnalysis(reportTemplateDtoList.get(0), impactAnalysisDtolist,
					organizationInfoDto, projectBackgroundDto);
		}
		if ("Change Implementation Strategy".equalsIgnoreCase(reportType2.getReportType())) {
			OrganizationInfoDto organizationInfoDto = organizationInfoService.getById(1L);
			List<ImplementationStrategyDto> implementationStrategyDtolist = implementationStrategyService
					.getImplementationStrategyListByProjectId(projectId);
			uploadFile = generateChangeImplementationStrategy(reportTemplateDtoList.get(0),
					implementationStrategyDtolist, organizationInfoDto, projectBackgroundDto);
		}

		if (uploadFile != null && uploadFile.length > 0) {
			ReportsRepositoryDto reportsRepositoryDto = new ReportsRepositoryDto();
			reportsRepositoryDto.setComment(comment);
			reportsRepositoryDto.setDateTime(new Date());
			reportsRepositoryDto.setGeneratedOrUploaded(GeneratedOrUploaded.Generated.getGeneratedUpload());
			reportsRepositoryDto.setProjectBackground(projectBackgroundDto);
			reportsRepositoryDto.setReportFile(uploadFile);
			reportsRepositoryDto.setReportFileSize(uploadFile.length);
			reportsRepositoryDto.setReportType(reportType);
			reportsRepositoryDto.setUserId(userId);
			long reportsRepositoryId = (Long) reportsRepositoryService.create(reportsRepositoryDto);
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		}
		ByteArrayResource resource = new ByteArrayResource(uploadFile);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + reportType2.getReportType() + ".docx")
				.contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(uploadFile.length).body(resource);
	}

	private byte[] generateBusinessBenefitMapping(ReportTemplateDto reportTemplateDto,
			List<BusinessBenefitMappingDto> businessBenefitMappingDtolist, OrganizationInfoDto organizationObj,
			ProjectBackgroundDto projectObj) throws IOException, XDocReportException, ParseException {
		InputStream targetStream = new ByteArrayInputStream(reportTemplateDto.getTemplateFile());
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport(targetStream, TemplateEngineKind.Velocity);
		FieldsMetadata metadata = report.createFieldsMetadata();
		metadata.load("businessbenefitmapping", BusinessBenefitMappingDto.class, true);
		IContext context = report.createContext();
		generationBusinessBenifitMappingReportData(businessBenefitMappingDtolist, projectObj, organizationObj);
		context.put("organization", organizationObj);
		context.put("project", projectObj);
		context.put("businessbenefitmapping", businessBenefitMappingDtolist);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		report.process(context, out);
		byte[] byteArray = out.toByteArray();
		return byteArray;
	}

	private byte[] generateStakeHolderAnalysis(ReportTemplateDto reportTemplateDto,
			List<ProjectStakeholdersDto> stakeHolderDtolist, OrganizationInfoDto organizationObj,
			ProjectBackgroundDto projectObj) throws IOException, XDocReportException, ParseException {
		InputStream targetStream = new ByteArrayInputStream(reportTemplateDto.getTemplateFile());
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport(targetStream, TemplateEngineKind.Velocity);
		FieldsMetadata metadata = report.createFieldsMetadata();
		metadata.load("stakeholders", ProjectStakeholdersDto.class, true);
		IContext context = report.createContext();
		generationStakeHolderReportData(stakeHolderDtolist, projectObj, organizationObj);

		context.put("organization", organizationObj);
		context.put("project", projectObj);
		context.put("stakeholders", stakeHolderDtolist);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		report.process(context, out);
		byte[] byteArray = out.toByteArray();
		return byteArray;
	}

	private byte[] generateImpactAnalysis(ReportTemplateDto reportTemplateDto,
			List<ImpactAnalysisDto> impactAnalysisDtolist, OrganizationInfoDto organizationObj,
			ProjectBackgroundDto projectObj) throws IOException, XDocReportException, ParseException {
		InputStream targetStream = new ByteArrayInputStream(reportTemplateDto.getTemplateFile());
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport(targetStream, TemplateEngineKind.Velocity);
		FieldsMetadata metadata = report.createFieldsMetadata();
		metadata.load("impactanalysis", ImpactAnalysis.class, true);
		IContext context = report.createContext();
		List<ImpactAnalysis> impactAnalysisList = generationImpactAnalysisReportData(impactAnalysisDtolist, projectObj,
				organizationObj);

		context.put("organization", organizationObj);
		context.put("project", projectObj);
		context.put("impactanalysis", impactAnalysisList);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		report.process(context, out);
		byte[] byteArray = out.toByteArray();
		return byteArray;
	}

	private byte[] generateChangeImplementationStrategy(ReportTemplateDto reportTemplateDto,
			List<ImplementationStrategyDto> implementationStrategyDtolist, OrganizationInfoDto organizationObj,
			ProjectBackgroundDto projectObj) throws IOException, XDocReportException, ParseException {
		InputStream targetStream = new ByteArrayInputStream(reportTemplateDto.getTemplateFile());
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport(targetStream, TemplateEngineKind.Velocity);
		FieldsMetadata metadata = report.createFieldsMetadata();
		metadata.load("changeimplementationstrategy", ImplementationStrategyDto.class, true);
		IContext context = report.createContext();
		generateChangeImplementationStrategyData(implementationStrategyDtolist, projectObj, organizationObj);

		context.put("organization", organizationObj);
		context.put("project", projectObj);
		context.put("changeimplementationstrategy", implementationStrategyDtolist);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		report.process(context, out);
		byte[] byteArray = out.toByteArray();
		return byteArray;
	}

	private void generationBusinessBenifitMappingReportData(
			List<BusinessBenefitMappingDto> businessBenefitMappingDtolist, ProjectBackgroundDto projectObj,
			OrganizationInfoDto organizationInfoDto) {

		if (businessBenefitMappingDtolist != null && businessBenefitMappingDtolist.size() > 0) {
			for (int i = 0; i < businessBenefitMappingDtolist.size(); i++) {
				businessBenefitMappingDtolist.get(i).setSerialNumber(Integer.toString(i + 1));
			}
		}

		if (projectObj != null) {
			projectObj.setName(projectObj.getProjectName());
			projectObj.setDescription(projectObj.getProjectDescription());
			projectObj.setOwner(projectObj.getOwnerOfChange());
		}

		if (organizationInfoDto != null) {
			organizationInfoDto.setName(organizationInfoDto.getOrganisationName());
		}
	}

	private void generationStakeHolderReportData(List<ProjectStakeholdersDto> stakeHolderDtolist,
			ProjectBackgroundDto projectObj, OrganizationInfoDto organizationInfoDto) {

		if (stakeHolderDtolist != null && stakeHolderDtolist.size() > 0) {
			for (int i = 0; i < stakeHolderDtolist.size(); i++) {
				stakeHolderDtolist.get(i).setSerialNumber(Integer.toString(i + 1));
				stakeHolderDtolist.get(i).setName(stakeHolderDtolist.get(i).getStakeholderName());
				stakeHolderDtolist.get(i).setType(stakeHolderDtolist.get(i).getStakeholderType());
				stakeHolderDtolist.get(i)
						.setNoOfPersonsImpacted(stakeHolderDtolist.get(i).getNumberImpacted().toString());
				stakeHolderDtolist.get(i).setStrategyOfEngagement(stakeHolderDtolist.get(i).getEngagementStrategy());
			}
		}

		if (projectObj != null) {
			projectObj.setName(projectObj.getProjectName());
			projectObj.setDescription(projectObj.getProjectDescription());
			projectObj.setOwner(projectObj.getOwnerOfChange());
		}

		if (organizationInfoDto != null) {
			organizationInfoDto.setName(organizationInfoDto.getOrganisationName());
		}
	}

	private void generateChangeImplementationStrategyData(List<ImplementationStrategyDto> implementationStrategyDtolist,
			ProjectBackgroundDto projectObj, OrganizationInfoDto organizationInfoDto) {

		if (implementationStrategyDtolist != null && implementationStrategyDtolist.size() > 0) {
			for (int i = 0; i < implementationStrategyDtolist.size(); i++) {
				implementationStrategyDtolist.get(i).setSerialNumber(Integer.toString(i + 1));
				implementationStrategyDtolist.get(i)
						.setLeadContactNameAndDesignation(implementationStrategyDtolist.get(i).getLeadContactName()
								+ " " + implementationStrategyDtolist.get(i).getLeadContactDesignation());
				implementationStrategyDtolist.get(i)
						.setExpectedResults(implementationStrategyDtolist.get(i).getExpectedResult());
				implementationStrategyDtolist.get(i).setNoOfResources(
						Long.toString(implementationStrategyDtolist.get(i).getNoOfRequiredResources()));
			}
		}

		if (projectObj != null) {
			projectObj.setName(projectObj.getProjectName());
			projectObj.setDescription(projectObj.getProjectDescription());
			projectObj.setOwner(projectObj.getOwnerOfChange());
		}

		if (organizationInfoDto != null) {
			organizationInfoDto.setName(organizationInfoDto.getOrganisationName());
		}
	}

	private List<ImpactAnalysis> generationImpactAnalysisReportData(List<ImpactAnalysisDto> impactAnalysisDtolist,
			ProjectBackgroundDto projectObj, OrganizationInfoDto organizationInfoDto) {

		List<ImpactAnalysis> listImpactAnalysis = new ArrayList<>();
		if (impactAnalysisDtolist != null && impactAnalysisDtolist.size() > 0) {
			for (int i = 0; i < impactAnalysisDtolist.size(); i++) {
				ImpactAnalysis im = new ImpactAnalysis();
				im.setSerialNumber(Integer.toString(i + 1));
				im.setTypeOfImpact(impactAnalysisDtolist.get(i).getImpactType().getNumVal());
				im.setLocationOfAffectedStakeholder(
						impactAnalysisDtolist.get(i).getProjectStakeholders().getLocation());
				im.setNameOfAffectedStakeholder(impactAnalysisDtolist.get(i).getProjectStakeholders().getName());
				im.setNoOfPersonsImpacted(
						impactAnalysisDtolist.get(i).getProjectStakeholders().getNoOfPersonsImpacted());
				im.setLevelOfImpact(impactAnalysisDtolist.get(i).getLevelOfImpact().getNumVal());
				im.setPlannedActivity(impactAnalysisDtolist.get(i).getPlannedActivity().getNumVal());
				listImpactAnalysis.add(im);
			}
		}

		if (projectObj != null) {
			projectObj.setName(projectObj.getProjectName());
			projectObj.setDescription(projectObj.getProjectDescription());
			projectObj.setOwner(projectObj.getOwnerOfChange());
		}

		if (organizationInfoDto != null) {
			organizationInfoDto.setName(organizationInfoDto.getOrganisationName());
		}
		return listImpactAnalysis;
	}

	private ReportsRepositoryRequestDto mapReportsRepositoryDtoToRequestDto(ReportsRepositoryDto reportsRepository)
			throws ParseException {
		ReportsRepositoryRequestDto reportsRepositoryRequestDto = null;
		if (reportsRepository != null) {
			reportsRepositoryRequestDto = new ReportsRepositoryRequestDto();
			reportsRepositoryRequestDto.setComment(reportsRepository.getComment());
			if (reportsRepository.getDateTime() != null) {
				reportsRepositoryRequestDto.setDateTime(
						DateUtil.getFormattedDateStringFromDate(reportsRepository.getDateTime(), dateFormatter));
			}
			reportsRepositoryRequestDto.setGeneratedOrUploaded(reportsRepository.getGeneratedOrUploaded());
			reportsRepositoryRequestDto.setReportFileSize(reportsRepository.getReportFileSize());
			reportsRepositoryRequestDto.setReportsRepositoryId(reportsRepository.getId());
			reportsRepositoryRequestDto.setReportType(reportsRepository.getReportType());
			reportsRepositoryRequestDto.setUserId(reportsRepository.getUserId());
			if (reportsRepository.getReportFile() != null) {
				reportsRepositoryRequestDto
						.setReportFile(ImageUtil.getBase64FromByteArray(reportsRepository.getReportFile()));
			}
		}
		return reportsRepositoryRequestDto;
	}

}
