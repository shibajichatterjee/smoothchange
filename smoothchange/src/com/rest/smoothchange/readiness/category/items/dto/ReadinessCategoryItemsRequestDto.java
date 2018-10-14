package com.rest.smoothchange.readiness.category.items.dto;

import java.util.List;

import com.rest.smoothchange.readiness.assessment.data.item.dto.ReadinessAssessmentDataItemRequestDto;

public class ReadinessCategoryItemsRequestDto {

	    private long changeReadinessCategoryItemId;
	
		private String changeReadinessCategoryItemDescription;

		private String changeReadinessCategoryItemCode;
		
	    private List<ReadinessAssessmentDataItemRequestDto> readinessAssessmentDataItemRequestDtoList;

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

		public List<ReadinessAssessmentDataItemRequestDto> getReadinessAssessmentDataItemRequestDtoList() {
			return readinessAssessmentDataItemRequestDtoList;
		}

		public void setReadinessAssessmentDataItemRequestDtoList(
				List<ReadinessAssessmentDataItemRequestDto> readinessAssessmentDataItemRequestDtoList) {
			this.readinessAssessmentDataItemRequestDtoList = readinessAssessmentDataItemRequestDtoList;
		}

		public long getChangeReadinessCategoryItemId() {
			return changeReadinessCategoryItemId;
		}

		public void setChangeReadinessCategoryItemId(long changeReadinessCategoryItemId) {
			this.changeReadinessCategoryItemId = changeReadinessCategoryItemId;
		}
		
		
		
	
}
