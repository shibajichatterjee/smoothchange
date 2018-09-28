/**
 * 
 */
package com.rest.smoothchange.communication.plan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractPersistentObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;
import com.rest.smoothchange.util.Frequency;
import com.rest.smoothchange.util.Status;

@Entity
@Table(name = "COMMUNICATION_PLAN")
public class CommunicationPlan extends AbstractPersistentObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;
	
	@ManyToOne
	@JoinColumn(name="stakeholder_id")
	private ProjectStakeholders projectStakeholders;
	

	@Column(name = "purpose_of_communication")
	private String purposeOfCommunication;
	
	@Column(name="message")
	private String message;
	
	
	@Column(name="communication_channel")
	private String communicationChannel;
	
	@Column(name="timing_or_date")
	private String timingOrDate;
	
	@Enumerated(EnumType.ORDINAL)
	private Frequency frequency;
	
	@Column(name="prepared_by")
	private String preparedBy;
	
	@Column(name="sent_by")
	private String sentBy;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	public ProjectStakeholders getProjectStakeholders() {
		return projectStakeholders;
	}

	public void setProjectStakeholders(ProjectStakeholders projectStakeholders) {
		this.projectStakeholders = projectStakeholders;
	}

	public String getPurposeOfCommunication() {
		return purposeOfCommunication;
	}

	public void setPurposeOfCommunication(String purposeOfCommunication) {
		this.purposeOfCommunication = purposeOfCommunication;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCommunicationChannel() {
		return communicationChannel;
	}

	public void setCommunicationChannel(String communicationChannel) {
		this.communicationChannel = communicationChannel;
	}

	public String getTimingOrDate() {
		return timingOrDate;
	}

	public void setTimingOrDate(String timingOrDate) {
		this.timingOrDate = timingOrDate;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public String getSentBy() {
		return sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
