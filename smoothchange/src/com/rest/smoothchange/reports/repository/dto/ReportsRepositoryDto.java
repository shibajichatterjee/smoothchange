/**
 * 
 */
package com.rest.smoothchange.reports.repository.dto;

import java.util.Date;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class ReportsRepositoryDto extends AbstractIdentifierDTO{
	
	private static final long serialVersionUID = 1L;

	private ProjectBackgroundDto projectBackground;
	
    private String reportType;
	
	private String generatedOrUploaded;
	
	private Date dateTime;
	
	private byte[] reportFile;
	
	private long reportFileSize;
	
	private String comment;
	
	private String userId;

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public byte[] getReportFile() {
		return reportFile;
	}

	public void setReportFile(byte[] reportFile) {
		this.reportFile = reportFile;
	}	

	public long getReportFileSize() {
		return reportFileSize;
	}

	public void setReportFileSize(long reportFileSize) {
		this.reportFileSize = reportFileSize;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}


}
