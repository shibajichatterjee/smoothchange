/**
 * 
 */
package com.rest.smoothchange.training.plan.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class TrainingPlanDto extends AbstractIdentifierDTO{
	
	private ProjectBackgroundDto projectBackgroundDto;

	public ProjectBackgroundDto getProjectBackgroundDto() {
		return projectBackgroundDto;
	}

	public void setProjectBackgroundDto(ProjectBackgroundDto projectBackgroundDto) {
		this.projectBackgroundDto = projectBackgroundDto;
	}

	
	
}
