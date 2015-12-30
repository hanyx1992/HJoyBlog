package com.hanyx.hjoyblog.service.catalog;

import java.util.List;

import com.hanyx.hjoyblog.bean.Catalog;

public interface ICatalogSvc {
	public List<Catalog> queryAll();

	public void insert(String string, String string2, Short i, Short j,
			String nowTime);
}
