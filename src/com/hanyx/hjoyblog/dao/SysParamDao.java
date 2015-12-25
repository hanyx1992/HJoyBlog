package com.hanyx.hjoyblog.dao;

import com.hanyx.hjoyblog.bean.SysParam;

public class SysParamDao extends CommonDao<SysParam>{

	@Override
	protected Class<SysParam> getEntityClass() {
		return SysParam.class;
	}

}
