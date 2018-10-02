package com.rest.smoothchange.communication.plan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommunicationPlanRequestDto {
	
	private Long projectstakeHolderId;
	private String purposeOfCommunication;
	
	private String message;
	
	private String communicationChannel;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

	private String timingOrDate;
	
	private String frequency;
	
	private String preparedBy;
	
	private String sentBy;
	
	private String status;

	public Long getProjectstakeHolderId() {
		return projectstakeHolderId;
	}

	public void setProjectstakeHolderId(Long projectstakeHolderId) {
		this.projectstakeHolderId = projectstakeHolderId;
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

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Long id; 

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
}





