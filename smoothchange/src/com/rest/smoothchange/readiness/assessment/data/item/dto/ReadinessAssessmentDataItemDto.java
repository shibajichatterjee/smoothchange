/**
 * 
 */
package com.rest.smoothchange.readiness.assessment.data.item.dto;

import java.util.Date;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.readiness.assessment.data.dto.ReadinessAssessmentDataDto;


public class ReadinessAssessmentDataItemDto extends AbstractIdentifierDTO{
	

	private ReadinessAssessmentDataDto readinessAssessmentDataDto;
	
	private Date changeReadinessDate1;
	
	private String changeReadinessResponsible;

	private Date changeReadinessDate2;
	
	private String changeReadinessApprover;

	public ReadinessAssessmentDataDto getReadinessAssessmentDataDto() {
		return readinessAssessmentDataDto;
	}

	public void setReadinessAssessmentDataDto(ReadinessAssessmentDataDto readinessAssessmentDataDto) {
		this.readinessAssessmentDataDto = readinessAssessmentDataDto;
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
