/**
 * 
 */
package com.rest.smoothchange.support.plan.items.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.support.plan.dto.SupportPlanDto;
import com.rest.smoothchange.util.SupportedStackHolderStatus;


public class SupportPlanItemsDto extends AbstractIdentifierDTO{
	

	public SupportPlanDto supportPlan;
	
	private String  supportActivity;
	
	private String  duration;
	
	private SupportedStackHolderStatus supportedStackHolderStatus;
	
	private String  personResponsible;
	
    private String  comments;

	public SupportPlanDto getSupportPlan() {
		return supportPlan;
	}

	public void setSupportPlan(SupportPlanDto supportPlan) {
		this.supportPlan = supportPlan;
	}

	public String getSupportActivity() {
		return supportActivity;
	}

	public void setSupportActivity(String supportActivity) {
		this.supportActivity = supportActivity;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public SupportedStackHolderStatus getSupportedStackHolderStatus() {
		return supportedStackHolderStatus;
	}

	public void setSupportedStackHolderStatus(SupportedStackHolderStatus supportedStackHolderStatus) {
		this.supportedStackHolderStatus = supportedStackHolderStatus;
	}

	public String getPersonResponsible() {
		return personResponsible;
	}

	public void setPersonResponsible(String personResponsible) {
		this.personResponsible = personResponsible;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
    
    
	
}
