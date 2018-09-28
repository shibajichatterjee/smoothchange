/**
 * 
 */
package com.rest.smoothchange.management.plan.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class ChangeManagementPlanDto extends AbstractIdentifierDTO{
	
	private ProjectBackgroundDto projectBackground;

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}
	
	

	
}
