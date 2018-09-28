package com.rest.smoothchange.util;

public enum Frequency {

	Daily("Daily"),
	Weekly("Weekly"),
	Fortnightly("Fortnightly"),
	Monthly("Monthly"),
	BiMonthly("BiMonthly"),
	Quarterly("Quarterly"),
	HalfYearly("HalfYearly"),
	Annually("Annually");
	
	private String numVal;

	Frequency(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }
	
}
