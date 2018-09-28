/**
 * 
 */
package com.rest.smoothchange.user.dto;

import java.util.Date;

import com.rest.framework.dto.AbstractIdentifierDTO;


public class UserDto extends AbstractIdentifierDTO{
	
	private static final long serialVersionUID = 1L;

	private String  password;
	
	private String  emailAddress;
	
	private String  firstName; 
	
	private String  middleName;
	
	private String  lastName;
	
    private byte[] photo;
	
	private String adminId;
	
	private Date createdOn;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	
	
}
