/**
 * 
 */
package com.rest.smoothchange.organization.info.dto;

import com.rest.framework.dto.AbstractDTO;


public class OrganizationInfoDto extends AbstractDTO{
	
	private static final long serialVersionUID = 1L;

	private String organisationName;

	private String address;

	private String logoPath;
	
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

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	
}
