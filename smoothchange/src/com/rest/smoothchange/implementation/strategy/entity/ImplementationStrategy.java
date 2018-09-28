/**
 * 
 */
package com.rest.smoothchange.implementation.strategy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rest.framework.entity.AbstractPersistentObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Entity
@Table(name = "IMPACT_ANALYSIS")
public class ImplementationStrategy extends AbstractPersistentObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;
	
	@Column(name="activity")
	private String activity;
	
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
	
	@Column(name="lead_contact_address")
	private String leadContactAddress;
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProjectBackground getProjectBackground() {
		return projectBackground;
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

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}	

}
