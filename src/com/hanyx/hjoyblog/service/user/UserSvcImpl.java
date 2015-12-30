package com.hanyx.hjoyblog.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hanyx.hjoyblog.bean.User;
import com.hanyx.hjoyblog.dao.UserDao;
import com.hanyx.hjoyblog.util.GlobalConstraints;
import com.hanyx.hjoyblog.util.StringUtil;

/**
 * �û����ķ����ʵ��
 * @author ��Ԫ��
 */
public class UserSvcImpl implements IUserSvc{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserInfoByLoginName(String loginName) {
		if (StringUtil.isEmpty(loginName)) {
			return null;
		}
		//��ѯ�õ�¼���ƵĿ��õ��û�
		Query query = new Query();
		query.addCriteria(Criteria.where("loginName").is(loginName));
		query.addCriteria(Criteria.where("isUsed").is(GlobalConstraints.BEAN_DATA_STATE_ISUSED));
		
		return userDao.queryOne(query);
	}

	@Override
	public User verifyAdminLogin(String loginName, String loginPwd) throws Exception {
		//TODO �����ձ����װ
		if (StringUtil.isEmpty(loginName) || StringUtil.isEmpty(loginPwd)) {
			throw new Exception("�û������벻��Ϊ��");
		}
		//��MD5��������
		loginPwd = StringUtil.encryptByMD5(loginPwd);
		//���յ�¼���û������ҹ���Ա��Ϣ(�������߼�ʵ���Ͼ��������ж������Ա��)
		User user = this.getUserInfoByLoginName(loginName);
		//
		if (user == null || 
				user.getRole() != GlobalConstraints.USER_ROLE_ID_ADMINISTRATOR ||
				user.getLoginPwd().equals(loginPwd)) {
			throw new Exception("�û������������");
		}
		
		return user;
	}

}