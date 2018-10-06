package com.rest.smoothchange.util;

public enum TypeOfChange {

	SystemImplementation("System Implementation"),
	OrganizationalRestructure("Organizational Restructure"),
	ProductLaunch("Product Launch"),
	MergerAndRestructure("Merger And Restructure"),
	BusinessProcessSystemImplementation("Business Process System Implementation"),
	Other("Other");
	
	private String message;

	TypeOfChange(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
    public static TypeOfChange getValue(String message)
    {
    	for(TypeOfChange e:TypeOfChange.values())
    	{
    		if(e.getMessage().equals(message))
    		{
    			return e;
    		}
    	}
    	return null;
    }
}
