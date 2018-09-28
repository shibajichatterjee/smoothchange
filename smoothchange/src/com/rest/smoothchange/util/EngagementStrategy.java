package com.rest.smoothchange.util;

public enum EngagementStrategy {

	KeyPlayer("Key Player"), KeyInfluencer("Key Influencer"), KeepInformed("Keep Informed");

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
