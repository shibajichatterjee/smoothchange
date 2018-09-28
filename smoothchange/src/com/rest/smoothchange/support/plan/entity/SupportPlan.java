/**
 * 
 */
package com.rest.smoothchange.support.plan.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;

@Entity
@Table(name = "SUPPORT_PLAN")
public class SupportPlan extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	
	@JoinColumn(name="change_management_plan_id")
	@ManyToOne
	private ChangeManagementPlan changeManagementPlan;


	public ChangeManagementPlan getChangeManagementPlan() {
		return changeManagementPlan;
	}


	public void setChangeManagementPlan(ChangeManagementPlan changeManagementPlan) {
		this.changeManagementPlan = changeManagementPlan;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
