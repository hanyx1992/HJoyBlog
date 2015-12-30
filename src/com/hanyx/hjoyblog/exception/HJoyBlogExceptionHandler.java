package com.hanyx.hjoyblog.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.hanyx.hjoyblog.util.GlobalConstraints;

/**
 * @desc:全局异常统一处理类
 * @author 韩元旭
 */
public class HJoyBlogExceptionHandler implements HandlerExceptionResolver{

	@Override
	@SuppressWarnings("static-access")
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {
		if (e instanceof BusiException) {
			switch (((BusiException)e).getCode()) {
			case (GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD) :
			case (GlobalConstraints.ErrorCode.WRONG_NAME_OR_PWD) :
				//TODO返回登录页提示错误信息
				break;
			default :
				break;
			}
		}
		return null;
	}

}
