package com.hanyx.hjoyblog.bean;

import org.springframework.data.annotation.Id;

public class ErrorLog {
	private String code;
	@Id
	private String id;
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
