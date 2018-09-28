/**
 * 
 */
package com.rest.smoothchange.readiness.assessment.data.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;

@Entity
@Table(name = "CHANGE_READINESS_ASSESSMENT_DATA")
public class ReadinessAssessmentData extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="change_readiness_category_item_id")
	private ReadinessCategoryItems readinessCategoryItems;


	public ReadinessCategoryItems getReadinessCategoryItems() {
		return readinessCategoryItems;
	}


	public void setReadinessCategoryItems(ReadinessCategoryItems readinessCategoryItems) {
		this.readinessCategoryItems = readinessCategoryItems;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
