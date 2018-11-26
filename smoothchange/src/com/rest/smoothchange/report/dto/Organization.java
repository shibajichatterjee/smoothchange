package com.rest.smoothchange.report.dto;

public class Organization {

	private final String name;
	private final String address;
	private final String logo;
	
	public Organization(String name, 
			   String address,
			   String logo) {
		this.name = name;
		this.address = address;
		this.logo = logo;
	}
	
    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getLogo()
    {
        return logo;
    }


}
