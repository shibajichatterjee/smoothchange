/**
 * 
 */
package com.rest.smoothchange.action.plan.audit.items.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.action.plan.dto.ActionPlanDto;


public class ActionPlanAuditItemsDto extends AbstractIdentifierDTO{
	
	private ActionPlanDto actionPlan;
	
	private String  action;
	
	private String  responsible;
	
	private String  timeFrame;

	public ActionPlanDto getActionPlan() {
		return actionPlan;
	}

	public void setActionPlan(ActionPlanDto actionPlan) {
		this.actionPlan = actionPlan;
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

	public String getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}
	
}
