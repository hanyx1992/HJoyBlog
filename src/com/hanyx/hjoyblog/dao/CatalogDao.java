package com.hanyx.hjoyblog.dao;

import com.hanyx.hjoyblog.bean.Catalog;

public class CatalogDao extends CommonDao<Catalog> {

	@Override
	protected Class<Catalog> getEntityClass() {
		return Catalog.class;
	}

}
