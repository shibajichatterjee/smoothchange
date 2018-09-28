package com.rest.smoothchange.util;

public enum StakeholderType {

	Internal("Internal"), External("External");

	private String type;

	StakeholderType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static StakeholderType getValue(String type) {
		for (StakeholderType e : StakeholderType.values()) {
			if (e.getType().equals(type)) {
				return e;
			}
		}
		return null;
	}
}
