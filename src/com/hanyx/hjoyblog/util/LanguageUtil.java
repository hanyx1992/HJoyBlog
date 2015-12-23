package com.hanyx.hjoyblog.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hanyx.hjoyblog.dao.LanguageDao;

/**
 * 多语言支持工具类
 * @author 韩元旭
 */
public class LanguageUtil {
	private static Log log = LogFactory.getLog(LanguageUtil.class);
	
	/** 语言环境 语种*/
	public static String LANG;
	static {
		//TODO 去系统配置信息表中读取
		LANG = "CHS";
	}
	
	public static String get(String code) {
		LanguageDao dao = new LanguageDao();
		
		if (StringUtil.isEmpty(code)) {
			return code;
		}
		
		String val = dao.queryOne(
				new Query().addCriteria(Criteria.where("code").is(code))
				.addCriteria(Criteria.where("lang").is(LANG)))
		.getValue();
		
		if (StringUtil.isEmpty(val)) {
			log.error("[" + LANG + "]语言获取[" + code + "]为空,请检查Language集合配置");
		}
		
		return val;
	}
}
