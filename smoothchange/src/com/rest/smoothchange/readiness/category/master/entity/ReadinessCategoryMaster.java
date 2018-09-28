/**
 * 
 */
package com.rest.smoothchange.readiness.category.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;

@Entity
@Table(name = "CHANGE_READINESS_CATEGORY_MASTER")
public class ReadinessCategoryMaster extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@Column(name="change_readiness_master_category_name")
	private String changeReadinessMasterCategoryName;

	public String getChangeReadinessMasterCategoryName() {
		return changeReadinessMasterCategoryName;
	}

	public void setChangeReadinessMasterCategoryName(String changeReadinessMasterCategoryName) {
		this.changeReadinessMasterCategoryName = changeReadinessMasterCategoryName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
