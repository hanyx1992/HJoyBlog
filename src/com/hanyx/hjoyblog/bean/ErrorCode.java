package com.hanyx.hjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * 错误日志表
 * @author 梅海风
 */
public class ErrorCode {
	/*语言编码*/
	private Short code;
	@Id
	private String id;
	/*错误信息*/
	private String message;

	public Short getCode() {
		return code;
	}

	public void setCode(Short code) {
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
