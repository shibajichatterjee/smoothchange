/**
 * 
 */
package com.rest.smoothchange.readiness.category.items.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;


public class ReadinessCategoryItemsDto extends AbstractIdentifierDTO{
	
	private static final long serialVersionUID = 1L;

	private ChangeReadinessCategoriesDto changeReadinessCategories;

    private String changeReadinessCategoryItemDescription;

	private String changeReadinessCategoryItemCode;

	public ChangeReadinessCategoriesDto getChangeReadinessCategories() {
		return changeReadinessCategories;
	}

	public void setChangeReadinessCategories(ChangeReadinessCategoriesDto changeReadinessCategories) {
		this.changeReadinessCategories = changeReadinessCategories;
	}

	public String getChangeReadinessCategoryItemDescription() {
		return changeReadinessCategoryItemDescription;
	}

	public void setChangeReadinessCategoryItemDescription(String changeReadinessCategoryItemDescription) {
		this.changeReadinessCategoryItemDescription = changeReadinessCategoryItemDescription;
	}

	public String getChangeReadinessCategoryItemCode() {
		return changeReadinessCategoryItemCode;
	}

	public void setChangeReadinessCategoryItemCode(String changeReadinessCategoryItemCode) {
		this.changeReadinessCategoryItemCode = changeReadinessCategoryItemCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
