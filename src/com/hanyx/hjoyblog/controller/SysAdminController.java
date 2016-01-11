package com.hanyx.hjoyblog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hanyx.hjoyblog.bean.User;
import com.hanyx.hjoyblog.service.user.IUserSvc;
import com.hanyx.hjoyblog.util.GlobalConstraints;

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
	 * @date  : 2016年1月11日
	 */
	@RequestMapping(value = "/index.do")
	public ModelAndView toLogin(HttpServletRequest request, 
			HttpServletResponse response) {
		//TODO 校验如果已经登录直接跳转后台页面
		request.setAttribute("loginName", request.getParameter("loginName"));
		request.setAttribute("loginPwd", request.getParameter("loginPwd"));
		request.setAttribute("errorMsg", request.getParameter("errorMsg"));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("hello", mongoTemplate.getDb());
		mv.setViewName("/admin/login");
		return mv;
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
		
		User user = userSvc.verifyAdminLogin(loginName, loginPwd);
		
		//用户名密码校验成功,销毁Session重建,防止Session劫持
		request.getSession().invalidate();
		request.getSession(true).setAttribute(GlobalConstraints.SESSION_KEY_USER, user);
		
		//用户cookie记录
		Cookie cookie = new Cookie("IS_LOGIN", "true");
		cookie.setPath("/");
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
		
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
