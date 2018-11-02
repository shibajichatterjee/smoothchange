package com.rest.smoothchange.report.template.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReportTemplateRequestDto {
	
	private long reportTemplateId; 
	
    private String reportType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String uploadedOn;
	
	private String templateFile;
	
	private long templateFileSize;
	
	private String comment;
	
	private String userId;

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(String uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	public String getTemplateFile() {
		return templateFile;
	}

	public void setTemplateFile(String templateFile) {
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

	public long getReportTemplateId() {
		return reportTemplateId;
	}

	public void setReportTemplateId(long reportTemplateId) {
		this.reportTemplateId = reportTemplateId;
	}

}
