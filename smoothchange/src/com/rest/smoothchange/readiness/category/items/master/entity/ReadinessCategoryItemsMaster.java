/**
 * 
 */
package com.rest.smoothchange.readiness.category.items.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.readiness.category.master.entity.ReadinessCategoryMaster;

@Entity
@Table(name = "CHANGE_READINESS_CATEGORY_ITEMS_MASTER")
public class ReadinessCategoryItemsMaster extends AbstractIdentifierObject{
	

	@ManyToOne
	@JoinColumn(name="change_readiness_master_category_id")
    private ReadinessCategoryMaster readinessCategoryMaster;
	
	@Column(name="change_readiness_master_category_item_description")
	private String changeReadinessMasterCategoryItemDescription;
	
    @Column(name="change_readiness_master_category_item_code")
    private String changeReadinessMasterCategoryItemCode;

	public ReadinessCategoryMaster getReadinessCategoryMaster() {
		return readinessCategoryMaster;
	}

	public void setReadinessCategoryMaster(ReadinessCategoryMaster readinessCategoryMaster) {
		this.readinessCategoryMaster = readinessCategoryMaster;
	}

	public String getChangeReadinessMasterCategoryItemDescription() {
		return changeReadinessMasterCategoryItemDescription;
	}

	public void setChangeReadinessMasterCategoryItemDescription(String changeReadinessMasterCategoryItemDescription) {
		this.changeReadinessMasterCategoryItemDescription = changeReadinessMasterCategoryItemDescription;
	}

	public String getChangeReadinessMasterCategoryItemCode() {
		return changeReadinessMasterCategoryItemCode;
	}

	public void setChangeReadinessMasterCategoryItemCode(String changeReadinessMasterCategoryItemCode) {
		this.changeReadinessMasterCategoryItemCode = changeReadinessMasterCategoryItemCode;
	} 
    
    
    
	
}
