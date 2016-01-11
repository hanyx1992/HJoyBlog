package com.hanyx.hjoyblog.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.hanyx.hjoyblog.util.GlobalConstraints;

/**
 * @desc:全局异常统一处理类
 * @author 韩元旭
 */
public class HJoyBlogExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {
		ModelAndView mv = null;
		if (e instanceof BusiException) {
			BusiException busiEx = (BusiException)e;
			switch (busiEx.getErrorCode()) {
			case (GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD) :
			case (GlobalConstraints.ErrorCode.WRONG_NAME_OR_PWD) :
				mv = new ModelAndView();
				mv.addObject("loginName", request.getParameter("loginName"));
				mv.addObject("loginPwd", request.getParameter("loginPwd"));
				mv.addObject("errorMsg", busiEx.getMessage());
				mv.setViewName("/admin/login");
				break;
			default :
				break;
			}
		}
		return mv;
	}

}
