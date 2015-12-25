package com.hanyx.hjoyblog.dao;

import com.hanyx.hjoyblog.bean.User;

public class UserDao extends CommonDao<User> {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

}
