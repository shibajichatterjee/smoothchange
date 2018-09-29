/**
 * 
 */
package com.rest.smoothchange.project.background.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.rest.smoothchange.util.TypeOfChange;

@Entity
@Table(name = "PROJECT_BACKGROUND")
public class ProjectBackground extends com.rest.framework.entity.AbstractPersistentObject{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "project_description")
	private String projectDescription;

	
	@Enumerated(EnumType.ORDINAL)
	private TypeOfChange typeOfChange;
	
	
	@Column(name="other_type_of_change")
	private String otherTypeOfChange; 
	
	
	@Column(name="owner_of_change")
	private String ownerOfChange;
	
	@Column(name="contact_person")
	private String contactPerson;

	
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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


	public TypeOfChange getTypeOfChange() {
		return typeOfChange;
	}

	public void setTypeOfChange(TypeOfChange typeOfChange) {
		this.typeOfChange = typeOfChange;
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

}
