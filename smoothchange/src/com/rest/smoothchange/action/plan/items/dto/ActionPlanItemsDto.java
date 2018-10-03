/**
 * 
 */
package com.rest.smoothchange.action.plan.items.dto;

import com.rest.framework.dto.AbstractDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.util.ActionType;


public class ActionPlanItemsDto extends AbstractDTO{
	
	private static final long serialVersionUID = 1L;

	private ProjectBackgroundDto projectBackground;

	private String actionType;
	
	private String action;

	private String responsible;
	
	private String timeframe;

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
