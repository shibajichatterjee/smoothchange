/**
 * 
 */
package com.rest.smoothchange.project.background.dto;

import com.rest.framework.dto.AbstractDTO;


public class ProjectBackgroundDto extends AbstractDTO{
	
	private static final long serialVersionUID = 1L;

	private String projectName;

	private String projectDescription;

	private String typeOfChange;
	
	private String otherTypeOfChange; 
	
	private String ownerOfChange;
	
	private String contactPerson;
	

	//=============== For Report Generation ===========
		private String name;
		
		private String description;
		
		private String owner;
		
	
	
	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectDescription() {
		return projectDescription;
	}


	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


	public String getOtherTypeOfChange() {
		return otherTypeOfChange;
	}


	public void setOtherTypeOfChange(String otherTypeOfChange) {
		this.otherTypeOfChange = otherTypeOfChange;
	}


	public String getOwnerOfChange() {
		return ownerOfChange;
	}


	public void setOwnerOfChange(String ownerOfChange) {
		this.ownerOfChange = ownerOfChange;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getTypeOfChange() {
		return typeOfChange;
	}

	public void setTypeOfChange(String typeOfChange) {
		this.typeOfChange = typeOfChange;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}

	
}
