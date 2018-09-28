/**
 * 
 */
package com.rest.smoothchange.cost.of.change.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;


public class CostOfChangeDto extends AbstractIdentifierDTO{

	private ChangeManagementPlanDto  changeManagementPlan;

	private Double totalCost;

	public ChangeManagementPlanDto getChangeManagementPlan() {
		return changeManagementPlan;
	}

	public void setChangeManagementPlan(ChangeManagementPlanDto changeManagementPlan) {
		this.changeManagementPlan = changeManagementPlan;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
