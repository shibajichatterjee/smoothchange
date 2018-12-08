package com.rest.smoothchange.report.template.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity uploadReportsTemplate(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("report") MultipartFile file,
			@RequestParam("reportType") String reportType, @RequestParam("comment") String comment,
			@RequestParam("userId") String userId) throws IOException, UnauthorizedException, ParseException,
			NoRecordsFoundException, NoEnumRecordsFoundException {

		ResponseBean responseBean = new ResponseBean();
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ReportType reportType2 = ReportType.getValue(reportType);
		if (reportType2 == null) {
			throw new NoEnumRecordsFoundException("Report type Not Present");
		}
		List<ReportTemplateDto> reportTemplateDtoList = reportTemplateService.getReportTemplateDetailByTypeAndProjectId(reportType2);
		byte[] byteArray = ImageUtil.getByteArrayFromMaltipartFormData(file);
		ReportTemplateDto reportTemplateDto = new ReportTemplateDto();
		reportTemplateDto.setComment(comment);
		reportTemplateDto.setUploadedOn(new Date());
		reportTemplateDto.setTemplateFile(byteArray);
		reportTemplateDto.setTemplateFileSize(file.getSize());
		reportTemplateDto.setReportType(reportType);
		reportTemplateDto.setUserId(userId);
		reportTemplateDto.setId(reportTemplateDtoList.get(0).getId());
		if (reportTemplateDtoList == null || reportTemplateDtoList.size() == 0) {

			long reportsRepositoryId = (Long) reportTemplateService.create(reportTemplateDto);
		} else {
			reportTemplateService.update(reportTemplateDto);
		}

		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());

		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "download Reports Template")
	@RequestMapping(value = "/downloadReportsTemplate", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadReportsTemplate(@RequestHeader("API-KEY") String apiKey, @RequestParam("id") long id,
			HttpServletResponse httpServletResponse)
			throws IOException, UnauthorizedException, ParseException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ResponseBean responseBean = new ResponseBean();
		ReportTemplateDto reportTemplateDto = reportTemplateService.getById(id);
		/*if (reportTemplateDto != null && reportTemplateDto.getId() != null) {
			String fileName = "ReportTemplate_" + DateUtil.getFormattedDateStringFromDate(new Date(), dateFormatter)
					+ "-" + reportTemplateDto.getId();
			//ImageUtil.downloadFile(httpServletResponse, reportTemplateDto.getTemplateFile(), fileName);
			
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());
		}*/
		if (reportTemplateDto == null && reportTemplateDto.getId() == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());

		}
		String fileName = "ReportTemplate_" + DateUtil.getFormattedDateStringFromDate(new Date(), dateFormatter)
		+ "-" + reportTemplateDto.getId();
	      ByteArrayResource resource = new ByteArrayResource(reportTemplateDto.getTemplateFile());

	      return ResponseEntity.ok()
	              .header(HttpHeaders.CONTENT_DISPOSITION,
	                    "attachment;filename=" + fileName+".docx")
	              .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(reportTemplateDto.getTemplateFile().length)
	              .body(resource);
	      }

	@ApiOperation(value = "Get Reports Template By Report Type")
	@RequestMapping(value = "getAllReportsTemplateByProjectId", method = RequestMethod.GET)
	public ResponseEntity getAllReportsTemplateByProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("type") String reportType)
			throws NoEnumRecordsFoundException, NoRecordsFoundException, ParseException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ResponseBean responseBean = new ResponseBean();
		ReportType reportType2 = ReportType.getValue(reportType);
		if (reportType2 == null) {
			throw new NoEnumRecordsFoundException("Report type Not Present");
		}
		List<ReportTemplateRequestDto> reportTemplateRequestDtoList = new ArrayList<>();
		
			List<ReportTemplateDto> reportTemplateDtoList = reportTemplateService
					.getReportTemplateDetailByTypeAndProjectId(reportType2);
			if (reportTemplateDtoList != null && reportTemplateDtoList.size() > 0) {
				for (ReportTemplateDto reportTemplateDto : reportTemplateDtoList) {
					reportTemplateRequestDtoList.add(mapReportsTemplateDtoToRequestDto(reportTemplateDto));
				}
				responseBean.setBody(reportTemplateRequestDtoList);
			} else {
				throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			}
		
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Reports Template")
	@RequestMapping(value = "deleteReportTemplate", method = RequestMethod.DELETE)
	public ResponseEntity deleteReportTemplate(@RequestHeader("API-KEY") String apiKey, @RequestParam("id") long id)
			throws NoEnumRecordsFoundException, NoRecordsFoundException, ParseException, UnauthorizedException {
		ResponseBean responseBean = new ResponseBean();
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
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
