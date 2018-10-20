package com.rest.smoothchange.report.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wickedsource.docxstamper.DocxStamper;
import org.wickedsource.docxstamper.DocxStamperConfiguration;

import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsDto;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.report.dto.ProjectReportDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/reportAPI")
@Api(value = "All Module Report")

@Transactional
public class ReportController {
	@Autowired
	private ProjectBackgroundService projectService;

	@ApiOperation(value = "Get Report For Stake Holder")
	@SuppressWarnings("unchecked")
	@GetMapping("/GetReportForStakeHolder")
	public ResponseEntity GetReportForStakeHolder(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") String id, HttpServletRequest req)
			throws NoRecordsFoundException, UnauthorizedException, IOException {
		try {
			if (!apiKey.equals(MessageEnum.API_KEY)) {
				throw new UnauthorizedException(MessageEnum.unathorized);
			}
			ProjectBackgroundDto pr = projectService.getById(Long.parseLong(id));

			ProjectReportDto context = new ProjectReportDto();
			context.setPname(pr.getProjectName());
			context.setOwner(pr.getOwnerOfChange());
			context.setPdescription(pr.getProjectDescription());
			context.setPerson(pr.getContactPerson());
			context.setType(pr.getTypeOfChange());
			InputStream template = new FileInputStream(
					new File(req.getContextPath() + "/resources/template/business_benifit.docx"));
			OutputStream out = new FileOutputStream(
					req.getContextPath() + "/resources/template/business_benifit_output.docx");
			DocxStamper stamper = new DocxStamper(new DocxStamperConfiguration());
			stamper.stamp(template, context, out);
			out.close();
			File file = new File(req.getContextPath() + "/resources/template/business_benifit_output.docx");
			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
					.contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(file.length()).body(resource);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
