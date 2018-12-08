/**
 * 
 */
package com.rest.smoothchange.implementation.strategy.dto;

import java.util.Date;

import com.rest.framework.dto.AbstractDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class ImplementationStrategyDto extends AbstractDTO{
	
	private static final long serialVersionUID = 1L;

	private ProjectBackgroundDto projectBackground;

	private String activity;
	
	private String strategicObjective;
	
	private Date startDate;
	
	private Date endDate;
	
	private String expectedResult;
	
	private String leadContactName;
	
	private String leadContactDesignation;
	
	private long noOfRequiredResources;
	
	
	private  String serialNumber;
	private  String leadContactNameAndDesignation;
	private  String noOfResources;
	private  String expectedResults;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getLeadContactNameAndDesignation() {
		return leadContactNameAndDesignation;
	}

	public void setLeadContactNameAndDesignation(String leadContactNameAndDesignation) {
		this.leadContactNameAndDesignation = leadContactNameAndDesignation;
	}

	public String getNoOfResources() {
		return noOfResources;
	}

	public void setNoOfResources(String noOfResources) {
		this.noOfResources = noOfResources;
	}

	public String getExpectedResults() {
		return expectedResults;
	}

	public void setExpectedResults(String expectedResults) {
		this.expectedResults = expectedResults;
	}

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

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}

