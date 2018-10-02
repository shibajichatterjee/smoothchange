package com.rest.smoothchange.util;

public enum CommunicationChannel {

	Facetofacemeeting("Face to face meeting"), Emails("Emails"), Intranet("Intranet"), Website("Website"), SocialMedia(
			"Social Media"), Postalletters("Postal letters"), Others("Others");

	private String numVal;

	CommunicationChannel(String numVal) {
		this.numVal = numVal;
	}

	public String getNumVal() {
		return numVal;
	}

	public static CommunicationChannel getValue(String numVal) {
		for (CommunicationChannel e : CommunicationChannel.values()) {
			if (e.getNumVal().equals(numVal)) {
				return e;
			}
		}
		return null;
	}

}
