package com.rest.smoothchange.util;

public enum LevelOfInfluence {

	High("High"), Medium("Medium"), Low("Low");

	private String numVal;

	LevelOfInfluence(String numVal) {
		this.numVal = numVal;
	}

	public String getNumVal() {
		return numVal;
	}

	public static LevelOfInfluence getValue(String numVal) {
		for (LevelOfInfluence e : LevelOfInfluence.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}
}
