/**
 * 
 */
package com.rest.smoothchange.management.plan.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Entity
@Table(name = "CHANGE_MANAGEMENT_PLAN")
public class ChangeManagementPlan extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;


	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}


	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
