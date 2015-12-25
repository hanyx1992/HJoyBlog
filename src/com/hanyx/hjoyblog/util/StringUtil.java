package com.hanyx.hjoyblog.util;

public class StringUtil {
	/**
	 * ÅÐ¶ÏÊÇ·ñÎª¿Õ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * ¸ù¾Ý·Ö¸ô·û·ÖÀë×Ö·û´®
	 * 
	 * @param string
	 * @param expr
	 * @return
	 */
	public static String[] string2Array(String string, String expr) {
		return string.split(expr);
	}

	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñ°üº¬¿Õ¸ñ
	 */
	public static boolean isSpace(String str){
		return str.contains("/s");
	}
}
