/**
 * 
 */
package com.rest.smoothchange.business.benefit.mapping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractPersistentObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.BusinessBenefit;

@Entity
@Table(name = "BUSINESS_BENEFIT_MAPPING")
public class BusinessBenefitMapping extends AbstractPersistentObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;

	@Enumerated(EnumType.ORDINAL)
	private BusinessBenefit businessBenefit;
	
	@Column(name="affected_party")
	private String affectedParty;

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getAffectedParty() {
		return affectedParty;
	}

	public void setAffectedParty(String affectedParty) {
		this.affectedParty = affectedParty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BusinessBenefit getBusinessBenefit() {
		return businessBenefit;
	}

	public void setBusinessBenefit(BusinessBenefit businessBenefit) {
		this.businessBenefit = businessBenefit;
	}
	
	
}
