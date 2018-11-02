package com.rest.smoothchange.util;

public enum GeneratedOrUploaded {

	Generated("Generated"),
	Uploaded("Uploaded");
	
	private String generatedUpload;
	
	GeneratedOrUploaded(String generatedUpload){
		this.generatedUpload = generatedUpload;
	}
	
	public String getGeneratedUpload() {
		return generatedUpload;
	}
	
	public static GeneratedOrUploaded  getValue(String generatedUpload) {
		for(GeneratedOrUploaded generatedOrUploaded : GeneratedOrUploaded.values()) {
			if(generatedOrUploaded.getGeneratedUpload().equals(generatedUpload)){
				return generatedOrUploaded;
			}
		}
		return null;
	}
	
	
	
}
