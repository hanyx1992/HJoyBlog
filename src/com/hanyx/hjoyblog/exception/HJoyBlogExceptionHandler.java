package com.hanyx.hjoyblog.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.hanyx.hjoyblog.util.GlobalConstraints;

/**
 * @desc:ȫ���쳣ͳһ������
 * @author ��Ԫ��
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
			case (GlobalConstraints.ErrorCode.AUTO_LOGIN_FAILD) :
				mv = new ModelAndView();
				mv.addObject("loginName", request.getParameter("loginName"));
				mv.addObject("loginPwd", request.getParameter("loginPwd"));
				mv.addObject("errorMsg", busiEx.getMessage());
				mv.setViewName("/admin/login");
				break;
			case (GlobalConstraints.ErrorCode.NOT_EXSIT_DATA):
				mv=new ModelAndView();
			    mv.addObject("errorMsg",busiEx.getMessage());
			    mv.setViewName("/admin/click1");
			    break;
			default :
				break;
			}
		}
		return mv;
	}

}
