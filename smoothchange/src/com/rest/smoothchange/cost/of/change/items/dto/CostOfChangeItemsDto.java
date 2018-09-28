/**
 * 
 */
package com.rest.smoothchange.cost.of.change.items.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.cost.of.change.dto.CostOfChangeDto;
import com.rest.smoothchange.util.ApprovalStatus;


public class CostOfChangeItemsDto extends AbstractIdentifierDTO{
	

	private CostOfChangeDto costOfChange;
	
	private String changeActivity;
	
	private Double cost;
	
	private String approver;
	
	private ApprovalStatus approvalStatus;

	
	public CostOfChangeDto getCostOfChange() {
		return costOfChange;
	}

	public void setCostOfChange(CostOfChangeDto costOfChange) {
		this.costOfChange = costOfChange;
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

	public ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
		
}
