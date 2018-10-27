package com.rest.smoothchange.training.plan.version.history.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrainingPlanVersionHistoryRequestDto {

	private long trainingPlanVersionHistoryId;
	
	private String versionNo;
	
	private String author;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String revisionDate;
	
	private String approvedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String approvalDate;
	
	private String reason;

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

	public String getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(String revisionDate) {
		this.revisionDate = revisionDate;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getTrainingPlanVersionHistoryId() {
		return trainingPlanVersionHistoryId;
	}

	public void setTrainingPlanVersionHistoryId(long trainingPlanVersionHistoryId) {
		this.trainingPlanVersionHistoryId = trainingPlanVersionHistoryId;
	}
	
}
