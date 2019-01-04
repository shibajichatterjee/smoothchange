package com.rest.smoothchange.util;

public enum BusinessBenefit {

	REDUCECOST("Reduce Cost"),INCREASEREVENUE("Increase Revenue"),INCREACECUSTOMERBASE("Increase Customer Base"),
	IMPROVEPROCESS("Process Improve"), IMPROVEPRODUCTIVITY("Improve Productivity"),ENHANCEUSEREXPERIENCE("Enhance User Experience"),
	INCREASECUSTOMERSATISFACTION("Increase Customer Satisfaction"),OTHER("Other");
	
	private String value;
	
	BusinessBenefit(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	 public static BusinessBenefit getValue(String numVal) {
			for (BusinessBenefit e : BusinessBenefit.values()) {
				if (e.getValue().equals(numVal)) {
					return e;
				}
			}
			return null;
		}
	
}
