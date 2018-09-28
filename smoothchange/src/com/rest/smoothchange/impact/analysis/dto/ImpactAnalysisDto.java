/**
 * 
 */
package com.rest.smoothchange.impact.analysis.dto;

import com.rest.framework.dto.AbstractDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.util.ImpactType;
import com.rest.smoothchange.util.LevelOfImpact;
import com.rest.smoothchange.util.PlannedActivity;


public class ImpactAnalysisDto extends AbstractDTO{
	
	private static final long serialVersionUID = 1L;

	private ProjectBackgroundDto projectBackground;

	private ImpactType impactType;
	
	private String otherImpactType;
	
	private ProjectStakeholdersDto projectStakeholders;
	
	private LevelOfImpact levelOfImpact;
	
	private PlannedActivity plannedActivity;

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	public ImpactType getImpactType() {
		return impactType;
	}

	public void setImpactType(ImpactType impactType) {
		this.impactType = impactType;
	}

	public String getOtherImpactType() {
		return otherImpactType;
	}

	public void setOtherImpactType(String otherImpactType) {
		this.otherImpactType = otherImpactType;
	}

	public ProjectStakeholdersDto getProjectStakeholders() {
		return projectStakeholders;
	}

	public void setProjectStakeholders(ProjectStakeholdersDto projectStakeholders) {
		this.projectStakeholders = projectStakeholders;
	}

	public LevelOfImpact getLevelOfImpact() {
		return levelOfImpact;
	}

	public void setLevelOfImpact(LevelOfImpact levelOfImpact) {
		this.levelOfImpact = levelOfImpact;
	}

	public PlannedActivity getPlannedActivity() {
		return plannedActivity;
	}

	public void setPlannedActivity(PlannedActivity plannedActivity) {
		this.plannedActivity = plannedActivity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
