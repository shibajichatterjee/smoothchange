package com.rest.smoothchange.readiness.category.items.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReadinessCategoryItemsRequestDto {

		private String changeReadinessCategoryItemDescription;

		private String changeReadinessCategoryItemCode;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

		private String changeReadinessDate1;
		
		private String changeReadinessResponsible;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

		private String changeReadinessDate2;

		private String changeReadinessApprover;

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

		public String getChangeReadinessResponsible() {
			return changeReadinessResponsible;
		}

		public void setChangeReadinessResponsible(String changeReadinessResponsible) {
			this.changeReadinessResponsible = changeReadinessResponsible;
		}

		public String getChangeReadinessApprover() {
			return changeReadinessApprover;
		}

		public void setChangeReadinessApprover(String changeReadinessApprover) {
			this.changeReadinessApprover = changeReadinessApprover;
		}

		public String getChangeReadinessDate1() {
			return changeReadinessDate1;
		}

		public void setChangeReadinessDate1(String changeReadinessDate1) {
			this.changeReadinessDate1 = changeReadinessDate1;
		}

		public String getChangeReadinessDate2() {
			return changeReadinessDate2;
		}

		public void setChangeReadinessDate2(String changeReadinessDate2) {
			this.changeReadinessDate2 = changeReadinessDate2;
		}
		
		

	
}
