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


public class ChangeReadinessCategoriesDto extends AbstractIdentifierDTO{
	
	private String changeReadinessCategoryName;
	
	private ProjectBackgroundDto projectBackgroundDto;
	
	private List<ReadinessCategoryItemsDto> readinessCategoryItemList = new ArrayList<>();

	public String getChangeReadinessCategoryName() {
		return changeReadinessCategoryName;
	}

	public void setChangeReadinessCategoryName(String changeReadinessCategoryName) {
		this.changeReadinessCategoryName = changeReadinessCategoryName;
	}

	public ProjectBackgroundDto getProjectBackgroundDto() {
		return projectBackgroundDto;
	}

	public void setProjectBackgroundDto(ProjectBackgroundDto projectBackgroundDto) {
		this.projectBackgroundDto = projectBackgroundDto;
	}

	public List<ReadinessCategoryItemsDto> getReadinessCategoryItemList() {
		return readinessCategoryItemList;
	}

	public void setReadinessCategoryItemList(List<ReadinessCategoryItemsDto> readinessCategoryItemList) {
		this.readinessCategoryItemList = readinessCategoryItemList;
	}

	
	
}
