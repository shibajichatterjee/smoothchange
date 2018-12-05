/**
 * 
 */
package com.rest.smoothchange.poti.blueprint.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.PotiComponentType;

@Entity
@Table(name = "POTI_BLUEPRINT")
public class PotiBlueprint extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@JoinColumn(name="project_id")
	@ManyToOne
	private ProjectBackground projectBackground;
	
	@Enumerated(EnumType.ORDINAL)
	private PotiComponentType potiComponent;
	
	@Column(name="as_is_state")
	private String asIsState;
	
	@Column(name="interim_state")
	private String interimState;
	
	@Temporal(TemporalType.DATE)
	@Column(name="as_is_to_interim_start_date")
	private Date asIsToInterimStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="as_is_to_interim_end_date")
	private Date asIsToInterimEndDate;
	
	@Column(name="to_be_state")
	private String toBeState;
	
	@Temporal(TemporalType.DATE)
	@Column(name="interim_to_tobe_start_date")
	private Date interimToTobeStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="interim_to_tobe_end_date")
	private Date interimToTobeEndDate;
	
	@Column(name="how_to_achieve")
	private String howToAchieve;

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	public PotiComponentType getPotiComponent() {
		return potiComponent;
	}

	public void setPotiComponent(PotiComponentType potiComponent) {
		this.potiComponent = potiComponent;
	}

	public String getAsIsState() {
		return asIsState;
	}

	public void setAsIsState(String asIsState) {
		this.asIsState = asIsState;
	}

	public String getInterimState() {
		return interimState;
	}

	public void setInterimState(String interimState) {
		this.interimState = interimState;
	}

	public Date getAsIsToInterimStartDate() {
		return asIsToInterimStartDate;
	}

	public void setAsIsToInterimStartDate(Date asIsToInterimStartDate) {
		this.asIsToInterimStartDate = asIsToInterimStartDate;
	}

	public Date getAsIsToInterimEndDate() {
		return asIsToInterimEndDate;
	}

	public void setAsIsToInterimEndDate(Date asIsToInterimEndDate) {
		this.asIsToInterimEndDate = asIsToInterimEndDate;
	}

	public String getToBeState() {
		return toBeState;
	}

	public void setToBeState(String toBeState) {
		this.toBeState = toBeState;
	}

	public Date getInterimToTobeStartDate() {
		return interimToTobeStartDate;
	}

	public void setInterimToTobeStartDate(Date interimToTobeStartDate) {
		this.interimToTobeStartDate = interimToTobeStartDate;
	}

	public Date getInterimToTobeEndDate() {
		return interimToTobeEndDate;
	}

	public void setInterimToTobeEndDate(Date interimToTobeEndDate) {
		this.interimToTobeEndDate = interimToTobeEndDate;
	}

	public String getHowToAchieve() {
		return howToAchieve;
	}

	public void setHowToAchieve(String howToAchieve) {
		this.howToAchieve = howToAchieve;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	
}
