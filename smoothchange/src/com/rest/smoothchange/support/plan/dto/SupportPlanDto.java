/**
 * 
 */
package com.rest.smoothchange.support.plan.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;


public class SupportPlanDto extends AbstractIdentifierDTO{

	private ChangeManagementPlanDto changeManagementPlan;

	public ChangeManagementPlanDto getChangeManagementPlan() {
		return changeManagementPlan;
	}

	public void setChangeManagementPlan(ChangeManagementPlanDto changeManagementPlan) {
		this.changeManagementPlan = changeManagementPlan;
	}
	
	
	
}
