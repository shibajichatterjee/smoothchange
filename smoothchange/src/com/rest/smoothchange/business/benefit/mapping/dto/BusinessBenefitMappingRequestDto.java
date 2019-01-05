package com.rest.smoothchange.business.benefit.mapping.dto;

public class BusinessBenefitMappingRequestDto {
	
   private String businessBenefit;
	
	private String business_benefit_other;
	
	private Long stake_holder_id;
	

	

	public Long getStake_holder_id() {
		return stake_holder_id;
	}

	public void setStake_holder_id(Long stake_holder_id) {
		this.stake_holder_id = stake_holder_id;
	}

	public String getBusinessBenefit() {
		return businessBenefit;
	}

	public void setBusinessBenefit(String businessBenefit) {
		this.businessBenefit = businessBenefit;
	}

	public String getBusiness_benefit_other() {
		return business_benefit_other;
	}

	public void setBusiness_benefit_other(String business_benefit_other) {
		this.business_benefit_other = business_benefit_other;
	}

	private Long id; 

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
}

