/**
 * 
 */
package com.rest.smoothchange.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;

@Entity
@Table(name = "ADMIN")
public class Admin extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@Column(name="password")
	private String  password;
	
	@Column(name="email_address")
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
