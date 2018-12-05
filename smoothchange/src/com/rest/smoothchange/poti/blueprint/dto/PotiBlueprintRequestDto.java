package com.rest.smoothchange.poti.blueprint.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PotiBlueprintRequestDto {
	
    private long id;
	
	private String potiComponent;
	
	private String asIsState;
	
	private String interimState;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String asIsToInterimStartDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String asIsToInterimEndDate;
	
	private String toBeState;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String interimToTobeStartDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String interimToTobeEndDate;
	
	private String howToAchieve;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getAsIsToInterimStartDate() {
		return asIsToInterimStartDate;
	}

	public void setAsIsToInterimStartDate(String asIsToInterimStartDate) {
		this.asIsToInterimStartDate = asIsToInterimStartDate;
	}

	public String getAsIsToInterimEndDate() {
		return asIsToInterimEndDate;
	}

	public void setAsIsToInterimEndDate(String asIsToInterimEndDate) {
		this.asIsToInterimEndDate = asIsToInterimEndDate;
	}

	public String getToBeState() {
		return toBeState;
	}

	public void setToBeState(String toBeState) {
		this.toBeState = toBeState;
	}

	public String getInterimToTobeStartDate() {
		return interimToTobeStartDate;
	}

	public void setInterimToTobeStartDate(String interimToTobeStartDate) {
		this.interimToTobeStartDate = interimToTobeStartDate;
	}

	public String getInterimToTobeEndDate() {
		return interimToTobeEndDate;
	}

	public void setInterimToTobeEndDate(String interimToTobeEndDate) {
		this.interimToTobeEndDate = interimToTobeEndDate;
	}

	public String getHowToAchieve() {
		return howToAchieve;
	}

	public void setHowToAchieve(String howToAchieve) {
		this.howToAchieve = howToAchieve;
	}
	
}
