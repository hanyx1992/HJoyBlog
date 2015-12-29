package com.hanyx.hjoyblog.service.catalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.hanyx.hjoyblog.bean.Catalog;
import com.hanyx.hjoyblog.dao.CatalogDao;
@Service
public class CatalogSvcImpl implements ICatalogSvc {
	@Autowired
	private CatalogDao catalogDao;

	@Override
	public List<Catalog> queryAllCatalog() {
		return catalogDao.queryList(new Query().with(new Sort(Direction.ASC,"create_date")));
	}

}
