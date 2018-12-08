/**
 * 
 */
package com.rest.smoothchange.report.template.dto;

import java.util.Date;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class ReportTemplateDto extends AbstractIdentifierDTO{
	
	
    private String reportType;
	
	private Date uploadedOn;
	
	private byte[] templateFile;
	
	private long templateFileSize;
	
	private String comment;
	
	private String userId;

	

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Date getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	public byte[] getTemplateFile() {
		return templateFile;
	}

	public void setTemplateFile(byte[] templateFile) {
		this.templateFile = templateFile;
	}

	public long getTemplateFileSize() {
		return templateFileSize;
	}

	public void setTemplateFileSize(long templateFileSize) {
		this.templateFileSize = templateFileSize;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
