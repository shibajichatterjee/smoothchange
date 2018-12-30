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
	
	private String business_benefit_other;;
	
	public String getBusiness_benefit_other() {
		return business_benefit_other;
	}

	public void setBusiness_benefit_other(String business_benefit_other) {
		this.business_benefit_other = business_benefit_other;
	}

	//============ For Report Generatio ============
	private String  SerialNumber;
	
   
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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
	}


}
