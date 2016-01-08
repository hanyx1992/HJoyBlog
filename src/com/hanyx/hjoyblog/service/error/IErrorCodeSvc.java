package com.hanyx.hjoyblog.service.error;

/**
 * @desc:错误编码
 * @author 韩元旭
 */
public interface IErrorCodeSvc {
	
	/**
	 * @desc: 根据错误编码获取提示信息
	 * @author: 韩元旭
	 * @param code
	 * @return
	 * @date  : 2016年1月8日
	 */
	public String getMessage(int code);
}
