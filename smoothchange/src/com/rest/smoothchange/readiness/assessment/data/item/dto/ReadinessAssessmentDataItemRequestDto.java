package com.rest.smoothchange.readiness.assessment.data.item.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReadinessAssessmentDataItemRequestDto {

    private long readinessAssessmentDataId;
    
    private long readinessAssessmentDataItemId;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String changeReadinessDate1;
	
	private String changeReadinessResponsible;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

	private String changeReadinessDate2;

	private String changeReadinessApprover;

	public long getReadinessAssessmentDataId() {
		return readinessAssessmentDataId;
	}

	public void setReadinessAssessmentDataId(long readinessAssessmentDataId) {
		this.readinessAssessmentDataId = readinessAssessmentDataId;
	}

	public String getChangeReadinessDate1() {
		return changeReadinessDate1;
	}

	public void setChangeReadinessDate1(String changeReadinessDate1) {
		this.changeReadinessDate1 = changeReadinessDate1;
	}

	public String getChangeReadinessResponsible() {
		return changeReadinessResponsible;
	}

	public void setChangeReadinessResponsible(String changeReadinessResponsible) {
		this.changeReadinessResponsible = changeReadinessResponsible;
	}

	public String getChangeReadinessDate2() {
		return changeReadinessDate2;
	}

	public void setChangeReadinessDate2(String changeReadinessDate2) {
		this.changeReadinessDate2 = changeReadinessDate2;
	}

	public String getChangeReadinessApprover() {
		return changeReadinessApprover;
	}

	public void setChangeReadinessApprover(String changeReadinessApprover) {
		this.changeReadinessApprover = changeReadinessApprover;
	}

	public long getReadinessAssessmentDataItemId() {
		return readinessAssessmentDataItemId;
	}

	public void setReadinessAssessmentDataItemId(long readinessAssessmentDataItemId) {
		this.readinessAssessmentDataItemId = readinessAssessmentDataItemId;
	}
		
	
}
