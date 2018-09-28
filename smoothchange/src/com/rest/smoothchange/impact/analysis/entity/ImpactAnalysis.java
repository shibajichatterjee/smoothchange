/**
 * 
 */
package com.rest.smoothchange.impact.analysis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractPersistentObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;
import com.rest.smoothchange.util.ImpactType;
import com.rest.smoothchange.util.LevelOfImpact;
import com.rest.smoothchange.util.PlannedActivity;

@Entity
@Table(name = "IMPACT_ANALYSIS")
public class ImpactAnalysis extends AbstractPersistentObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;

	@Enumerated(EnumType.ORDINAL)
	private ImpactType impactType;
	
	@Column(name="other_impact_type")
	private String otherImpactType;
	
	@ManyToOne
	@JoinColumn(name="affected_stakeholder_id")
	private ProjectStakeholders projectStakeholders;
	
	@Enumerated(EnumType.ORDINAL)
	private LevelOfImpact levelOfImpact;
	

	@Enumerated(EnumType.ORDINAL)
	private PlannedActivity plannedActivity;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
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

	public ProjectStakeholders getProjectStakeholders() {
		return projectStakeholders;
	}

	public void setProjectStakeholders(ProjectStakeholders projectStakeholders) {
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

}
