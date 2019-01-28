package com.rest.smoothchange.util;

public enum Status {

	Drafted("Drafted"), Sentforapproval("Sent for approval"), Onhold("On hold"),Delivered("Delivered"),Other("Other");

	private String numVal;

	Status(String numVal) {
		this.numVal = numVal;
	}

	public String getNumVal() {
		return numVal;
	}

	public static Status getValue(String numVal) {
		for (Status e : Status.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}

}
