/**
 * 
 */
package com.rest.smoothchange.training.plan.equipment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Entity
@Table(name = "TRAINING_PLAN_EQUIPMENT")
public class TrainingPlanEquipment extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;
	
	@Column(name="equipment_type")
	private String  equipmentType;
	
	@Column(name="number_required")
	private String  numberRequired;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_required")
	private Date dateRequired;


	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}


	public void setProjectBackground(ProjectBackground projectBackground) {
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
  
}
