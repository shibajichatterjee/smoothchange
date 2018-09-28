/**
 * 
 */
package com.rest.smoothchange.training.plan.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Entity
@Table(name = "TRAINING_PLAN")
public class TrainingPlan extends AbstractIdentifierObject{
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;

	
	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	
}
