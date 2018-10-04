package com.rest.smoothchange.util;

public enum SupportedStackHolderStatus {

	
	YES("Yes"),
	NO("No"),
	NotSure("Not Sure"),
	Others("Others");
	
	private String numVal;

	SupportedStackHolderStatus(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }
    public static SupportedStackHolderStatus getValue(String numVal) {
		for (SupportedStackHolderStatus e : SupportedStackHolderStatus.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}
}
