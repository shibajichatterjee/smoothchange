package com.rest.smoothchange.impact.analysis.dto;

import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.util.ImpactType;
import com.rest.smoothchange.util.LevelOfImpact;
import com.rest.smoothchange.util.PlannedActivity;

public class ImpactAnalysisRequestDto {

	private String impactType;

	private String otherImpactType;

	private Long projectStakeholdersId;

	

	public Long getProjectStakeholdersId() {
		return projectStakeholdersId;
	}

	public void setProjectStakeholdersId(Long projectStakeholdersId) {
		this.projectStakeholdersId = projectStakeholdersId;
	}

	private String levelOfImpact;

	private String plannedActivity;

	public String getOtherImpactType() {
		return otherImpactType;
	}

	public void setOtherImpactType(String otherImpactType) {
		this.otherImpactType = otherImpactType;
	}

	public String getImpactType() {
		return impactType;
	}

	public void setImpactType(String impactType) {
		this.impactType = impactType;
	}

	public String getLevelOfImpact() {
		return levelOfImpact;
	}

	public void setLevelOfImpact(String levelOfImpact) {
		this.levelOfImpact = levelOfImpact;
	}

	public String getPlannedActivity() {
		return plannedActivity;
	}

	public void setPlannedActivity(String plannedActivity) {
		this.plannedActivity = plannedActivity;
	}

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
