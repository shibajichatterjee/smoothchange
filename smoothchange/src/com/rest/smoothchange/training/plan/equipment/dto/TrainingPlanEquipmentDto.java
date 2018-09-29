/**
 * 
 */
package com.rest.smoothchange.training.plan.equipment.dto;

import java.util.Date;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class TrainingPlanEquipmentDto extends AbstractIdentifierDTO{
	

	private ProjectBackgroundDto projectBackground;

	private String  equipmentType;
	
	private String  numberRequired;
	
	private Date dateRequired;

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getNumberRequired() {
		return numberRequired;
	}

	public void setNumberRequired(String numberRequired) {
		this.numberRequired = numberRequired;
	}

	public Date getDateRequired() {
		return dateRequired;
	}

	public void setDateRequired(Date dateRequired) {
		this.dateRequired = dateRequired;
	}
	
	
	
}
