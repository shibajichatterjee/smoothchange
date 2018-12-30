package com.rest.smoothchange.business.benefit.mapping.dto;

public class BusinessBenefitMappingRequestDto {
	
   private String businessBenefit;
	
	private String business_benefit_other;

	private String stakeholderName;

	private String stakeholderType;

	private String role;

	private String location;

	private Integer numberImpacted;

	private String LevelOfInfluence;

	private String engagementStrategy;
	
	private String engagementStrategyOther;
	

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

	public String getStakeholderName() {
		return stakeholderName;
	}

	public void setStakeholderName(String stakeholderName) {
		this.stakeholderName = stakeholderName;
	}

	public String getStakeholderType() {
		return stakeholderType;
	}

	public void setStakeholderType(String stakeholderType) {
		this.stakeholderType = stakeholderType;
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

	public String getEngagementStrategyOther() {
		return engagementStrategyOther;
	}

	public void setEngagementStrategyOther(String engagementStrategyOther) {
		this.engagementStrategyOther = engagementStrategyOther;
	}
	
}

