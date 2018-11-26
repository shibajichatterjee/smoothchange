package com.rest.framework.constant;

public class MessageEnum {
	public static final String API_KEY="xPk#C{v<!7t1cwp|M@);";
	public static final String unathorized="Unauthorized access";
	public static final String stakeHolderType="Stake holder type not matched";
	public static final String levelOfInfluence="Level Of Influence not matched";
	public static final String report_path="D:\\report\\";

	public enum enumMessage {
		SUCESS("S200", "SUCESS"),
		UnaAuthorizedAccess("S401", "Unauthorized Access"),
		NO_RECORDS("","No Records Found"),
		NO_RECORDS_BY_PROJECT_ID("","Project Id is not valid"),
		ID_NOT_VALID("","Id is not Valid"),
		NO_DELETE("","Delete is not possible,It has child");
		
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		String code;
		String message;

		private enumMessage(String code, String message) {
			this.code = code;
			this.message = message;
		}
	}

}
