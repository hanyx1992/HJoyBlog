package com.hanyx.hjoyblog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanyx.hjoyblog.bean.User;
import com.hanyx.hjoyblog.service.user.IUserSvc;
import com.hanyx.hjoyblog.util.GlobalConstraints;
import com.hanyx.hjoyblog.util.SessionUtil;
import com.hanyx.hjoyblog.util.StringUtil;

/**
 * 后台管理页面
 * @author 韩元旭
 */
@Controller
@RequestMapping("/admin")
public class SysAdminController {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private IUserSvc userSvc;
	
	/**
	 * @desc: 跳转至登录页面
	 * @author: 韩元旭
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * @date  : 2016年1月11日
	 */
	@RequestMapping(value = "/index.do")
	public String toLogin(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (GlobalConstraints.COOKIE_KEY_AUTO_LOGIN.equals(c.getName())
						&& GlobalConstraints.COOKIE_VALUE_AUTO_LOGIN.equals(c.getValue())) {
					String ip = SessionUtil.getIpAddress(request);
					User user = userSvc.autoLogin(ip);
					return loginSuccess(request, user);
				}
			}
		}
		
		request.setAttribute("loginName", request.getParameter("loginName"));
		request.setAttribute("loginPwd", request.getParameter("loginPwd"));
		request.setAttribute("errorMsg", request.getParameter("errorMsg"));
		
		return "/admin/login";
    }
	
	/**
	 * @desc: 请求登录 
	 * @author: 韩元旭
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @date  : 2016年1月11日
	 */
	@RequestMapping(value = "/login.do")
	public String login(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//获取参数
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		String autoLogin = request.getParameter("autoLogin");
		String loginIP = SessionUtil.getIpAddress(request);
		
		//校验密码
		User user = userSvc.verifyAdminLogin(loginName, loginPwd);
		
		//记录自动登录IP
		if (!StringUtil.isRealEmpty(autoLogin) && "true".equals(autoLogin)) {
			Cookie c= new Cookie(GlobalConstraints.COOKIE_KEY_AUTO_LOGIN,
					GlobalConstraints.COOKIE_VALUE_AUTO_LOGIN);
			c.setPath("/");
			c.setMaxAge(60 * 60 * 24);
			response.addCookie(c);
			userSvc.logLoginIP(loginName, loginIP);
		}
		
		return loginSuccess(request, user);
    }

	/**
	 * @desc: 登录成功 页面重定向
	 * @author: 韩元旭
	 * @param request
	 * @param user
	 * @return
	 * @date  : 2016年1月12日
	 */
	private String loginSuccess(HttpServletRequest request, User user) {
		//用户名密码校验成功,销毁Session重建,防止Session劫持
		request.getSession().invalidate();
		request.getSession(true).setAttribute(GlobalConstraints.SESSION_KEY_USER, user);
		
		return "redirect:/admin/settings.do";
	}
	
	/**
	 * @desc: 后台首页
	 * @author: 韩元旭
	 * @param request
	 * @param response
	 * @return
	 * @date  : 2016年1月11日
	 */
	@RequestMapping(value = "/settings.do")
	public String settings(HttpServletRequest request, 
			HttpServletResponse response) {
		return "/admin/setting";
	}
	
}
