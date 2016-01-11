package com.hanyx.hjoyblog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hanyx.hjoyblog.bean.ErrorCode;
import com.hanyx.hjoyblog.dao.ErrorCodeDao;
import com.hanyx.hjoyblog.util.GlobalConstraints;

/**
 * @desc:��ErrorCode���������в����ʼ������
 * @author ��Ԫ��
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml"})
public class ErrorCodeInit{

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private ErrorCodeDao errorCodeDao;
	
	@Test
	public void Test() {
		this.init();
		System.out.println(errorCodeDao.queryById(
				GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD).getMessage());
	}
	
	public void init() {
		//��ռ���
		mongoTemplate.dropCollection(ErrorCode.class);
		
		//��ʼ������
		ErrorCode data = new ErrorCode();
		data.setCode(GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD);
		data.setMessage("�û����������벻��Ϊ��");
		errorCodeDao.save(data);
		
		data.setCode(GlobalConstraints.ErrorCode.WRONG_NAME_OR_PWD);
		data.setMessage("�û��������������");
		errorCodeDao.save(data);
	}
	
}