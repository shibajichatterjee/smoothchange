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

	private ActionType actionType;
	
	private String action;

	private String responsible;
	
	private String timeFrame;
	
	//======== For Report =======
	private String serialNumber;
	//======== End Of Report =====

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
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

	public String getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
		
}
