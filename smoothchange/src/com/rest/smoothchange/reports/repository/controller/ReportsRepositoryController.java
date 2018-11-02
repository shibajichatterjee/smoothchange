package com.rest.smoothchange.reports.repository.controller;

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
@RequestMapping(value = "/reportsRepositoryAPI")
@Api(value = "Reports Repository", description = "Operations For Reports Repository")

@Transactional
public class ReportsRepositoryController {

	private static final String dateFormatter = "yyyy-MM-dd";

	@Autowired
	private ReportsRepositoryService reportsRepositoryService;

	@Autowired
	private ProjectBackgroundService projectBackgroundService;

	@ApiOperation(value = "Upload Reports Repository")
	@RequestMapping(value = "/uploadReportsRepository", method = RequestMethod.POST)
	public ResponseEntity uploadReportsRepository(@RequestParam("report") MultipartFile file,
			@RequestParam("projectId") long projectId, @RequestParam("reportType") String reportType,
			@RequestParam("generatedOrUploaded") String generatedOrUploaded, @RequestParam("dateTime") String dateTime,
			@RequestParam("comment") String comment, @RequestParam("userId") String userId) throws IOException,
			UnauthorizedException, ParseException, NoRecordsFoundException, NoEnumRecordsFoundException {

		ResponseBean responseBean = new ResponseBean();

		ReportType reportType2 = ReportType.getValue(reportType);
		if (reportType2 == null) {
			throw new NoEnumRecordsFoundException("Report type Not Present");
		}

		GeneratedOrUploaded generatedOrUploaded2 = GeneratedOrUploaded.getValue(generatedOrUploaded);
		if (generatedOrUploaded2 == null) {
			throw new NoEnumRecordsFoundException("Generated of Upload not found");
		}

		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(projectId);
		if (projectBackgroundDto != null && projectBackgroundDto.getId() != null) {
			projectBackgroundDto.setId(projectId);
			ReportsRepository reportsRepository = new ReportsRepository();
			byte[] byteArray = ImageUtil.getByteArrayFromMaltipartFormData(file);
			ReportsRepositoryDto reportsRepositoryDto = new ReportsRepositoryDto();
			reportsRepositoryDto.setComment(comment);
			if (dateTime != null && !dateTime.trim().equals("")) {
				reportsRepositoryDto.setDateTime(DateUtil.getFormattedDate(dateTime, dateFormatter));
			}
			reportsRepositoryDto.setGeneratedOrUploaded(generatedOrUploaded);
			reportsRepositoryDto.setProjectBackground(projectBackgroundDto);
			reportsRepositoryDto.setReportFile(byteArray);
			reportsRepositoryDto.setReportFileSize(file.getSize());
			reportsRepositoryDto.setReportType(reportType);
			reportsRepositoryDto.setUserId(userId);
			long reportsRepositoryId = (Long) reportsRepositoryService.create(reportsRepositoryDto);
			reportsRepository.setId(reportsRepositoryId);
			reportsRepository.setReportFileSize(reportsRepositoryDto.getReportFileSize());
			responseBean.setBody(reportsRepository);
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}

		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "download Reports Repository")
	@RequestMapping(value = "/downloadReportsRepository", method = RequestMethod.GET)
	public ResponseEntity uploadReportsRepository(@RequestParam("id") long id, HttpServletResponse httpServletResponse)
			throws IOException, UnauthorizedException, ParseException, NoRecordsFoundException {

		ResponseBean responseBean = new ResponseBean();
		ReportsRepositoryDto reportsRepository = reportsRepositoryService.getById(id);
		if (reportsRepository != null && reportsRepository.getId() != null) {
			String fileName = DateUtil.getFormattedDateStringFromDate(new Date(), dateFormatter) + "-"
					+ reportsRepository.getId();
			ImageUtil.downloadFile(httpServletResponse, reportsRepository.getReportFile(), fileName);
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "Get Report Detail By Report Type And Project Id")
	@RequestMapping(value = "getAllReportInfoByTypeAndProjectId", method = RequestMethod.GET)
	public ResponseEntity getAllReportInfoByTypeAndProjectId(@RequestParam("type") String reportType,
			@RequestParam("projectId") long projectId)
			throws NoEnumRecordsFoundException, NoRecordsFoundException, ParseException {

		ResponseBean responseBean = new ResponseBean();
		ReportType reportType2 = ReportType.getValue(reportType);
		if (reportType2 == null) {
			throw new NoEnumRecordsFoundException("Report type Not Present");
		}
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
	public ResponseEntity getAllReportInfoByTypeAndProjectId(@RequestParam("id") long id)
			throws NoEnumRecordsFoundException, NoRecordsFoundException, ParseException {
		ResponseBean responseBean = new ResponseBean();
		ReportsRepositoryDto reportsRepository = reportsRepositoryService.getById(id);
		if (reportsRepository != null && reportsRepository.getId() != null) {
			reportsRepositoryService.delete(reportsRepository);
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
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
