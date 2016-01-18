package com.hanyx.hjoyblog.service.catalog;

import java.util.Date;
import java.util.List;

import com.hanyx.hjoyblog.bean.Catalog;

/**
 * @desc: 目录服务层接口
 * @author 梅海风
 */
public interface ICatalogSvc {
	public List<Catalog> queryAll();

	public void insert(String string, String string2, Short i, Short j,
			Date nowTime);
}
