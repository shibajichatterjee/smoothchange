/**
 * 
 */
package com.rest.smoothchange.readiness.category.items.dto;

import java.util.Date;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;


public class ReadinessCategoryItemsDto extends AbstractIdentifierDTO{
	
	private static final long serialVersionUID = 1L;

	private ChangeReadinessCategoriesDto changeReadinessCategories;

    private String changeReadinessCategoryItemDescription;

	private String changeReadinessCategoryItemCode;
	
	private Date changeReadinessDate1;
	
	private String changeReadinessResponsible;
	
	private Date changeReadinessDate2;
	
	private String changeReadinessApprover;
	

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

	public Date getChangeReadinessDate1() {
		return changeReadinessDate1;
	}

	public void setChangeReadinessDate1(Date changeReadinessDate1) {
		this.changeReadinessDate1 = changeReadinessDate1;
	}

	public String getChangeReadinessResponsible() {
		return changeReadinessResponsible;
	}

	public void setChangeReadinessResponsible(String changeReadinessResponsible) {
		this.changeReadinessResponsible = changeReadinessResponsible;
	}

	public Date getChangeReadinessDate2() {
		return changeReadinessDate2;
	}

	public void setChangeReadinessDate2(Date changeReadinessDate2) {
		this.changeReadinessDate2 = changeReadinessDate2;
	}

	public String getChangeReadinessApprover() {
		return changeReadinessApprover;
	}

	public void setChangeReadinessApprover(String changeReadinessApprover) {
		this.changeReadinessApprover = changeReadinessApprover;
	}
			
}
