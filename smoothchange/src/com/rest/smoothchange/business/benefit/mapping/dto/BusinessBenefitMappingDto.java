/**
 * 
 */
package com.rest.smoothchange.business.benefit.mapping.dto;

import com.rest.framework.dto.AbstractDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class BusinessBenefitMappingDto extends AbstractDTO{
	
	private static final long serialVersionUID = 1L;

	
	private ProjectBackgroundDto projectBackground;

	private String businessBenefit;
	
	private String affectedParty;

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getBusinessBenefit() {
		return businessBenefit;
	}

	public void setBusinessBenefit(String businessBenefit) {
		this.businessBenefit = businessBenefit;
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
	

}
