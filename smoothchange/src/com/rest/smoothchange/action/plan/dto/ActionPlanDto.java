/**
 * 
 */
package com.rest.smoothchange.action.plan.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;


public class ActionPlanDto extends AbstractIdentifierDTO{
	
	ChangeManagementPlanDto changeManagementPlan;

	public ChangeManagementPlanDto getChangeManagementPlan() {
		return changeManagementPlan;
	}

	public void setChangeManagementPlan(ChangeManagementPlanDto changeManagementPlan) {
		this.changeManagementPlan = changeManagementPlan;
	}

	
	
	
}
