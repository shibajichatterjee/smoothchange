/**
 * 
 */
package com.rest.smoothchange.training.plan.roles.responsibilities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Entity
@Table(name = "TRAINING_PLAN_ROLES_RESPONSIBILITIES")
public class TrainingPlanRolesResponsibilities extends AbstractIdentifierObject{
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;

	@Column(name="name")
	private String name;
	
	@Column(name="role")
	private String role;
	
	@Column(name="responsibility")
	private String responsibility;

	
	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	
}
