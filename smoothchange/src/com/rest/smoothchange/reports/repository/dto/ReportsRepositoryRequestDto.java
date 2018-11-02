package com.rest.smoothchange.reports.repository.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReportsRepositoryRequestDto {
	
	private long reportsRepositoryId;
	
    private String reportType;
	
	private String generatedOrUploaded;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String dateTime;
	
	private String reportFile;
	
	private long reportFileSize;
	
	private String comment;
	
	private String userId;

	public long getReportsRepositoryId() {
		return reportsRepositoryId;
	}

	public void setReportsRepositoryId(long reportsRepositoryId) {
		this.reportsRepositoryId = reportsRepositoryId;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getGeneratedOrUploaded() {
		return generatedOrUploaded;
	}

	public void setGeneratedOrUploaded(String generatedOrUploaded) {
		this.generatedOrUploaded = generatedOrUploaded;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getReportFile() {
		return reportFile;
	}

	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
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

	public long getReportFileSize() {
		return reportFileSize;
	}

	public void setReportFileSize(long reportFileSize) {
		this.reportFileSize = reportFileSize;
	}

}
