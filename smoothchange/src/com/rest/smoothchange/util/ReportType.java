package com.rest.smoothchange.util;

public enum ReportType {

	StakeholderAnalysis("Stakeholder Analysis"),
	BusinessBenefitsMapping("Business Benefits Mapping"),
	ImpactAnalysis("Impact Analysis"),
	ChangeImplementationStrategy("Change Implementation Strategy"),
	ChangeReadinessAssessment("Change Readiness Assessment"),
	ChangeReadinessChecklist("Change Readiness Checklist"),
	CommunicationPlan("Communication Plan"),
	ChangeManagementPlan("Change Management Plan"),
	TrainingPlan("Training Plan");
	
	
	private String reportType;
	
	ReportType(String reportType){
	  this.reportType = reportType;
	}

	public String getReportType() {
		return reportType;
	}
	
	public static ReportType getValue(String reportType) {
		  for(ReportType e : ReportType.values()) {
			  if(e.getReportType().equals(reportType)) {
				  return e;
			  }
		  }
		  return null;
	}
	
	
}
