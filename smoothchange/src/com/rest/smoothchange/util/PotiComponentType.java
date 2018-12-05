package com.rest.smoothchange.util;

public enum PotiComponentType {

	PROCESS("PROCESS"), ORGANIZATION("ORGANIZATION"), TECHNOLOGY("TECHNOLOGY"), INFORMATION("INFORMATION");
   
   private String numValue;
	
   PotiComponentType(String numValue){
	   this.numValue = numValue;
   }
 
   public String getNumValue() {
	   return numValue;
   }
   
   public static PotiComponentType getValue(String numValue) {
	   for(PotiComponentType potiComponentType : PotiComponentType.values()) {
		   if(potiComponentType.getNumValue().equals(numValue)) {
			   return potiComponentType;
		   }
	   }
	   return null;
   }
  
}
