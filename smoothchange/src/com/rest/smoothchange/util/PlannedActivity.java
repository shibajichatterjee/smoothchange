package com.rest.smoothchange.util;

public enum PlannedActivity {

	Communication("Communication"),
	Training("Training"),
	Both("Both");
	
	private String numVal;

	PlannedActivity(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }
    public static PlannedActivity getValue(String numVal) {
		for (PlannedActivity e : PlannedActivity.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}
	
}
