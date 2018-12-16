package com.rest.smoothchange.reports.repository.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsDto;
import com.rest.smoothchange.action.plan.items.service.ActionPlanItemsService;
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingDto;
import com.rest.smoothchange.business.benefit.mapping.service.BusinessBenefitMappingService;
import com.rest.smoothchange.communication.plan.dto.CommunicationPlan;
import com.rest.smoothchange.communication.plan.dto.CommunicationPlanDto;
import com.rest.smoothchange.communication.plan.service.CommunicationPlanService;
import com.rest.smoothchange.cost.of.change.dto.CostOfChangeDto;
import com.rest.smoothchange.cost.of.change.items.dto.CostOfChangeItemsDto;
import com.rest.smoothchange.cost.of.change.items.service.CostOfChangeItemsService;
import com.rest.smoothchange.cost.of.change.service.CostOfChangeService;
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
import com.rest.smoothchange.report.template.dto.ReportTemplateDto;
import com.rest.smoothchange.report.template.service.ReportTemplateService;
import com.rest.smoothchange.reports.repository.dto.ReportsRepositoryDto;
import com.rest.smoothchange.reports.repository.dto.ReportsRepositoryRequestDto;
import com.rest.smoothchange.reports.repository.entity.ReportsRepository;
import com.rest.smoothchange.reports.repository.service.ReportsRepositoryService;
import com.rest.smoothchange.support.plan.items.dto.SupportPlanItemsDto;
import com.rest.smoothchange.support.plan.items.service.SupportPlanItemsService;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.dto.TrainingPlanCurriculumLessonPlanDto;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.service.TrainingPlanCurriculumLessonPlanService;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentDto;
import com.rest.smoothchange.training.plan.equipment.service.TrainingPlanEquipmentService;
import com.rest.smoothchange.training.plan.roles.responsibilities.dto.TrainingPlanRolesResponsibilitiesDto;
import com.rest.smoothchange.training.plan.roles.responsibilities.service.TrainingPlanRolesResponsibilitiesService;
import com.rest.smoothchange.training.plan.schedule.dto.TrainingPlanScheduleDto;
import com.rest.smoothchange.training.plan.schedule.service.TrainingPlanScheduleService;
import com.rest.smoothchange.training.plan.service.TrainingPlanService;
import com.rest.smoothchange.training.plan.version.history.dto.TrainingPlanVersionHistoryDto;
import com.rest.smoothchange.training.plan.version.history.service.TrainingPlanVersionHistoryService;
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
	@Autowired
	private CommunicationPlanService communicationPlanService;
	@Autowired
	private TrainingPlanService trainingPlanService;
	
	@Autowired
	private TrainingPlanVersionHistoryService trainingPlanVersionHistoryService;
	
	@Autowired
	private TrainingPlanRolesResponsibilitiesService trainingPlanRolesResponsibilitiesService;
	
	@Autowired
	private TrainingPlanEquipmentService trainingPlanEquipmentService;
	
	@Autowired
	private TrainingPlanScheduleService trainingPlanScheduleService;
	
	@Autowired
	private TrainingPlanCurriculumLessonPlanService trainingPlanCurriculumLessonPlanService;
	
	@Autowired
	private ActionPlanItemsService actionPlanItemsService;
	
	@Autowired
	private CostOfChangeItemsService costOfChangeItemsService;
	
	@Autowired
	private CostOfChangeService costOfChangeService;
	
	@Autowired
	private SupportPlanItemsService supportPlanItemsService;

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
	public ResponseEntity<ByteArrayResource> downloadReportsRepository(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("id") long id, HttpServletResponse httpServletResponse)
			throws IOException, UnauthorizedException, ParseException, NoRecordsFoundException {

		ResponseBean responseBean = new ResponseBean();
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ReportsRepositoryDto reportsRepository = reportsRepositoryService.getById(id);
		if (reportsRepository == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());

		}
		String fileName = reportsRepository.getReportType()
				+ DateUtil.getFormattedDateStringFromDate(new Date(), dateFormatter_with_min_ss) + "-"
				+ reportsRepository.getId();
		ByteArrayResource resource = new ByteArrayResource(reportsRepository.getReportFile());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + "_DownLoadReport.docx")
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
	public ResponseEntity generateDownloadReport(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") long projectId, @RequestParam("reportType") String reportType,
			@RequestParam("userId") String userId, @RequestParam("comment") String comment)
			throws ParseException, IOException, XDocReportException, NoRecordsFoundException,
			NoEnumRecordsFoundException, UnauthorizedException {

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
		if ("Training Plan".equalsIgnoreCase(reportType2.getReportType())) {
			OrganizationInfoDto organizationInfoDto = organizationInfoService.getById(1L);	
			List<TrainingPlanVersionHistoryDto> trainingPlanVersionHistoryDtoList = trainingPlanVersionHistoryService.getTrainingPlanVersionHistoryListByProjectId(projectId);
			List<TrainingPlanRolesResponsibilitiesDto> trainingPlanRolesResponsibilitiesDtoList = trainingPlanRolesResponsibilitiesService.getTrainingPlanRolesResponsibilitiesListByProjectId(projectId);
			List<TrainingPlanEquipmentDto> trainingPlanEquipmentDtoList = trainingPlanEquipmentService.getTrainingPlanEquipmentListByProjectId(projectId);
			List<TrainingPlanScheduleDto> trainingPlanScheduleDtoList  = trainingPlanScheduleService.getTrainingPlanScheduleListByProjectId(projectId);
			List<TrainingPlanCurriculumLessonPlanDto> trainingPlanCurriculumLessonPlanDtoList = trainingPlanCurriculumLessonPlanService.getTrainingPlanCurriculumLessonPlanListByProjectId(projectId);
			 uploadFile = generateTrainingPlan(reportTemplateDtoList.get(0),  organizationInfoDto,trainingPlanVersionHistoryDtoList,trainingPlanRolesResponsibilitiesDtoList,
						 trainingPlanEquipmentDtoList, trainingPlanScheduleDtoList, trainingPlanCurriculumLessonPlanDtoList, projectBackgroundDto);
		}
		
		if("Change Management Plan".equals(reportType2.getReportType())) {
			List<ActionPlanItemsDto> actionPlanDtoList = actionPlanItemsService.getActionPlanItemsListByProjectId(projectId);
			List<CostOfChangeDto> costOfChangeDtoList = costOfChangeService.getCostOfChangeListByProjectId(projectId);
			List<CostOfChangeItemsDto> costOfChangeItemsDtoList = costOfChangeItemsService.getCostOfChangeItemListByProjectIdCostOfChageId(projectId, costOfChangeDtoList.get(0).getId());
			List<SupportPlanItemsDto> supportPlanItemsDtoList = supportPlanItemsService.getSupportPlanItemsListByProjectId(projectId);
			uploadFile = generateChangeManagementPlan(reportTemplateDtoList.get(0),  actionPlanDtoList, costOfChangeDtoList.get(0),
						 costOfChangeItemsDtoList, supportPlanItemsDtoList, projectBackgroundDto);
		}
		if ("Communication Plan".equalsIgnoreCase(reportType2.getReportType())) {
			OrganizationInfoDto organizationInfoDto = organizationInfoService.getById(1L);
			List<CommunicationPlanDto> communicationPlanlist = communicationPlanService
					.getCommunicationPlanListByProjectId(projectId);
			uploadFile = generateCommunicationPlan(reportTemplateDtoList.get(0), communicationPlanlist,
					organizationInfoDto, projectBackgroundDto);
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
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + reportType2.getReportType() + "_DownLoadReport.docx")
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
private byte[] generateTrainingPlan(ReportTemplateDto reportTemplateDto, OrganizationInfoDto organizationObj,
			List<TrainingPlanVersionHistoryDto> trainingPlanVersionHistoryDtoList,
			List<TrainingPlanRolesResponsibilitiesDto> trainingPlanRolesResponsibilitiesDtoList,
			List<TrainingPlanEquipmentDto> trainingPlanEquipmentDtoList,
			List<TrainingPlanScheduleDto> trainingPlanScheduleDtoList,
			List<TrainingPlanCurriculumLessonPlanDto> trainingPlanCurriculumLessonPlanDtoList,
			ProjectBackgroundDto projectObj) throws IOException, XDocReportException, ParseException {
		InputStream targetStream = new ByteArrayInputStream(reportTemplateDto.getTemplateFile());
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport(targetStream, TemplateEngineKind.Velocity);
		FieldsMetadata metadata = report.createFieldsMetadata();
		metadata.load("versionHistory", TrainingPlanVersionHistoryDto.class, true);
		metadata.load("rolesAndResponsibilities", TrainingPlanRolesResponsibilitiesDto.class, true);
		metadata.load("equipment", TrainingPlanEquipmentDto.class, true);
		metadata.load("schedule", TrainingPlanScheduleDto.class, true);
		metadata.load("lessonPlan", TrainingPlanCurriculumLessonPlanDto.class, true);
		IContext context = report.createContext();
		generateTrainingPlanData( organizationObj, trainingPlanVersionHistoryDtoList, trainingPlanRolesResponsibilitiesDtoList, trainingPlanEquipmentDtoList,
				trainingPlanScheduleDtoList, trainingPlanCurriculumLessonPlanDtoList, projectObj);
		context.put("organization", organizationObj);
		context.put("project", projectObj);
		context.put("versionHistory", trainingPlanVersionHistoryDtoList);
		context.put("rolesAndResponsibilities", trainingPlanRolesResponsibilitiesDtoList);
		context.put("equipment", trainingPlanEquipmentDtoList);
		context.put("schedule", trainingPlanScheduleDtoList);
		context.put("lessonPlan", trainingPlanCurriculumLessonPlanDtoList);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		report.process(context, out);
		byte[] byteArray = out.toByteArray();
		return byteArray;
	}

	private byte[] generateChangeManagementPlan(ReportTemplateDto reportTemplateDto,
			List<ActionPlanItemsDto> actionPlanDtoList, CostOfChangeDto costOfChangeDto,
			List<CostOfChangeItemsDto> costOfChangeItemsDtoList, List<SupportPlanItemsDto> supportPlanItemsDtoList,
			ProjectBackgroundDto projectObj) throws IOException, XDocReportException, ParseException {
		InputStream targetStream = new ByteArrayInputStream(reportTemplateDto.getTemplateFile());
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport(targetStream, TemplateEngineKind.Velocity);
		FieldsMetadata metadata = report.createFieldsMetadata();
		metadata.load("actionPlan", ActionPlanItemsDto.class, true);
		metadata.load("costOfChangeItems", CostOfChangeItemsDto.class, true);
		metadata.load("supportPlan", SupportPlanItemsDto.class, true);
		IContext context = report.createContext();
		generateChangeManagementPlanData(projectObj,actionPlanDtoList, costOfChangeDto,
				costOfChangeItemsDtoList, supportPlanItemsDtoList);

		
		context.put("project", projectObj);
		context.put("actionPlan", actionPlanDtoList);
		context.put("costOfChangeItems", costOfChangeItemsDtoList);
		context.put("costOfChange", costOfChangeDto);
		context.put("supportPlan", supportPlanItemsDtoList);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		report.process(context, out);
		byte[] byteArray = out.toByteArray();
		return byteArray;
	}
	
	private byte[] generateCommunicationPlan(ReportTemplateDto reportTemplateDto,
			List<CommunicationPlanDto> communicationPlanlist, OrganizationInfoDto organizationObj,
			ProjectBackgroundDto projectObj) throws IOException, XDocReportException, ParseException {
		InputStream targetStream = new ByteArrayInputStream(reportTemplateDto.getTemplateFile());
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport(targetStream, TemplateEngineKind.Velocity);
		FieldsMetadata metadata = report.createFieldsMetadata();
		metadata.load("communication", CommunicationPlan.class, true);
		IContext context = report.createContext();
		List<CommunicationPlan> ll=generationCommunicationPlanReportData(communicationPlanlist, projectObj, organizationObj);

		context.put("organization", organizationObj);
		context.put("project", projectObj);
		context.put("communication", ll);
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
				im.setNameOfAffectedStakeholder(impactAnalysisDtolist.get(i).getProjectStakeholders().getStakeholderName());
				im.setNoOfPersonsImpacted(
						impactAnalysisDtolist.get(i).getProjectStakeholders().getNumberImpacted().toString());
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
	private void generateTrainingPlanData(OrganizationInfoDto organizationInfoDto,
			List<TrainingPlanVersionHistoryDto> trainingPlanVersionHistoryDtoList,
			List<TrainingPlanRolesResponsibilitiesDto> trainingPlanRolesResponsibilitiesDtoList,
			List<TrainingPlanEquipmentDto> trainingPlanEquipmentDtoList,
			List<TrainingPlanScheduleDto> trainingPlanScheduleDtoList,
			List<TrainingPlanCurriculumLessonPlanDto> trainingPlanCurriculumLessonPlanDtoList,
			ProjectBackgroundDto projectObj) {
		
		if (projectObj != null) {
			projectObj.setName(projectObj.getProjectName());
			projectObj.setDescription(projectObj.getProjectDescription());
			projectObj.setOwner(projectObj.getOwnerOfChange());
		}

		if (organizationInfoDto != null) {
			organizationInfoDto.setName(organizationInfoDto.getOrganisationName());
		}
		
		if(trainingPlanCurriculumLessonPlanDtoList!=null && trainingPlanCurriculumLessonPlanDtoList.size()>0) {
			for(int i = 0 ; i<trainingPlanCurriculumLessonPlanDtoList.size();i++) {
				trainingPlanCurriculumLessonPlanDtoList.get(i).setSerialNumber((i+1)+"");
				trainingPlanCurriculumLessonPlanDtoList.get(i).setUnitNumber(trainingPlanCurriculumLessonPlanDtoList.get(i).getCurriculumUnitNo());
				trainingPlanCurriculumLessonPlanDtoList.get(i).setUnitName(trainingPlanCurriculumLessonPlanDtoList.get(i).getCurriculumUnitName());
				trainingPlanCurriculumLessonPlanDtoList.get(i).setLessonUnitlNumber(trainingPlanCurriculumLessonPlanDtoList.get(i).getUnitNumber());
			}
		}
		
		if(trainingPlanVersionHistoryDtoList!=null && trainingPlanVersionHistoryDtoList.size()>0) {
			for(int i = 0 ; i<trainingPlanVersionHistoryDtoList.size();i++) {
				trainingPlanVersionHistoryDtoList.get(i).setVersionNumber(trainingPlanVersionHistoryDtoList.get(i).getVersionNo());
			}
		}
		
		if(trainingPlanRolesResponsibilitiesDtoList!=null && trainingPlanRolesResponsibilitiesDtoList.size()>0) {
			for(int i = 0 ; i<trainingPlanRolesResponsibilitiesDtoList.size();i++) {
				trainingPlanRolesResponsibilitiesDtoList.get(i).setSerialNumber((i+1)+"");
			}
		}
		
		if(trainingPlanEquipmentDtoList!=null && trainingPlanEquipmentDtoList.size()>0) {
			for(int i = 0 ; i<trainingPlanEquipmentDtoList.size();i++) {
				trainingPlanEquipmentDtoList.get(i).setSerialNumber((i+1)+"");
			}
		}
		
		if(trainingPlanScheduleDtoList!=null && trainingPlanScheduleDtoList.size()>0) {
			for(int i = 0 ; i<trainingPlanScheduleDtoList.size();i++) {
				trainingPlanScheduleDtoList.get(i).setSerialNumber((i+1)+"");
			}
		}
	
	}
	
	public void generateChangeManagementPlanData(ProjectBackgroundDto projectObj,List<ActionPlanItemsDto> actionPlanDtoList, CostOfChangeDto costOfChangeDto,
			List<CostOfChangeItemsDto> costOfChangeItemsDtoList, List<SupportPlanItemsDto> supportPlanItemsDtoList) {
		
		if (projectObj != null) {
			projectObj.setName(projectObj.getProjectName());
			projectObj.setDescription(projectObj.getProjectDescription());
			projectObj.setOwner(projectObj.getOwnerOfChange());
		}
		
		if(actionPlanDtoList!=null &&  actionPlanDtoList.size()>0) {
			for(int i = 0 ; i<actionPlanDtoList.size() ; i++) {
				actionPlanDtoList.get(i).setSerialNumber((i+1)+"");
			}
		}
		
		if(supportPlanItemsDtoList!=null &&  supportPlanItemsDtoList.size()>0) {
			for(int i = 0 ; i<supportPlanItemsDtoList.size(); i++) {
				supportPlanItemsDtoList.get(i).setSerialNumber((i+1)+"");
				supportPlanItemsDtoList.get(i).setSupportedStakeholderStatus(supportPlanItemsDtoList.get(i).getSupportedStackHolderStatusObj().getNumVal());
			}
		}
		
		if(costOfChangeItemsDtoList!=null &&  costOfChangeItemsDtoList.size()>0) {
			for(int i = 0 ; i<costOfChangeItemsDtoList.size(); i++) {
				costOfChangeItemsDtoList.get(i).setSerialNumber((i+1)+"");
				costOfChangeItemsDtoList.get(i).setApprovalStatus(costOfChangeItemsDtoList.get(i).getApprovalStatusObj().getNumVal());
			}
		}
	}
	private List<CommunicationPlan> generationCommunicationPlanReportData(
			List<CommunicationPlanDto> communicationPlanlist, ProjectBackgroundDto projectObj,
			OrganizationInfoDto organizationInfoDto) {
		List<CommunicationPlan> listCommunicationPlan = new ArrayList<>();
		if (communicationPlanlist != null && communicationPlanlist.size() > 0) {
			for (int i = 0; i < communicationPlanlist.size(); i++) {
				CommunicationPlan communicationPlan=new CommunicationPlan();
				communicationPlan
						.setStakeHolder(communicationPlanlist.get(i).getProjectStakeholders().getStakeholderName());
				communicationPlan
						.setStakeHolderType(communicationPlanlist.get(i).getProjectStakeholders().getStakeholderType());
				communicationPlan
						.setPurpose(communicationPlanlist.get(i).getPurposeOfCommunication().getNumVal());
				communicationPlan
						.setChannel(communicationPlanlist.get(i).getCommunicationChannel().getNumVal());
				communicationPlan.setFrequency(communicationPlanlist.get(i).getFrequency().getNumVal());
				communicationPlan.setPreparedBy(communicationPlanlist.get(i).getPreparedBy());
				communicationPlan.setSentBy(communicationPlanlist.get(i).getSentBy());
				communicationPlan.setStatus(communicationPlanlist.get(i).getStatus().getNumVal());
				communicationPlan.setMessage(communicationPlanlist.get(i).getMessage());
				communicationPlan.setTiming(communicationPlanlist.get(i).getTiming());
				listCommunicationPlan.add(communicationPlan);
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
		return listCommunicationPlan;
	}
}
