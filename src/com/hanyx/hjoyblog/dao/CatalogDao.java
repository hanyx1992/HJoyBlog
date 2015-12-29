package com.hanyx.hjoyblog.dao;

import org.springframework.stereotype.Repository;

import com.hanyx.hjoyblog.bean.Catalog;
@Repository
public class CatalogDao extends CommonDao<Catalog> {

	@Override
	protected Class<Catalog> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
