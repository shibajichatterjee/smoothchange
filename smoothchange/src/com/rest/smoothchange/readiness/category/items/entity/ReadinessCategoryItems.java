/**
 * 
 */
package com.rest.smoothchange.readiness.category.items.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	
}
