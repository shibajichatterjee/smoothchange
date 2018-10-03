package com.rest.smoothchange.util;

public enum ActionType {

	
	ITHardware("IT Hardware"),
	ITSoftware("IT Software"),
	ITNetworking("IT Networking"),
	BusinessUnit("Business Unit"),
	ProjectTeam("Project Team"),
	Communication("Communication"),
	Training("Training"),
	Audit("Audit");

	
	
	
	private String numVal;

	ActionType(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }
    
    public static ActionType getValue(String numVal) {
		for (ActionType e : ActionType.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}
    
}
