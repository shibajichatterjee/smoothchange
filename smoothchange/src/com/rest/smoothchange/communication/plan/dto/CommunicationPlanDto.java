/**
 * 
 */
package com.rest.smoothchange.communication.plan.dto;

import com.rest.framework.dto.AbstractDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.util.CommunicationChannel;
import com.rest.smoothchange.util.Frequency;
import com.rest.smoothchange.util.PurposeOfCommunication;
import com.rest.smoothchange.util.Status;

public class CommunicationPlanDto extends AbstractDTO {

	public PurposeOfCommunication getPurposeOfCommunication() {
		return purposeOfCommunication;
	}

	public void setPurposeOfCommunication(PurposeOfCommunication purposeOfCommunication) {
		this.purposeOfCommunication = purposeOfCommunication;
	}

	public CommunicationChannel getCommunicationChannel() {
		return communicationChannel;
	}

	public void setCommunicationChannel(CommunicationChannel communicationChannel) {
		this.communicationChannel = communicationChannel;
	}

	private static final long serialVersionUID = 1L;

	private ProjectBackgroundDto projectBackground;

	private ProjectStakeholdersDto projectStakeholders;

	private PurposeOfCommunication purposeOfCommunication;

	private String message;

	private CommunicationChannel communicationChannel;

	private String timingOrDate;

	private Frequency frequency;

	private String preparedBy;

	private String sentBy;

	private Status status;

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	public ProjectStakeholdersDto getProjectStakeholders() {
		return projectStakeholders;
	}

	public void setProjectStakeholders(ProjectStakeholdersDto projectStakeholders) {
		this.projectStakeholders = projectStakeholders;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
