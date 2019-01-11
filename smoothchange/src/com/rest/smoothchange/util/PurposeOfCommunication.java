package com.rest.smoothchange.util;

public enum PurposeOfCommunication {

	Inform("Inform"),
	SeekApproval("Seek Approval"),
	Other("Other");
	
	private String numVal;

	PurposeOfCommunication(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }
    public static PurposeOfCommunication getValue(String numVal) {
		for (PurposeOfCommunication e : PurposeOfCommunication.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}
	
}
