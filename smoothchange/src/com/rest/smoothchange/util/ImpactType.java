package com.rest.smoothchange.util;

public enum ImpactType {

	Technology("Technology"),
	Operational("Operational"),
	Process("Process"),
	Organizational("Organizational"),
	Commercial("Commercial"),
	Customer("Customer"),
	Other("Other");
	
	private String numVal;

	ImpactType(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }
    public static ImpactType getValue(String numVal) {
		for (ImpactType e : ImpactType.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}
	
}
