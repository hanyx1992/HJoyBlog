package com.hanyx.hjoyblog.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hanyx.hjoyblog.util.GlobalConstraints;
import com.hanyx.hjoyblog.util.SessionUtil;

/**
 * @desc:后台登录权限校验
 * @author 韩元旭
 */
public class SysAdminAuthFilter extends OncePerRequestFilter{

	private static Log LOGGER = LogFactory.getLog(SysAdminAuthFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (isToLogin(request) || SessionUtil.isLogined(request)) {
			filterChain.doFilter(request, response);
		} else {
			LOGGER.info("管理员未登录，跳转至登录页面...");
			response.sendRedirect(request.getContextPath() + GlobalConstraints.REQUEST_URL.TOLOGIN);
		}
	}

	/**
	 * @desc: 校验是否是跳转登录页面或者是登陆请求
	 * @author: 韩元旭
	 * @param request
	 * @return
	 * @date  : 2016年1月12日
	 */
	private boolean isToLogin(HttpServletRequest request) {
		return (request.getContextPath() + GlobalConstraints.REQUEST_URL.TOLOGIN).equals(request.getRequestURI())
				|| (request.getContextPath() + GlobalConstraints.REQUEST_URL.LOGIN).equals(request.getRequestURI());
	}

}
