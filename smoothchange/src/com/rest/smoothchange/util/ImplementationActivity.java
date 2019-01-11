package com.rest.smoothchange.util;

public enum ImplementationActivity {
	UndertakeStakeholderAnalysis("Undertake Stakeholder Analysis"), UndertakeImpactAnalysis("Undertake Impact Analysis"), CreateCommunicationPlan("Create Communication Plan"), CreateTrainingPlan("Create Training Plan"),
	CreateChangeManagementPlan(
			"Create Change Management Plan"),Other("Other");

	private String numVal;

	ImplementationActivity(String numVal) {
		this.numVal = numVal;
	}

	public String getNumVal() {
		return numVal;
	}

	public static ImplementationActivity getValue(String numVal) {
		for (ImplementationActivity e : ImplementationActivity.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}
}
