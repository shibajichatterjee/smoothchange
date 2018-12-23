package com.rest.smoothchange.change.readiness.categories.dto;

import java.util.Date;

public class ChangeReadinessCategoryReportDto {
	
	private String category;
	private String itemCode;
	private String itemDescription;
	private String date1;
	private String responsible;
	private String date2;
	private String approver;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}

}
