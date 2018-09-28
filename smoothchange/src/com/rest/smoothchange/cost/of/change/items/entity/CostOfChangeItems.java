/**
 * 
 */
package com.rest.smoothchange.cost.of.change.items.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.cost.of.change.entity.CostOfChange;
import com.rest.smoothchange.util.ApprovalStatus;

@Entity
@Table(name = "COST_OF_CHANGE_ITEMS")
public class CostOfChangeItems extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@JoinColumn(name="cost_of_change_id")
	@ManyToOne
	private CostOfChange costOfChange;
	
	@Column(name="change_activity")
	private String changeActivity;
	
	@Column(name="cost")
	private Double cost;
	
	@Column(name="approver")
	private String approver;
	
	@Enumerated(EnumType.ORDINAL)
	private ApprovalStatus approvalStatus;

	public CostOfChange getCostOfChange() {
		return costOfChange;
	}

	public void setCostOfChange(CostOfChange costOfChange) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
