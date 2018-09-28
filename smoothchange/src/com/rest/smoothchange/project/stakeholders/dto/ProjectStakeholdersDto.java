/**
 * 
 */
package com.rest.smoothchange.project.stakeholders.dto;

import com.rest.framework.dto.AbstractDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.util.EngagementStrategy;
import com.rest.smoothchange.util.LevelOfInfluence;
import com.rest.smoothchange.util.StakeholderType;

public class ProjectStakeholdersDto extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	private ProjectBackgroundDto projectBackground;

	private String stakeholderName;

	private String stakeholderType;

	private String role;

	private String location;

	private Integer numberImpacted;

	private String LevelOfInfluence;

	private String engagementStrategy;

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getStakeholderName() {
		return stakeholderName;
	}

	public void setStakeholderName(String stakeholderName) {
		this.stakeholderName = stakeholderName;
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

	public String getStakeholderType() {
		return stakeholderType;
	}

	public void setStakeholderType(String stakeholderType) {
		this.stakeholderType = stakeholderType;
	}

	public String getLevelOfInfluence() {
		return LevelOfInfluence;
	}

	public void setLevelOfInfluence(String levelOfInfluence) {
		LevelOfInfluence = levelOfInfluence;
	}

	public String getEngagementStrategy() {
		return engagementStrategy;
	}

	public void setEngagementStrategy(String engagementStrategy) {
		this.engagementStrategy = engagementStrategy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
