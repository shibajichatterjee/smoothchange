/**
 * 
 */
package com.rest.smoothchange.project.stakeholders.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractPersistentObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.EngagementStrategy;
import com.rest.smoothchange.util.LevelOfInfluence;
import com.rest.smoothchange.util.StakeholderType;

@Entity
@Table(name = "PROJECT_STAKEHOLDERS")
public class ProjectStakeholders extends AbstractPersistentObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;

	@Column(name = "stakeholder_name")
	private String stakeholderName;
	
	@Enumerated(EnumType.ORDINAL)
	private StakeholderType stakeholderType;
	
	@Column(name="role")
	private String role;
	
	@Column(name="location")
	private String location;
	
	@Column(name="number_impacted")
	private Integer numberImpacted;
	
	@Enumerated(EnumType.ORDINAL)
	private LevelOfInfluence LevelOfInfluence;
	
	@Enumerated(EnumType.ORDINAL)
	private EngagementStrategy engagementStrategy;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getStakeholderName() {
		return stakeholderName;
	}

	public void setStakeholderName(String stakeholderName) {
		this.stakeholderName = stakeholderName;
	}

	public StakeholderType getStakeholderType() {
		return stakeholderType;
	}

	public void setStakeholderType(StakeholderType stakeholderType) {
		this.stakeholderType = stakeholderType;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getNumberImpacted() {
		return numberImpacted;
	}

	public void setNumberImpacted(Integer numberImpacted) {
		this.numberImpacted = numberImpacted;
	}

	public LevelOfInfluence getLevelOfInfluence() {
		return LevelOfInfluence;
	}

	public void setLevelOfInfluence(LevelOfInfluence levelOfInfluence) {
		LevelOfInfluence = levelOfInfluence;
	}

	public EngagementStrategy getEngagementStrategy() {
		return engagementStrategy;
	}

	public void setEngagementStrategy(EngagementStrategy engagementStrategy) {
		this.engagementStrategy = engagementStrategy;
	}
	
	
}
