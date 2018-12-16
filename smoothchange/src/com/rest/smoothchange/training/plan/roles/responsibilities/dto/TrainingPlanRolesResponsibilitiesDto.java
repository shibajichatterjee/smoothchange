/**
 * 
 */
package com.rest.smoothchange.training.plan.roles.responsibilities.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class TrainingPlanRolesResponsibilitiesDto extends AbstractIdentifierDTO{
	
	private ProjectBackgroundDto projectBackground;

	private String name;
	
	private String role;
	
	private String responsibility;
	
	//============ Report Generation =============
	   private String serialNumber;	
	// =========== End Report Generation ========	

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
}
