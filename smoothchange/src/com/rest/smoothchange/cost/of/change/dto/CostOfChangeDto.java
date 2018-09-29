/**
 * 
 */
package com.rest.smoothchange.cost.of.change.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class CostOfChangeDto extends AbstractIdentifierDTO{

	private ProjectBackgroundDto  projectBackground;

	private Double totalCost;


	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
