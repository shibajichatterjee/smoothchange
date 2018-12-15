/**
 * 
 */
package com.rest.smoothchange.poti.blueprint.dto;

import java.util.Date;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class PotiBlueprintDto extends AbstractIdentifierDTO{
	
	private static final long serialVersionUID = 1L;

	private ProjectBackgroundDto projectBackground;
	
	private String potiComponent;
	
	private String asIsState;
	
	private String interimState;
	
	private Date asIsToInterimStartDate;
	
	private Date asIsToInterimEndDate;
	
	private String toBeState;
	
	private Date interimToTobeStartDate;

	private Date interimToTobeEndDate;
	
	private String howToAchieve;

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getPotiComponent() {
		return potiComponent;
	}

	public void setPotiComponent(String potiComponent) {
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