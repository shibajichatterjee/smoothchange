/**
 * 
 */
package com.rest.smoothchange.change.readiness.categories.dto;

import java.util.ArrayList;
import java.util.List;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;


public class ChangeReadinessCategoryrequestDTO{
	
	private String changeReadinessCategoryName;
	
	private Long id; 

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getChangeReadinessCategoryName() {
		return changeReadinessCategoryName;
	}

	public void setChangeReadinessCategoryName(String changeReadinessCategoryName) {
		this.changeReadinessCategoryName = changeReadinessCategoryName;
	}

	
	
}
