package com.hanyx.hjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * 错误日志表
 * @author 梅海风
 */
public class ErrorCode {
	/*语言编码*/
	@Id
	private int code;
	/*错误信息*/
	private String message;

	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
