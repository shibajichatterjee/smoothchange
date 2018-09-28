package com.rest.smoothchange.util;

public enum ApprovalStatus {

	
	Approved("approved"),
	Pending("pending"),
	NotInitiated("notinitiated"),
	Other("other");
	
	private String numVal;

	ApprovalStatus(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }
    
}
