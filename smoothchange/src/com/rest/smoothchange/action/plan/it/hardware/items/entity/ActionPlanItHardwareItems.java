/**
 * 
 */
package com.rest.smoothchange.action.plan.it.hardware.items.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.action.plan.entity.ActionPlan;

@Entity
@Table(name = "ACTION_PLAN_IT_SOFTWARE_ITEMS")
public class ActionPlanItHardwareItems extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@JoinColumn(name="action_plan_id")
	@ManyToOne
	private ActionPlan actionPlan;
	
	
	@Column(name="action")
	private String  action;
	
	@Column(name="responsible")
	private String  responsible;
	
	@Column(name="timeFrame")
	private String  timeFrame;

	public ActionPlan getActionPlan() {
		return actionPlan;
	}

	public void setActionPlan(ActionPlan actionPlan) {
		this.actionPlan = actionPlan;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
