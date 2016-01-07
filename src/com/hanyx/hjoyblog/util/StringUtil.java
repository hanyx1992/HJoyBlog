package com.hanyx.hjoyblog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Encoder;

/**
 * @desc:字符串工具类  扩展 Apache StringUtils
 * @author 韩元旭
 */
public final class StringUtil extends StringUtils {
	
	private StringUtil() {};

	/**
	 * @desc: 判断字符串是否为空,空白字符也为空
	 * @author: 韩元旭
	 * @param str
	 * @return
	 * @date  : 2016年1月7日
	 */
	public static boolean isRealEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * @desc: 用MD5加密字符串
	 * @author: 韩元旭
	 * @param str
	 * @return
	 * @date  : 2015年12月29日
	 */
	public static String encryptByMD5(String str) {
		if (StringUtil.isRealEmpty(str)) {
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
