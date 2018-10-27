/**
 * 
 */
package com.rest.smoothchange.readiness.category.items.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;

@Entity
@Table(name = "CHANGE_READINESS_CATEGORY_ITEMS")
public class ReadinessCategoryItems extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="change_readiness_category_id")
	private ChangeReadinessCategories changeReadinessCategories;
	
	@Column(name="change_readiness_category_item_description")
    private String changeReadinessCategoryItemDescription;
	
	@Column(name="change_readiness_category_item_code")
	private String changeReadinessCategoryItemCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name="change_readiness_date_1")
	private Date changeReadinessDate1;
	
	@Column(name="change_readiness_responsible")
	private String changeReadinessResponsible;
	
	@Temporal(TemporalType.DATE)
	@Column(name="change_readiness_date_2")
	private Date changeReadinessDate2;
	
	@Column(name="change_readiness_approver")
	private String changeReadinessApprover;
	
	public ChangeReadinessCategories getChangeReadinessCategories() {
		return changeReadinessCategories;
	}

	public void setChangeReadinessCategories(ChangeReadinessCategories changeReadinessCategories) {
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
