package com.rest.framework.dto;

import java.io.Serializable;

public abstract class AbstractIdentifierDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	private Long id; 

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
