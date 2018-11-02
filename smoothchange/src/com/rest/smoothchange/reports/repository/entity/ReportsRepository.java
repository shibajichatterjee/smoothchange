/**
 * 
 */
package com.rest.smoothchange.reports.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.GeneratedOrUploaded;
import com.rest.smoothchange.util.ReportType;

@Entity
@Table(name = "REPORTS_REPOSITORY")
public class ReportsRepository extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;
	
	@Enumerated(EnumType.ORDINAL)
    private ReportType reportType;
	
	@Enumerated(EnumType.ORDINAL)
	private GeneratedOrUploaded generatedOrUploaded;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_Time")
	private Date dateTime;
	
	@Column(name="report_file" , length = 1000000)
	private byte[] reportFile;
	
	@Column(name="report_file_size")
	private long reportFileSize;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="user_id")
	private String userId;

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

	public GeneratedOrUploaded getGeneratedOrUploaded() {
		return generatedOrUploaded;
	}

	public void setGeneratedOrUploaded(GeneratedOrUploaded generatedOrUploaded) {
		this.generatedOrUploaded = generatedOrUploaded;
	}

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

	
	
	

}
