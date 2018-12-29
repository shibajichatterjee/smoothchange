/**
 * 
 */
package com.rest.smoothchange.implementation.strategy.entity;

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

import com.rest.framework.entity.AbstractPersistentObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.ImplementationActivity;

@Entity
@Table(name = "IMPLEMENTATION_STRATEGY")
public class ImplementationStrategy extends AbstractPersistentObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;
	
	@Enumerated(EnumType.ORDINAL)
	private ImplementationActivity activity;
	
	@Column(name="strategic_objective")
	private String strategicObjective;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="expected_result")
	private String expectedResult;
	
	@Column(name="lead_contact_name")
	private String leadContactName;
	
	@Column(name="lead_contact_designation")
    private String leadContactDesignation;
	@Column(name="no_of_required_resources")
	private long noOfRequiredResources;	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	

	public ImplementationActivity getActivity() {
		return activity;
	}

	public void setActivity(ImplementationActivity activity) {
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

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}	

}
