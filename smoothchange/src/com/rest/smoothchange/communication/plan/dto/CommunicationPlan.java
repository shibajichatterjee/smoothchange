package com.rest.smoothchange.communication.plan.dto;

import com.rest.smoothchange.util.Status;

public class CommunicationPlan {

	private String stakeholder;
	private String stakeholderType;


	private String purpose;

	private String message;

	private String channel;

	private String timing;

	private String frequency;

	

	public String getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder(String stakeholder) {
		this.stakeholder = stakeholder;
	}

	public String getStakeholderType() {
		return stakeholderType;
	}

	public void setStakeholderType(String stakeholderType) {
		this.stakeholderType = stakeholderType;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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



	private String preparedBy;

	private String sentBy;

	private String status;

}
