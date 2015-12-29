package com.hanyx.hjoyblog.service.error;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hanyx.hjoyblog.dao.ErrorCodeDao;

public class ErrorCodeSvcImpl implements IErrorCodeSvc {

	private ErrorCodeDao errorCodeDao;
	private static Log log = LogFactory.getLog(ErrorCodeSvcImpl.class);

	public ErrorCodeDao getErrorCodeDao() {
		return errorCodeDao;
	}

	@Autowired
	public void setErrorCodeDao(ErrorCodeDao errorCodeDao) {
		this.errorCodeDao = errorCodeDao;
	}
	@Override
	public String getValueById(String id) {
		String value = errorCodeDao.queryById(id).getMessage();
		if (value == null) {
			log.error("[" + id + "]" + "无对应的值");
		}
		return value;
	}

	@Override
	public String getValueByCode(String code) {
		String value = errorCodeDao.queryOne(
				new Query().addCriteria(Criteria.where("code").is(code)))
				.getMessage();
		if (value == null) {
			log.error("[" + code + "]" + "无对应的值");
		}
		return value;
	}
}
