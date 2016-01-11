package com.hanyx.hjoyblog.exception;

import com.hanyx.hjoyblog.service.error.IErrorCodeSvc;
import com.hanyx.hjoyblog.util.GlobalConstraints;
import com.hanyx.hjoyblog.util.SpringBeanUtil;

/**
 * @desc: 统一异常Bean
 * @author 韩元旭
 */
public class BusiException extends Exception{

	private static final long serialVersionUID = 9999L;
	
	/** 用来调用数据库,静态一个足够 */
	private static IErrorCodeSvc errorCodeSvc;
	
	static {
		errorCodeSvc = (IErrorCodeSvc) SpringBeanUtil.getBean("errorCodeSvc");
	}
	
	/** 错误编码 */
	private int code;
	/** 错误信息 */
	private String msg;
	
	/**
	 * 默认未知异常
	 */
	public BusiException() {
		this.code = -1;
		this.msg = GlobalConstraints.ErrorCode.UNKNOW_ERROR_MESSAGE;
	}
	
	/**
	 * 根据错误编码封装异常
	 * @param code
	 */
	public BusiException(int code) {
		this.code = code;
		this.msg = errorCodeSvc.getMessage(code);
	}

	public int getErrorCode() {
		return code;
	}

	/**
	 * 返回错误信息
	 */
	@Override
	public String getMessage() {
		return msg;
	}

}
