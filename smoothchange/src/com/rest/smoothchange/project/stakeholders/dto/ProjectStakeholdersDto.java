/**
 * 
 */
package com.rest.smoothchange.project.stakeholders.dto;

import com.rest.framework.dto.AbstractDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;

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
	private String engagementStrategyOther;
	
	public String getEngagementStrategyOther() {
		return engagementStrategyOther;
	}

	public void setEngagementStrategyOther(String engagementStrategyOther) {
		this.engagementStrategyOther = engagementStrategyOther;
	}

	private  String serialNumber;
	private  String type;
	private  String name;
	private  String levelOfInfluence;
	private  String noOfPersonsImpacted;
	private  String strategyOfEngagement;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNoOfPersonsImpacted() {
		return noOfPersonsImpacted;
	}

	public void setNoOfPersonsImpacted(String noOfPersonsImpacted) {
		this.noOfPersonsImpacted = noOfPersonsImpacted;
	}

	public String getStrategyOfEngagement() {
		return strategyOfEngagement;
	}

	public void setStrategyOfEngagement(String strategyOfEngagement) {
		this.strategyOfEngagement = strategyOfEngagement;
	}

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
