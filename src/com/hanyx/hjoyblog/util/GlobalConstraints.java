package com.hanyx.hjoyblog.util;

/**
 * 全局常量配置
 * @author 韩元旭
 */
public final class GlobalConstraints {
	
	private GlobalConstraints() {};
	
	/** 所有表中的数据状态 - 未用 */
	public static final short BEAN_DATA_STATE_NOTUSED = 0;
	/** 所有表中的数据状态 - 使用 */
	public static final short BEAN_DATA_STATE_ISUSED = 1;
	
	/** 用户表中角色ID - 管理员 */
	public static final short USER_ROLE_ID_ADMINISTRATOR = 0;
	/** 用户表中角色ID - 访客 */
	public static final short USER_ROLE_ID_GUEST = 1;
	
	/** Session中管理员的信息 */
	public static final String SESSION_KEY_USER = "HJOY_USER_INFO";
	
	/** Cookie中信息 */
	public static final String COOKIE_KEY_AUTO_LOGIN = "HJOY_BLOG_AUTO_LOGIN";
	public static final String COOKIE_VALUE_AUTO_LOGIN = "TRUE";
	
	/** 错误编码 */
	public interface ErrorCode {
		/** 未知异常的提示信息 */
		public static final String UNKNOW_ERROR_MESSAGE = "未知异常";
		
		/** 用户名或密码为空 */
		public static final int EMPTY_NAME_OR_PWD = 10001;
		/** 用户名或密码错误 */
		public static final int WRONG_NAME_OR_PWD = 10002;
		/** 自动登录失败 */
		public static final int AUTO_LOGIN_FAILD = 10003;
	}
	
	/** 请求路径 */
	public  interface REQUEST_URL {
		/** 跳转登录页面 */
		public static final String TOLOGIN = "/admin/index.do";
		/** 登录请求 */
		public static final String LOGIN = "/admin/login.do";
	}
}
