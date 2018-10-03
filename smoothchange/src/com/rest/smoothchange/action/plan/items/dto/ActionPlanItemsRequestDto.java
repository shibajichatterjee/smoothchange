package com.rest.smoothchange.action.plan.items.dto;

public class ActionPlanItemsRequestDto {

	private Long projectStakeholdersId;
	
	private String actionType;

	private String action;

	private String responsible;
	
	private String timeframe;

	public Long getProjectStakeholdersId() {
		return projectStakeholdersId;
	}

	public void setProjectStakeholdersId(Long projectStakeholdersId) {
		this.projectStakeholdersId = projectStakeholdersId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(String timeframe) {
		this.timeframe = timeframe;
	}
	
}
