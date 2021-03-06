package com.rest.smoothchange.util;

public enum ApprovalStatus {

	
	Approved("Approved"),
	Pending("Pending"),
	NotInitiated("Not Initiated"),
	Other("Other");
	
	private String numVal;

	ApprovalStatus(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }
    
    public static ApprovalStatus getValue(String message)
    {
    	for(ApprovalStatus e:ApprovalStatus.values())
    	{
    		if(e.getNumVal().equals(message))
    		{
    			return e;
    		}
    	}
    	return null;
    }
    
}
