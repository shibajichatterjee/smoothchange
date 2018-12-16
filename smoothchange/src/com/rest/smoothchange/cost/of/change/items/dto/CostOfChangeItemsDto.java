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
	
	private ApprovalStatus approvalStatusObj;
	
	//========== Report  ========
	
	private String serialNumber;
	
	private String approvalStatus;
	//=========== End Report =========

	
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

	public ApprovalStatus getApprovalStatusObj() {
		return approvalStatusObj;
	}

	public void setApprovalStatusObj(ApprovalStatus approvalStatusObj) {
		this.approvalStatusObj = approvalStatusObj;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
}
