package com.hanyx.hjoyblog.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hanyx.hjoyblog.bean.ErrorLog;
import com.hanyx.hjoyblog.dao.ErrorLogDao;


public class ErrorSvcImpl implements IErrorSvc {
	@Autowired
	private ErrorLogDao errorLogDao;
	private static Log log = LogFactory.getLog(ErrorSvcImpl.class);
	@Override
	public String getValueById(String id) {
		String value=errorLogDao.queryById(id).getMessage();
		if(value==null){
			log.error("["+id+"]"+"无对应的值");
		}
		return value;
	}

	@Override
	public String getValueByCode(String code) {
		String value=errorLogDao.queryOne(new Query().addCriteria(Criteria.where("code").is(code))).getMessage();
		if(value==null){
			log.error("["+code+"]"+"无对应的值");
		}
		return value;
	}

}
