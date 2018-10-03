/**
 * 
 */
package com.rest.smoothchange.action.plan.items.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractPersistentObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.ActionType;

@Entity
@Table(name = "ACTION_PLAN_ITEMS")
public class ActionPlanItems extends AbstractPersistentObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;

	@Enumerated(EnumType.ORDINAL)
	private ActionType actionType;
	
	@Column(name="action")
	private String action;
	
	@Column(name="responsible")
	private String responsible;
	
	@Column(name="timeframe")
	private String timeframe;

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
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

	public String getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(String timeframe) {
		this.timeframe = timeframe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
