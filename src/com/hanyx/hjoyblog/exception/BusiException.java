package com.hanyx.hjoyblog.exception;

/**
 * @desc: 统一异常Bean
 * @author 韩元旭
 */
public class BusiException extends Exception{

	private static final long serialVersionUID = 9999L;

	/** 错误编码 */
	private static int code;
	/** 错误信息 */
	private static String msg;

	public BusiException(int code) {
		//TODO 加载Msg
	}

	public static int getCode() {
		return code;
	}

	public static String getMsg() {
		return msg;
	}
}
