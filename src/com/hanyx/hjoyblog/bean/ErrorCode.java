package com.hanyx.hjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * 错误日志表
 * @author 梅海风
 */
public class ErrorCode {
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
