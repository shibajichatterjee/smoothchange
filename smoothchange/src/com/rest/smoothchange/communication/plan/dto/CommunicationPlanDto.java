/**
 * 
 */
package com.rest.smoothchange.communication.plan.dto;

import javax.persistence.Column;

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
	private String purposeOfCommunicationOther;
	private String communicationChannelOther;
	public String getPurposeOfCommunicationOther() {
		return purposeOfCommunicationOther;
	}

	public void setPurposeOfCommunicationOther(String purposeOfCommunicationOther) {
		this.purposeOfCommunicationOther = purposeOfCommunicationOther;
	}

	public String getCommunicationChannelOther() {
		return communicationChannelOther;
	}

	public void setCommunicationChannelOther(String communicationChannelOther) {
		this.communicationChannelOther = communicationChannelOther;
	}

	public String getFrequencyOther() {
		return frequencyOther;
	}

	public void setFrequencyOther(String frequencyOther) {
		this.frequencyOther = frequencyOther;
	}

	private String frequencyOther;
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
	
	private String stakeHolder;
	public String getStakeHolder() {
		return stakeHolder;
	}

	public void setStakeHolder(String stakeHolder) {
		this.stakeHolder = stakeHolder;
	}

	public String getStakeHolderType() {
		return stakeHolderType;
	}

	public void setStakeHolderType(String stakeHolderType) {
		this.stakeHolderType = stakeHolderType;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	private String stakeHolderType;
	private String purpose;
	private String channel;
	private String timing;


}
