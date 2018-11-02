/**
 * 
 */
package com.rest.smoothchange.report.template.entity;

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
import com.rest.smoothchange.util.ReportType;

@Entity
@Table(name = "REPORT_TEMPLATE")
public class ReportTemplate extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;
	
	@Enumerated(EnumType.ORDINAL)
    private ReportType reportType;
	
	@Temporal(TemporalType.DATE)
	@Column(name="uploaded_on")
	private Date uploadedOn;
	
	@Column(name="template_file" , length = 1000000)
	private byte[] templateFile;
	
	@Column(name="template_file_size")
	private long templateFileSize;
	
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

}
