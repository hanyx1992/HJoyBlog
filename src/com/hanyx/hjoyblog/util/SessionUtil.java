package com.hanyx.hjoyblog.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc:和Session有关的工具类
 * @author 韩元旭
 */
public final class SessionUtil {

	private SessionUtil() {};
	
	/**
	 * @desc: 管理员是否登录
	 * @author: 韩元旭
	 * @param request
	 * @return
	 * @date  : 2015年12月30日
	 */
	public static boolean isLogined (HttpServletRequest request) {
		//空校验
		if (request == null || request.getSession() == null) {
			return false;
		}
		return request.getAttribute(GlobalConstraints.SESSION_KEY_USER)!=null;
	}
}
