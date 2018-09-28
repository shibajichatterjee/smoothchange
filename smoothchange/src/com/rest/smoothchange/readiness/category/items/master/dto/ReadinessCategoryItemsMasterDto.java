/**
 * 
 */
package com.rest.smoothchange.readiness.category.items.master.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.readiness.category.master.dto.ReadinessCategoryMasterDto;


public class ReadinessCategoryItemsMasterDto extends AbstractIdentifierDTO{
	

    private ReadinessCategoryMasterDto readinessCategoryMaster;
	
	private String changeReadinessMasterCategoryItemDescription;
	
    private String changeReadinessMasterCategoryItemCode;

	public ReadinessCategoryMasterDto getReadinessCategoryMaster() {
		return readinessCategoryMaster;
	}

	public void setReadinessCategoryMaster(ReadinessCategoryMasterDto readinessCategoryMaster) {
		this.readinessCategoryMaster = readinessCategoryMaster;
	}

	public String getChangeReadinessMasterCategoryItemDescription() {
		return changeReadinessMasterCategoryItemDescription;
	}

	public void setChangeReadinessMasterCategoryItemDescription(String changeReadinessMasterCategoryItemDescription) {
		this.changeReadinessMasterCategoryItemDescription = changeReadinessMasterCategoryItemDescription;
	}

	public String getChangeReadinessMasterCategoryItemCode() {
		return changeReadinessMasterCategoryItemCode;
	}

	public void setChangeReadinessMasterCategoryItemCode(String changeReadinessMasterCategoryItemCode) {
		this.changeReadinessMasterCategoryItemCode = changeReadinessMasterCategoryItemCode;
	} 
	
    
}
