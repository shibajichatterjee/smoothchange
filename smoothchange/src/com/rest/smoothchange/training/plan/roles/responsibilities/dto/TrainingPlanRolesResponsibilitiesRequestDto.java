package com.rest.smoothchange.training.plan.roles.responsibilities.dto;

public class TrainingPlanRolesResponsibilitiesRequestDto {

	private long trainingPlanRolesResponsibilitiesId;

	private String name;
	
	private String role;
	
	private String responsibility;

	public long getTrainingPlanRolesResponsibilitiesId() {
		return trainingPlanRolesResponsibilitiesId;
	}

	public void setTrainingPlanRolesResponsibilitiesId(long trainingPlanRolesResponsibilitiesId) {
		this.trainingPlanRolesResponsibilitiesId = trainingPlanRolesResponsibilitiesId;
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

}
