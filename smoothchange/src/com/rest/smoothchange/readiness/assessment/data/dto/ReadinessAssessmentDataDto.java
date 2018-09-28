/**
 * 
 */
package com.rest.smoothchange.readiness.assessment.data.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;


public class ReadinessAssessmentDataDto extends AbstractIdentifierDTO{
	

	private ReadinessCategoryItemsDto readinessCategoryItems;

	public ReadinessCategoryItemsDto getReadinessCategoryItems() {
		return readinessCategoryItems;
	}

	public void setReadinessCategoryItems(ReadinessCategoryItemsDto readinessCategoryItems) {
		this.readinessCategoryItems = readinessCategoryItems;
	}
	
	
	
}
