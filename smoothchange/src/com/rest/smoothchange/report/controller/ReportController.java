package com.rest.smoothchange.report.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wickedsource.docxstamper.DocxStamper;
import org.wickedsource.docxstamper.DocxStamperConfiguration;

import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoEnumRecordsFoundException;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.report.dto.ProjectReportDto;
import com.rest.smoothchange.report.template.dto.ReportTemplateDto;
import com.rest.smoothchange.report.template.service.ReportTemplateService;
import com.rest.smoothchange.reports.repository.dto.ReportsRepositoryDto;
import com.rest.smoothchange.reports.repository.service.ReportsRepositoryService;
import com.rest.smoothchange.util.CommonUtil;
import com.rest.smoothchange.util.ReportType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/reportAPI")
@Api(value = "All Module Report")

@Transactional
public class ReportController {
	@Autowired
	private ReportsRepositoryService reportsRepositoryService;
	@Autowired
	private ProjectBackgroundService projectService;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private ReportTemplateService reportTemplateService;

	@ApiOperation(value = "Generate Report")
	@SuppressWarnings("unchecked")
	@GetMapping("/generateReport")
	public ResponseEntity generateReport(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestParam("reportType") String reportType,HttpServletRequest request)
			throws NoRecordsFoundException, UnauthorizedException, IOException {
		ResponseBean responseBean = new ResponseBean();

		try {
			DocxStamper stamper = new DocxStamper(new DocxStamperConfiguration());
			if (!apiKey.equals(MessageEnum.API_KEY)) {
				throw new UnauthorizedException(MessageEnum.unathorized);
			}
			ReportType reportType2 = ReportType.getValue(reportType);
			if (reportType2 == null) {
				throw new NoEnumRecordsFoundException("Report type Not Present");
			}
			commonUtil.getProjectBackGround(id);
			ProjectBackgroundDto pr = projectService.getById(Long.parseLong(id));

			ProjectReportDto context = new ProjectReportDto();
			context.setPname(pr.getProjectName());
			context.setPowner(pr.getOwnerOfChange());
			context.setPdescription(pr.getProjectDescription());
			context.setPcontact(pr.getContactPerson());
			context.setPtype(pr.getTypeOfChange());
			List<ReportTemplateDto> reportTemplateDtoList = reportTemplateService
					.getReportTemplateDetailByTypeAndProjectId(reportType2, Long.parseLong(id));
			if (reportTemplateDtoList != null && reportTemplateDtoList.size() > 0) {
				InputStream is = new ByteArrayInputStream(reportTemplateDtoList.get(0).getTemplateFile());
				ServletContext sContext = request.getServletContext();
		        String appPath = sContext.getRealPath("");
		        //String fullPath = appPath + "/download/out.docx";
		        OutputStream out = new FileOutputStream("out.docx");

				stamper.stamp(is, context, out);
				out.close();
				ReportsRepositoryDto reportsRepositoryDto = new ReportsRepositoryDto();
				reportsRepositoryDto.setComment("Auto");
				reportsRepositoryDto.setDateTime(new Date());
				reportsRepositoryDto.setGeneratedOrUploaded("Generated");
				reportsRepositoryDto.setProjectBackground(new ProjectBackgroundDto());
				reportsRepositoryDto.getProjectBackground().setId(Long.parseLong(id));
				FileInputStream inputStream = new FileInputStream("out.docx");
				reportsRepositoryDto.setReportFile(IOUtils.toByteArray(inputStream));
				reportsRepositoryDto.setReportFileSize(inputStream.available());
				reportsRepositoryDto.setReportType(reportType);
				reportsRepositoryDto.setUserId("123456");
				long reportsRepositoryId = (Long) reportsRepositoryService.create(reportsRepositoryDto);
			}

			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@ApiOperation(value = "Generate and Download Report")
	@SuppressWarnings("unchecked")
	@GetMapping("/generateAndDownloadReport")
	public ResponseEntity<ByteArrayResource> generateAndDownloadReport(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestParam("reportType") String reportType,HttpServletRequest request)
			throws NoRecordsFoundException, UnauthorizedException, IOException {
		ResponseBean responseBean = new ResponseBean();

		try {
			if (!apiKey.equals(MessageEnum.API_KEY)) {
				throw new UnauthorizedException(MessageEnum.unathorized);
			}
			ReportType reportType2 = ReportType.getValue(reportType);
			if (reportType2 == null) {
				throw new NoEnumRecordsFoundException("Report type Not Present");
			}
			commonUtil.getProjectBackGround(id);
			ProjectBackgroundDto pr = projectService.getById(Long.parseLong(id));

			ProjectReportDto context = new ProjectReportDto();
			context.setPname(pr.getProjectName());
			context.setPowner(pr.getOwnerOfChange());
			context.setPdescription(pr.getProjectDescription());
			context.setPcontact(pr.getContactPerson());
			context.setPtype(pr.getTypeOfChange());
			
			  XWPFDocument document = new XWPFDocument(); 
			  FileOutputStream out = new FileOutputStream(new File("out.docx"));
		      XWPFParagraph paragraph = document.createParagraph();
		      XWPFParagraph paragraph1 = document.createParagraph();

		      XWPFRun run = paragraph.createRun();
		      XWPFRun run1 = paragraph1.createRun();
		      run.setText("Welcome to my channel. Chillyfacts.com created word document. Test test");
		      run1.setText("Welcome to my channel");
		      //create table
		      XWPFTable table = document.createTable();
		      //create first row
		      XWPFTableRow tableRowOne = table.getRow(0);
		      tableRowOne.getCell(0).setText("col one, row one");
		      tableRowOne.addNewTableCell().setText("col two, row one");
		      tableRowOne.addNewTableCell().setText("col three, row one");
		      //create second row
		      XWPFTableRow tableRowTwo = table.createRow();
		      tableRowTwo.getCell(0).setText("col one, row two");
		      tableRowTwo.getCell(1).setText("col two, row two");
		      tableRowTwo.getCell(2).setText("col three, row two");
		      //create third row
		      XWPFTableRow tableRowThree = table.createRow();
		      tableRowThree.getCell(0).setText("col one, row three");
		      tableRowThree.getCell(1).setText("col two, row three");
		      tableRowThree.getCell(2).setText("col three, row three");
		      XWPFRun paragraphOneRunThree = paragraph.createRun();
		     // paragraphOneRunThree.setStrike(true);
		      paragraphOneRunThree.setFontSize(30);
		      paragraphOneRunThree.setSubscript(VerticalAlign.SUBSCRIPT);
		      paragraphOneRunThree.setText(" Font Styles");
			  document.write(out);
		      out.close();
		      System.out.println("createparagraph.docx written successfully");
			} catch (Exception e) {
				// TODO: handle exception
			}
		Path path = Paths.get("out.docx");
	      byte[] data = Files.readAllBytes(path);
	      ByteArrayResource resource = new ByteArrayResource(data);
	      return ResponseEntity.ok()
	              .header(HttpHeaders.CONTENT_DISPOSITION,
	                    "attachment;filename=" + path.getFileName().toString())
	              .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(data.length)
	              .body(resource);
		
		//return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);


		
	}


}
