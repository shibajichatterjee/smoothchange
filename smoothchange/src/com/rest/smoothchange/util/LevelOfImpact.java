package com.rest.smoothchange.util;

public enum LevelOfImpact {

	
	High("High"),
	Medium("Medium"),
	Low("Low");
	
	private String numVal;

	LevelOfImpact(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }
    
    public static LevelOfImpact getValue(String numVal) {
		for (LevelOfImpact e : LevelOfImpact.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}
}
