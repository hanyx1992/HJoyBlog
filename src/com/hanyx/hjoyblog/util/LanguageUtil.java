//package com.hanyx.hjoyblog.util;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//
//import com.hanyx.hjoyblog.dao.LanguageDao;
//
///**
// * 多语言支持工具类
// * @author 韩元旭
// */
//public final class LanguageUtil {
//	
//	private static Log LOGGER = LogFactory.getLog(LanguageUtil.class);
//	
//	private LanguageUtil() {};
//	
//	/** 语言环境 语种*/
//	public static String LANG;
//	static {
//		//TODO 去系统配置信息表中读取
//		LANG = "CHS";
//	}
//	
//	public static String get(String code) {
//		LanguageDao dao = new LanguageDao();
//		
//		if (StringUtil.isRealEmpty(code)) {
//			return code;
//		}
//		
//		String val = dao.queryOne(
//				new Query().addCriteria(Criteria.where("code").is(code))
//				.addCriteria(Criteria.where("lang").is(LANG)))
//		.getValue();
//		
//		if (StringUtil.isRealEmpty(val)) {
//			LOGGER.error("[" + LANG + "]语言获取[" + code + "]为空,请检查Language集合配置");
//		}
//		
//		return val;
//	}
//}
