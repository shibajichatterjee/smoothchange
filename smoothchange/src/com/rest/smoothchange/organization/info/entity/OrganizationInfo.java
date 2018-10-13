/**
 * 
 */
package com.rest.smoothchange.organization.info.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractPersistentObject;

@Entity
@Table(name = "ORGANISATION_INFO")
public class OrganizationInfo extends AbstractPersistentObject{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "organisation_name")
	private String organisationName;

	@Column(name = "address")
	private String address;

	@Column(name = "logo", unique = false, nullable = false, length = 100000)
    private byte[] logo;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public byte[] getLogo() {
		return logo;
	}


	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	
	
}
