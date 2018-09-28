package com.rest.smoothchange.business.benefit.mapping.dto;

public class BusinessBenefitMappingRequestDto {
private String businessBenefit;
	
	private String affectedParty;

	

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
	
	private Long id; 

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

}

