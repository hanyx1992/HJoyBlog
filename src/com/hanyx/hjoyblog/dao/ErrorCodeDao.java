package com.hanyx.hjoyblog.dao;

import com.hanyx.hjoyblog.bean.ErrorCode;

public class ErrorCodeDao extends CommonDao<ErrorCode> {

	@Override
	protected Class<ErrorCode> getEntityClass() {
		return ErrorCode.class;
	}

}
