package com.rest.smoothchange.cost.of.change.items.dto;

public class CostOfChangeItemsRequestDto {


	private String changeActivity;
	
	private Double cost;
	
	private String approver;
	
	private String approvalStatus;

	private Long id; 
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getChangeActivity() {
		return changeActivity;
	}

	public void setChangeActivity(String changeActivity) {
		this.changeActivity = changeActivity;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	
		
}
