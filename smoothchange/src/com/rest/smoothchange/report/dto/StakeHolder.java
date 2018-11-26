package com.rest.smoothchange.report.dto;

public class StakeHolder {

	private final String serialNumber;
	private final String type;
	private final String name;
	private final String location;
	private final String levelOfInfluence;
	private final String noOfPersonsImpacted;
	private final String strategyOfEngagement;
	private final String role;


	public StakeHolder(String serialNumber, 
					   String type,
					   String name,
					   String role,
					   String location,
					   String levelOfInfluence,
					   String noOfPersonsImpacted,
					   String strategyOfEngagement) {
				this.serialNumber = serialNumber;
				this.type = type;
				this.name = name;
				this.role = role;
				this.location = location;
				this.levelOfInfluence = levelOfInfluence;
				this.noOfPersonsImpacted = noOfPersonsImpacted;
				this.strategyOfEngagement = strategyOfEngagement;
	}

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public String getLocation()
    {
        return location;
    }

    public String getLevelOfInfluence()
    {
        return levelOfInfluence;
    }

    public String getNoOfPersonsImpacted()
    {
        return noOfPersonsImpacted;
    }

    public String getStrategyOfEngagement()
    {
        return strategyOfEngagement;
    }

    public String getRole()
    {
        return role;
    }

}
