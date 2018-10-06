/**
 * 
 */
package com.rest.smoothchange.readiness.assessment.data.item.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.readiness.assessment.data.entity.ReadinessAssessmentData;

@Entity
@Table(name = "CHANGE_READINESS_ASSESSMENT_DATA_ITEM")
public class ReadinessAssessmentDataItem extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="change_readiness_assessment_data_id")
	private ReadinessAssessmentData readinessAssessmentData;

	@Temporal(TemporalType.DATE)
	@Column(name="change_readiness_date_1")
	private Date changeReadinessDate1;
	
	
	@Column(name="hange_readiness_responsible")
	private String changeReadinessResponsible;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="change_readiness_date_2")
	private Date changeReadinessDate2;
	
	
	@Column(name="change_readiness_approver")
	private String changeReadinessApprover;


	public ReadinessAssessmentData getReadinessAssessmentData() {
		return readinessAssessmentData;
	}


	public void setReadinessAssessmentData(ReadinessAssessmentData readinessAssessmentData) {
		this.readinessAssessmentData = readinessAssessmentData;
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

	public String getChangeReadinessApprover() {
		return changeReadinessApprover;
	}

	public void setChangeReadinessApprover(String changeReadinessApprover) {
		this.changeReadinessApprover = changeReadinessApprover;
	}

	public void setChangeReadinessDate2(Date changeReadinessDate2) {
		this.changeReadinessDate2 = changeReadinessDate2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
