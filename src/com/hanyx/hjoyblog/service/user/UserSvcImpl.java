package com.hanyx.hjoyblog.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hanyx.hjoyblog.bean.User;
import com.hanyx.hjoyblog.dao.UserDao;
import com.hanyx.hjoyblog.exception.BusiException;
import com.hanyx.hjoyblog.util.GlobalConstraints;
import com.hanyx.hjoyblog.util.StringUtil;

/**
 * 用户表的服务的实现
 * @author 韩元旭
 */
public class UserSvcImpl implements IUserSvc{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserInfoByLoginName(String loginName) {
		if (StringUtil.isRealEmpty(loginName)) {
			return null;
		}
		//查询该登录名称的可用的用户
		Query query = new Query();
		query.addCriteria(Criteria.where("loginName").is(loginName));
		query.addCriteria(Criteria.where("isUsed").is(GlobalConstraints.BEAN_DATA_STATE_ISUSED));
		
		return userDao.queryOne(query);
	}

	@Override
	public User verifyAdminLogin(String loginName, String loginPwd) throws Exception {
		if (StringUtil.isRealEmpty(loginName) || StringUtil.isRealEmpty(loginPwd)) {
			throw new BusiException(GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD);
		}
		//用MD5加密密码
		loginPwd = StringUtil.encryptByMD5(loginPwd);
		//按照登录的用户名查找管理员信息(这样的逻辑实际上就是允许有多个管理员了)
		User user = this.getUserInfoByLoginName(loginName);
		
		//校验密码
		if (user == null || 
				user.getRole() != GlobalConstraints.USER_ROLE_ID_ADMINISTRATOR ||
				user.getLoginPwd().equals(loginPwd)) {
			throw new BusiException(GlobalConstraints.ErrorCode.WRONG_NAME_OR_PWD);
		}
		
		return user;
	}

}
