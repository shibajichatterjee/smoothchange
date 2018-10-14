/**
 * 
 */
package com.rest.smoothchange.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rest.framework.entity.AbstractIdentifierObject;

@Entity
@Table(name = "USER")
public class User extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@Column(name="password")
	private String  password;
	
	@Column(name="email_address" , unique=true)
	private String  emailAddress;
	
	@Column(name="first_name")
	private String  firstName;
	
	@Column(name="middle_name")
	private String  middleName;
	
	@Column(name="last_name")
	private String  lastName;
	
	@Column(name = "photo", unique = false, nullable = false, length = 100000)
    private byte[] photo;
	
	@Column(name="admin_id")
	private String adminId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_on")
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
