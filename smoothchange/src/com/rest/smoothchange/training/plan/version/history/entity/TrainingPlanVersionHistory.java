/**
 * 
 */
package com.rest.smoothchange.training.plan.version.history.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Entity
@Table(name = "TRAINING_PLAN_VERSION_HISTORY")
public class TrainingPlanVersionHistory extends AbstractIdentifierObject{
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;

	@Column(name="version_no")
	private String versionNo;
	
	@Column(name="author")
	private String author;
	
	@Temporal(TemporalType.DATE)
	@Column(name="revision_date")
	private Date revisionDate;
	
	
	@Column(name="approved_by")
	private String approvedBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name="approval_date")
	private Date approvalDate;
	
	@Column(name="reason")
	private String reason;

	
	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	

	
}
