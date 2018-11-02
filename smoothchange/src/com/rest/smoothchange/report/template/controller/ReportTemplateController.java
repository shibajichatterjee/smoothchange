package com.rest.smoothchange.report.template.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.report.template.dto.ReportTemplateDto;
import com.rest.smoothchange.report.template.dto.ReportTemplateRequestDto;
import com.rest.smoothchange.report.template.service.ReportTemplateService;
import com.rest.smoothchange.reports.repository.dto.ReportsRepositoryDto;
import com.rest.smoothchange.reports.repository.dto.ReportsRepositoryRequestDto;
import com.rest.smoothchange.reports.repository.entity.ReportsRepository;
import com.rest.smoothchange.reports.repository.service.ReportsRepositoryService;
import com.rest.smoothchange.util.DateUtil;
import com.rest.smoothchange.util.GeneratedOrUploaded;
import com.rest.smoothchange.util.ImageUtil;
import com.rest.smoothchange.util.ReportType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/reportTemplateServiceAPI")
@Api(value = "Reports Template", description = "Operations For Reports Template")

@Transactional
public class ReportTemplateController {

	private static final String dateFormatter = "yyyy-MM-dd";

	@Autowired
	private ReportTemplateService reportTemplateService;

	@Autowired
	private ProjectBackgroundService projectBackgroundService;

	@ApiOperation(value = "Upload Reports Template")
	@RequestMapping(value = "/uploadReportsTemplate", method = RequestMethod.POST)
	public ResponseEntity uploadReportsTemplate(@RequestParam("report") MultipartFile file,
			@RequestParam("projectId") long projectId, @RequestParam("reportType") String reportType,
			@RequestParam("uploadedOn") String uploadedOn,
			@RequestParam("comment") String comment, @RequestParam("userId") String userId) throws IOException,
			UnauthorizedException, ParseException, NoRecordsFoundException, NoEnumRecordsFoundException {

		ResponseBean responseBean = new ResponseBean();

		ReportType reportType2 = ReportType.getValue(reportType);
		if (reportType2 == null) {
			throw new NoEnumRecordsFoundException("Report type Not Present");
		}

        ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(projectId);
		if (projectBackgroundDto != null && projectBackgroundDto.getId() != null) {
			projectBackgroundDto.setId(projectId);
			ReportsRepository reportsRepository = new ReportsRepository();
			byte[] byteArray = ImageUtil.getByteArrayFromMaltipartFormData(file);
			ReportTemplateDto reportTemplateDto = new ReportTemplateDto();
			reportTemplateDto.setComment(comment);
			if (uploadedOn != null && !uploadedOn.trim().equals("")) {
				reportTemplateDto.setUploadedOn(DateUtil.getFormattedDate(uploadedOn, dateFormatter));
			}
			reportTemplateDto.setProjectBackground(projectBackgroundDto);
			reportTemplateDto.setTemplateFile(byteArray);
			reportTemplateDto.setTemplateFileSize(file.getSize());
			reportTemplateDto.setReportType(reportType);
			reportTemplateDto.setUserId(userId);
			long reportsRepositoryId = (Long) reportTemplateService.create(reportTemplateDto);
			reportsRepository.setId(reportsRepositoryId);
			reportsRepository.setReportFileSize(reportTemplateDto.getTemplateFileSize());
			responseBean.setBody(reportsRepository);
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}

		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "download Reports Template")
	@RequestMapping(value = "/downloadReportsTemplate", method = RequestMethod.GET)
	public ResponseEntity downloadReportsTemplate(@RequestParam("id") long id, HttpServletResponse httpServletResponse)
			throws IOException, UnauthorizedException, ParseException, NoRecordsFoundException {

		ResponseBean responseBean = new ResponseBean();
		ReportTemplateDto reportTemplateDto = reportTemplateService.getById(id);
		if (reportTemplateDto != null && reportTemplateDto.getId() != null) {
			String fileName = "ReportTemplate_"+DateUtil.getFormattedDateStringFromDate(new Date(), dateFormatter) + "-"
					+ reportTemplateDto.getId();
			ImageUtil.downloadFile(httpServletResponse, reportTemplateDto.getTemplateFile(), fileName);
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "Get Reports Template By Report Type And Project Id")
	@RequestMapping(value = "getAllReportsTemplateByProjectId", method = RequestMethod.GET)
	public ResponseEntity getAllReportsTemplateByProjectId(@RequestParam("type") String reportType,
			@RequestParam("projectId") long projectId)
			throws NoEnumRecordsFoundException, NoRecordsFoundException, ParseException {

		ResponseBean responseBean = new ResponseBean();
		ReportType reportType2 = ReportType.getValue(reportType);
		if (reportType2 == null) {
			throw new NoEnumRecordsFoundException("Report type Not Present");
		}
		List<ReportTemplateRequestDto> reportTemplateRequestDtoList = new ArrayList<>();
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(projectId);
		if (projectBackgroundDto != null && projectBackgroundDto.getId() != null) {
			List<ReportTemplateDto> reportTemplateDtoList = reportTemplateService
					.getReportTemplateDetailByTypeAndProjectId(reportType2, projectId);
			if (reportTemplateDtoList != null && reportTemplateDtoList.size() > 0) {
				for (ReportTemplateDto reportTemplateDto : reportTemplateDtoList) {
					reportTemplateRequestDtoList.add(mapReportsTemplateDtoToRequestDto(reportTemplateDto));
				}
				responseBean.setBody(reportTemplateRequestDtoList);
			} else {
				throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			}
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Reports Template")
	@RequestMapping(value = "deleteReportTemplate", method = RequestMethod.DELETE)
	public ResponseEntity deleteReportTemplate(@RequestParam("id") long id)
			throws NoEnumRecordsFoundException, NoRecordsFoundException, ParseException {
		ResponseBean responseBean = new ResponseBean();
		ReportTemplateDto reportTemplateDto = reportTemplateService.getById(id);
		if (reportTemplateDto != null && reportTemplateDto.getId() != null) {
			reportTemplateService.delete(reportTemplateDto);
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	private ReportTemplateRequestDto mapReportsTemplateDtoToRequestDto(ReportTemplateDto reportTemplateDto)
			throws ParseException {
		ReportTemplateRequestDto ReportTemplateRequestDto = null;
		if (reportTemplateDto != null) {
			ReportTemplateRequestDto = new ReportTemplateRequestDto();
			ReportTemplateRequestDto.setComment(reportTemplateDto.getComment());
			if (reportTemplateDto.getUploadedOn() != null) {
				ReportTemplateRequestDto.setUploadedOn(
						DateUtil.getFormattedDateStringFromDate(reportTemplateDto.getUploadedOn(), dateFormatter));
			}
			ReportTemplateRequestDto.setTemplateFileSize(reportTemplateDto.getTemplateFileSize());
			ReportTemplateRequestDto.setReportTemplateId(reportTemplateDto.getId());
			ReportTemplateRequestDto.setReportType(reportTemplateDto.getReportType());
			ReportTemplateRequestDto.setUserId(reportTemplateDto.getUserId());
			if (reportTemplateDto.getTemplateFile() != null) {
				ReportTemplateRequestDto
						.setTemplateFile(ImageUtil.getBase64FromByteArray(reportTemplateDto.getTemplateFile()));
			}
		}
		return ReportTemplateRequestDto;
	}
}
