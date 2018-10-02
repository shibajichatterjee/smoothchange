package com.rest.smoothchange.implementation.strategy.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ImplementationStrategyRequestDto {

	private String activity;

	private String strategicObjective;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate;

	private String expectedResult;

	private String leadContactName;

private String leadContactDesignation;
	
	private long noOfRequiredResources;

	public String getLeadContactDesignation() {
		return leadContactDesignation;
	}

	public void setLeadContactDesignation(String leadContactDesignation) {
		this.leadContactDesignation = leadContactDesignation;
	}

	

	public long getNoOfRequiredResources() {
		return noOfRequiredResources;
	}

	public void setNoOfRequiredResources(long noOfRequiredResources) {
		this.noOfRequiredResources = noOfRequiredResources;
	}
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getStrategicObjective() {
		return strategicObjective;
	}

	public void setStrategicObjective(String strategicObjective) {
		this.strategicObjective = strategicObjective;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	public String getLeadContactName() {
		return leadContactName;
	}

	public void setLeadContactName(String leadContactName) {
		this.leadContactName = leadContactName;
	}

	
}
