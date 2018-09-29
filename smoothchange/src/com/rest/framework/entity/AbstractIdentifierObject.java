package com.rest.framework.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractIdentifierObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long Id;        

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
