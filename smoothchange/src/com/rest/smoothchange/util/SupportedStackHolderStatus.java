package com.rest.smoothchange.util;

public enum SupportedStackHolderStatus {

	
	YES("yes"),
	NO("no"),
	NotSure("notsure"),
	Others("others");
	
	private String numVal;

	SupportedStackHolderStatus(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }
	
}
