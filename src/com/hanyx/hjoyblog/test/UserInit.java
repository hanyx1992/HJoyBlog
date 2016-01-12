package com.hanyx.hjoyblog.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hanyx.hjoyblog.bean.User;
import com.hanyx.hjoyblog.dao.UserDao;
import com.hanyx.hjoyblog.util.GlobalConstraints;
import com.hanyx.hjoyblog.util.JBcrypt;

/**
 * @desc:向User用户表中插入初始化数据
 * @author 韩元旭
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml"})
public class UserInit{

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private UserDao userDao;
	
	@Test
	public void Test() {
		this.init();
		System.out.println(userDao.queryById("hanyx").getNickName());
	}
	
	public void init() {
		//清空集合
		mongoTemplate.dropCollection(User.class);
		
		//初始化数据
		User u = new User();
		u.setLoginName("hanyx");
		u.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u.setNickName("旭丶Joy");
		u.setRole(GlobalConstraints.USER_ROLE_ID_ADMINISTRATOR);
		u.setTel("13803648899");
		u.setEmail("hanyx1992@sina.com");
		u.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u.setCreateDate(new Date());
		userDao.save(u);
	}
	
}
