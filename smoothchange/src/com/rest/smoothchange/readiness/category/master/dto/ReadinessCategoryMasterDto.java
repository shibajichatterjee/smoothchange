/**
 * 
 */
package com.rest.smoothchange.readiness.category.master.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;


public class ReadinessCategoryMasterDto extends AbstractIdentifierDTO{
	
	private static final long serialVersionUID = 1L;

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
