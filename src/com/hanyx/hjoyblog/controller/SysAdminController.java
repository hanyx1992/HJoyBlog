package com.hanyx.hjoyblog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value = "/index.do")
	public ModelAndView toLogin() {
		//TODO 校验如果已经登录直接跳转后台页面
		ModelAndView mv = new ModelAndView();
		mv.addObject("hello", mongoTemplate.getDb());
		mv.setViewName("/admin/login");
		return mv;
    }
	
	@RequestMapping(value = "/login.do")
	public String login(HttpServletRequest request, 
			HttpServletResponse response, 
			RedirectAttributes redirectAttributes) {
		//获取参数
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		
		redirectAttributes.addFlashAttribute("loginName",loginName);
		redirectAttributes.addFlashAttribute("loginPwd",loginPwd);
		
		User user = null;
		try {
			user = userSvc.verifyAdminLogin(loginName, loginPwd);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMsg",e.getMessage());
			return "redirect:/admin/index.do";
		}
		
		//用户名密码校验成功,销毁Session重建,防止Session劫持
		request.getSession().invalidate();
		request.getSession(true).setAttribute(GlobalConstraints.SESSION_KEY_USER, user);
		//用户cookie记录
		Cookie cookie = new Cookie("IS_LOGIN", "true");
		cookie.setPath("/");
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
		
		return "redirect:/admin/setting.do";
    }
	
	@RequestMapping(value = "/setting.do")
	public String setting() {
		return "/admin/setting";
	}
}
