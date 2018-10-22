package com.rest.smoothchange.training.plan.equipment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrainingPlanEquipmentRequestDto {

	private long trainingPlanEquipmentId;
	
	private long projectBackgroundId;

	private String  equipmentType;
	
	private String  numberRequired;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String dateRequired;

	public long getTrainingPlanEquipmentId() {
		return trainingPlanEquipmentId;
	}

	public void setTrainingPlanEquipmentId(long trainingPlanEquipmentId) {
		this.trainingPlanEquipmentId = trainingPlanEquipmentId;
	}

	public long getProjectBackgroundId() {
		return projectBackgroundId;
	}

	public void setProjectBackgroundId(long projectBackgroundId) {
		this.projectBackgroundId = projectBackgroundId;
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

	public String getDateRequired() {
		return dateRequired;
	}

	public void setDateRequired(String dateRequired) {
		this.dateRequired = dateRequired;
	}	
	
}
