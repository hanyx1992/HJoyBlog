package com.hanyx.hjoyblog.service.error;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hanyx.hjoyblog.bean.ErrorCode;
import com.hanyx.hjoyblog.dao.ErrorCodeDao;
import com.hanyx.hjoyblog.util.GlobalConstraints;

/**
 * @desc:错误编码服务层实现
 * @author 韩元旭
 */
public class ErrorCodeSvcImpl implements IErrorCodeSvc {
	@Autowired
	private ErrorCodeDao errorCodeDao;
	
	private static Log log = LogFactory.getLog(ErrorCodeSvcImpl.class);
	
	@Override
	public String getMessage(int code) {
		ErrorCode bean = errorCodeDao.queryById(code);
		if(bean != null){
			return bean.getMessage();
		}
		log.error("根据ID:["+code+"]"+"找不到对应的错误信息");
		return GlobalConstraints.ErrorCode.UNKNOW_ERROR_MESSAGE;
	}


}
