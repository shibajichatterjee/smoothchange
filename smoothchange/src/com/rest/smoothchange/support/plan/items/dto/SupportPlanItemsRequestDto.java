package com.rest.smoothchange.support.plan.items.dto;

public class SupportPlanItemsRequestDto {

	private String supportActivity;

	private String duration;

	private String supportedStackHolderStatus;

	private String personResponsible;

	private String comments;

	public String getSupportActivity() {
		return supportActivity;
	}

	public void setSupportActivity(String supportActivity) {
		this.supportActivity = supportActivity;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSupportedStackHolderStatus() {
		return supportedStackHolderStatus;
	}

	public void setSupportedStackHolderStatus(String supportedStackHolderStatus) {
		this.supportedStackHolderStatus = supportedStackHolderStatus;
	}

	public String getPersonResponsible() {
		return personResponsible;
	}

	public void setPersonResponsible(String personResponsible) {
		this.personResponsible = personResponsible;
	}

	public String getComments() {
		return comments;
	}
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
