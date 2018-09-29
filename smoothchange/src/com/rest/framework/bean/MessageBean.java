package com.rest.framework.bean;

import com.rest.framework.constant.MessageEnum.enumMessage;

public class MessageBean {
	String code;

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

	String message;

	public MessageBean(enumMessage mn) {
		code = mn.getCode();
		message = mn.getMessage();
	}

}
