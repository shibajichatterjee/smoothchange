/**
 * 
 */
package com.rest.smoothchange.support.plan.items.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.support.plan.entity.SupportPlan;
import com.rest.smoothchange.util.SupportedStackHolderStatus;

@Entity
@Table(name = "SUPPORT_PLAN_ITEMS")
public class SupportPlanItems extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@JoinColumn(name="support_plan_id")
	@ManyToOne
	public SupportPlan supportPlan;
	
	
	@Column(name="support_activity")
	private String  supportActivity;
	
	@Column(name="duration")
	private String  duration;
	
	@Enumerated(EnumType.ORDINAL)
	private SupportedStackHolderStatus supportedStackHolderStatus;
	
	@Column(name="person_responsible")
	private String  personResponsible;
	
	@Column(name="comments")
	private String  comments;

	public SupportPlan getSupportPlan() {
		return supportPlan;
	}

	public void setSupportPlan(SupportPlan supportPlan) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
