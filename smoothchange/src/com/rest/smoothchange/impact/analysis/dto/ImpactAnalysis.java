package com.rest.smoothchange.impact.analysis.dto;

public class ImpactAnalysis {

	private  String serialNumber;
	private  String typeOfImpact;
	private  String nameOfAffectedStakeholder;
	private  String locationOfAffectedStakeholder;
	private  String levelOfImpact;
	private  String noOfPersonsImpacted;
	private  String plannedActivity;

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setTypeOfImpact(String typeOfImpact) {
		this.typeOfImpact = typeOfImpact;
	}

	public void setNameOfAffectedStakeholder(String nameOfAffectedStakeholder) {
		this.nameOfAffectedStakeholder = nameOfAffectedStakeholder;
	}

	public void setLocationOfAffectedStakeholder(String locationOfAffectedStakeholder) {
		this.locationOfAffectedStakeholder = locationOfAffectedStakeholder;
	}

	public void setLevelOfImpact(String levelOfImpact) {
		this.levelOfImpact = levelOfImpact;
	}

	public void setNoOfPersonsImpacted(String noOfPersonsImpacted) {
		this.noOfPersonsImpacted = noOfPersonsImpacted;
	}

	public void setPlannedActivity(String plannedActivity) {
		this.plannedActivity = plannedActivity;
	}

	public ImpactAnalysis(String serialNumber, 
			   String typeOfImpact,
			   String nameOfAffectedStakeholder,
			   String locationOfAffectedStakeholder,
			   String levelOfImpact,
			   String noOfPersonsImpacted,
			   String plannedActivity) {
		this.serialNumber = serialNumber;
		this.typeOfImpact = typeOfImpact;
		this.nameOfAffectedStakeholder = nameOfAffectedStakeholder;
		this.locationOfAffectedStakeholder = locationOfAffectedStakeholder;
		this.levelOfImpact = levelOfImpact;
		this.noOfPersonsImpacted = noOfPersonsImpacted;
		this.plannedActivity = plannedActivity;
	}
	public ImpactAnalysis()
	{
		
	}
	
    public String getSerialNumber()
    {
        return serialNumber;
    }

    public String getTypeOfImpact()
    {
        return typeOfImpact;
    }

    public String getNameOfAffectedStakeholder()
    {
        return nameOfAffectedStakeholder;
    }

    public String getLocationOfAffectedStakeholder()
    {
        return locationOfAffectedStakeholder;
    }

    public String getLevelOfImpact()
    {
        return levelOfImpact;
    }

    public String getNoOfPersonsImpacted()
    {
        return noOfPersonsImpacted;
    }

    public String getPlannedActivity()
    {
        return plannedActivity;
    }

}
