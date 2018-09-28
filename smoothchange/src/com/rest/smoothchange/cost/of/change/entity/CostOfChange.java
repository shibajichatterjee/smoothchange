/**
 * 
 */
package com.rest.smoothchange.cost.of.change.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;

@Entity
@Table(name = "COST_OF_CHANGE")
public class CostOfChange extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@JoinColumn(name="change_management_plan_id")
	@ManyToOne
	private ChangeManagementPlan  changeManagementPlan;
	
	
	@Column(name="total_cost")
	private Double totalCost;


	public ChangeManagementPlan getChangeManagementPlan() {
		return changeManagementPlan;
	}


	public void setChangeManagementPlan(ChangeManagementPlan changeManagementPlan) {
		this.changeManagementPlan = changeManagementPlan;
	}


	public Double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
