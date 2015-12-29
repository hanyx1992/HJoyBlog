package com.hanyx.hjoyblog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public final class StringUtil {
	
	private StringUtil() {};
	/**
	 * 判断是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * 根据分隔符分离字符串
	 * 
	 * @param string
	 * @param expr
	 * @return
	 */
	public static String[] string2Array(String string, String expr) {
		return string.split(expr);
	}

	/**
	 * 判断字符串是否包含空格
	 */
	public static boolean isSpace(String str){
		return str.contains("/s");
	}
	
	/**
	 * @desc: 用MD5加密字符串
	 * @author: 韩元旭
	 * @param str
	 * @return
	 * @date  : 2015年12月29日
	 */
	public static String encryptByMD5(String str) {
		if (StringUtil.isEmpty(str)) {
		     return str;
		}
		String retStr = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			//不可能没有....所以忽略了...
		}
		byte[] buf = md.digest(str.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		retStr = encoder.encode(buf);
		return retStr;

	}
}
