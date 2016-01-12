package com.hanyx.hjoyblog.service.user;

import com.hanyx.hjoyblog.bean.User;

/**
 * 用户表的服务
 * @author 韩元旭
 */
public interface IUserSvc {

	/**
	 * 根据登录名称查询用户信息
	 * @param loginName
	 * @return
	 */
	User getUserInfoByLoginName(String loginName);
	
	/**
	 * 验证管理员登录名密码
	 * @param loginName
	 * @param loginPwd
	 * @throws Exception
	 * @return
	 */
	User verifyAdminLogin(String loginName, String loginPwd) throws Exception;
	
	/**
	 * @desc: 记录访问IP地址
	 * @author: 韩元旭
	 * @param loginName
	 * @param loginIP
	 * @throws Exception
	 * @date  : 2016年1月12日
	 */
	void logLoginIP(String loginName, String loginIP) throws Exception;

	/**
	 * @desc: 自动登录
	 * @author: 韩元旭
	 * @param ip
	 * @return
	 * @date  : 2016年1月12日
	 */
	User autoLogin(String ip)  throws Exception;
}
