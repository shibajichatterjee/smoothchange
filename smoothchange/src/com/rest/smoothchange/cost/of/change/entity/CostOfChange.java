/**
 * 
 */
package com.rest.smoothchange.cost.of.change.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Entity
@Table(name = "COST_OF_CHANGE")
public class CostOfChange extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@JoinColumn(name="project_id")
	@ManyToOne
	private ProjectBackground  projectBackground;
	
	
	@Column(name="total_cost")
	private Double totalCost;



	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
