package com.hanyx.hjoyblog.dao;

import com.hanyx.hjoyblog.bean.ErrorLog;

public class ErrorLogDao extends CommonDao<ErrorLog> {

	@Override
	protected Class<ErrorLog> getEntityClass() {
		return ErrorLog.class;
	}

}
