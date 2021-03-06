/**
 * 
 */
package com.rest.smoothchange.change.readiness.categories.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;

@Entity
@Table(name = "CHANGE_READINESS_CATEGORIES")
public class ChangeReadinessCategories extends AbstractIdentifierObject{
	
	@Column(name="change_readiness_category_name")
	private String changeReadinessCategoryName;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;
	

	public String getChangeReadinessCategoryName() {
		return changeReadinessCategoryName;
	}

	public void setChangeReadinessCategoryName(String changeReadinessCategoryName) {
		this.changeReadinessCategoryName = changeReadinessCategoryName;
	}

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	
}
