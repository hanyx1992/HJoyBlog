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
		return request.getSession().getAttribute(GlobalConstraints.SESSION_KEY_USER)!=null;
	}
	
	/**
	 * @desc: 获取用户IP地址（来自网络）
	 * @author: 韩元旭
	 * @param request
	 * @return
	 * @date  : 2016年1月12日
	 */
	public static String getIpAddress(HttpServletRequest request) {
		// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}
}
