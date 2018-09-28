/**
 * 
 */
package com.rest.smoothchange.admin.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;


public class AdminDto extends AbstractIdentifierDTO{
	
	private static final long serialVersionUID = 1L;

	private String  password;
	
	private String  emailAddress;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 

	
}
