package com.hanyx.hjoyblog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
	
	private DateUtil() {};
	
	// 一天的毫秒数 86400000 = 24*60*60*1000;
	private static final int MILLIS_PER_DAY = 86400000;
	// 一小时的毫秒数600000 = 24*60*60*1000;
	private static final int MILLIS_PER_HOUR = 3600000;
	//日期格式
	private static final String DateFormatForyyyyMMdd="yyyy-MM-dd";
	private static final String DateFormatForyyyyMMddHHmmss="yyyy-MM-dd HH:mm:ss";
/**
 * 获取当前年月日(String 不含秒)
 * @return
 */
	public static String getCurrentDay() {
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormatForyyyyMMdd);
		return sdf.format(nowDate);
	}
/**
 * 获取当前时间(字符串类型 含秒)
 * @return
 */
	public static String getNowTime() {
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormatForyyyyMMddHHmmss);
		return sdf.format(nowDate);
	}
	/**
	 * @desc: 获取当前时间Date类型
	 * @author: 梅海风
	 * @return
	 * @date  : 2016年1月15日
	 */
	public static synchronized Date getCurrDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	/**
	 * @desc:获取日期格式化对象 
	 * @author: 梅海风
	 * @param parttern
	 * @return
	 * @date  : 2016年1月15日
	 */
	private static SimpleDateFormat getFormatter(String parttern) {
		return new SimpleDateFormat(parttern);
	}
	/**
	 * @desc: 把字符串日期默认转换日期格式的Date对象 含秒
	 * @author: 梅海风
	 * @param strDate
	 * @return
	 * @date  : 2016年1月15日
	 */
	public static Date format2(String strDate) {
		Date d = null;
		if ("".equals(strDate)){
			return null;
		}else{
			try {
				d = getFormatter(DateFormatForyyyyMMddHHmmss).parse(strDate);
			} catch (ParseException pex) {
				return null;
			}
		}
		return d;
	}
	
	/**
	 * @desc: 把字符串日期默认转换日期格式的Date对象 不含秒
	 * @author: 梅海风
	 * @param strDate
	 * @return
	 * @date  : 2016年1月15日
	 */
	public static Date format1(String strDate) {
		Date d = null;
		if ("".equals(strDate)){
			return null;
		}else{
			try {
				d = getFormatter(DateFormatForyyyyMMdd).parse(strDate);
			} catch (ParseException pex) {
				return null;
			}
		}
		return d;
	}
	/**
	 * 获取时间差
	 * 
	 * @param choose
	 * @param lastDate
	 * @return
	 */
	public static long getDf(String choose, String lastDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormatForyyyyMMddHHmmss);
		try {
			Date ld = sdf.parse(lastDate);
			Date now = sdf.parse(getNowTime());
			long msecond = now.getTime() - ld.getTime();
			if (choose.equals("s")) {
				return msecond / 1000;
			}
			if (choose.equals("m")) {
				return msecond / (1000 * 60);
			}
			if (choose.equals("h")) {
				return msecond / MILLIS_PER_HOUR;
			}
			if (choose.equals("d")) {
				return msecond / MILLIS_PER_DAY;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @获取当月的天数(或者最后一天)
	 * @param args
	 */
	public static int getDaysOfMouth() {
		String[] dates = getCurrentDay().split("-");
		int year = Integer.parseInt(dates[0]);
		int mouth = Integer.parseInt(dates[1]);
		int Aday=0;
		String m1 = "1,3,5,7,8,10,12";
		String m2 = "4,6,9,11";
		if (m1.contains(String.valueOf(mouth))) {
			Aday = 31;
		}
		if (m2.contains(String.valueOf(mouth))) {
			Aday = 30;
		}
		if ((0 == year % 400) || (0 == year % 4 && 0 != year % 100)) {
			Aday=29;
		}else{
			Aday=28;
		}
		return Aday;
	}
}
