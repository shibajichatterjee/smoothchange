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
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;
import com.rest.smoothchange.util.BusinessBenefit;

@Entity
@Table(name = "BUSINESS_BENEFIT_MAPPING")
public class BusinessBenefitMapping extends AbstractPersistentObject {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectBackground projectBackground;

	@ManyToOne
	@JoinColumn(name = "affected_stack_holder")
	private ProjectStakeholders projectStakeholders;

	@Enumerated(EnumType.ORDINAL)
	private BusinessBenefit businessBenefit;

	@Column(name = "business_benefit_other")
	private String business_benefit_other;

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getBusiness_benefit_other() {
		return business_benefit_other;
	}

	public void setBusiness_benefit_other(String business_benefit_other) {
		this.business_benefit_other = business_benefit_other;
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

	public ProjectStakeholders getProjectStakeholders() {
		return projectStakeholders;
	}

	public void setProjectStakeholders(ProjectStakeholders projectStakeholders) {
		this.projectStakeholders = projectStakeholders;
	}
 
}
