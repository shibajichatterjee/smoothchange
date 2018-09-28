package com.rest.smoothchange.implementation.strategy.dto;

import java.util.Date;

import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;

public class ImplementationStrategyRequestDto {

	private String activity;

	private String strategicObjective;

	private Date startDate;

	private Date endDate;

	private String expectedResult;

	private String leadContactName;

	private String leadContactAddress;

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

	public String getLeadContactAddress() {
		return leadContactAddress;
	}

	public void setLeadContactAddress(String leadContactAddress) {
		this.leadContactAddress = leadContactAddress;
	}

}
