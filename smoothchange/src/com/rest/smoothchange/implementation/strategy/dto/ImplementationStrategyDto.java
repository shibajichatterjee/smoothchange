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
	
	private String leadContactAddress;

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

	public String getLeadContactAddress() {
		return leadContactAddress;
	}

	public void setLeadContactAddress(String leadContactAddress) {
		this.leadContactAddress = leadContactAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}

