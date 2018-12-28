package com.rest.smoothchange.util;

public enum BusinessBenefit {

	REDUCECOST("Reduce Cost"),INCREASEREVENUE("Increase Revenue"),INCREACECUSTOMERBASE("Increace Customer Base"),
	IMPROVEPROCESS("Improve Process"), IMPROVEPRODUCTIVITY("Improve Productivity"),ENHANCEUSEREXPERIANCE("Enhance User Experiance"),
	INCREASECUSTOMERSATISFICTION("Increase Customer Satisfiction"),OTHER("Other");
	
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
