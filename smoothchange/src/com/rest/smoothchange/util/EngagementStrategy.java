package com.rest.smoothchange.util;

public enum EngagementStrategy {

	Training("Training"), Communication("Communication"), Both("Both"),TrainingAndOther("Training And Other"),CommunicationAndOther("Communication And Other"),BothAndOther("Both And Other"),Other("Other");

	private String numVal;

	EngagementStrategy(String numVal) {
		this.numVal = numVal;
	}

	public String getNumVal() {
		return numVal;
	}

	public static EngagementStrategy getValue(String numVal) {
		for (EngagementStrategy e : EngagementStrategy.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}

}
