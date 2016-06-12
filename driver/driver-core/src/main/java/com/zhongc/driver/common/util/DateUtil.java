package com.zhongc.driver.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/** 完整时间 yyyy-MM-dd HH:00:00 */
	public static final String dtSimpleYmdh = "yyyy-MM-dd HH:00:00";

	/** 完整时间 yyyy-MM-dd */
	public static final String dtSimple = "yyyy-MM-dd";

	/** 完整时间 yyyy-MM-dd HH:00:00 */
	public static final String dtSimpleHMS = "yyyy-MM-dd HH:mm:ss";

	/** 完整时间 yyyy-MM-dd HH:mm*/
	public static final String  dtSimpleHM = "yyyy-MM-dd HH:mm";

	private static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");

	private static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");

	public static final String format(String format,Date date){
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 获取格式
	 *
	 * @param format
	 * @return
	 */
	public static final DateFormat getFormat(String format) {
		return new SimpleDateFormat(format);
	}

	/**
	 * yyyy-MM-dd HH:00:00
	 *
	 * @param date
	 * @return
	 */
	public static final String simpleFormatYmdh(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimpleYmdh).format(date);
	}

	/**
	 * yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 */
	public static final String simpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimple).format(date);
	}

	/**
	 * 获取指定时间的前一天时间
	 *
	 * @param date
	 * @return
	 */
	public static Date getBeforeDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}

	public static String getYyyyMMdd(Date date){
		return yyyyMMdd.format(date);
	}

	/**
	 * 获取指定时间的后一天时间
	 *
	 * @param date
	 * @return
	 */
	public static Date getAfterDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获取一周前的日期(当前日期往前推7天)
	 *
	 * @param date
	 * @return
	 */
	public static Date getWeekdayBeforeDate(Date date) {
		long beforeTime = (date.getTime() / 1000) - 24 * 60 * 60 * 7;
		date.setTime(beforeTime * 1000);
		return date;
	}

	public static int compare_date(String DATE1) throws ParseException {
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
		Date date = sdf.parse(DATE1);

		String DATE2 = getFormat(dtSimple).format(date)+" 21:00"; //当天21点
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}


	/**
	 * 获取一周前的日期(当前日期往前推7天)
	 *
	 * @param date
	 * @return
	 */
	public static String getWeekdayBeforeNow(Date date) {
		java.text.Format formatter = new SimpleDateFormat(
				"yyyy-MM-dd");
		long beforeTime = (date.getTime() / 1000) - 24 * 60 * 60 * 7;
		date.setTime(beforeTime * 1000);
		return formatter.format(date);
	}

	/**
	 * 获取一月前的日期(当前日期往前推7天)
	 *
	 * @param date
	 * @return
	 */
	public static String getMonthdayBeforeNow(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		date = calendar.getTime();

		java.text.Format formatter = new SimpleDateFormat(
				"yyyy-MM-dd");
		return formatter.format(date);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 *
	 * @param date
	 * @return
	 */
	public static final String simpleFormatHMS(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimpleHMS).format(date);
	}

	/**
	 * yyyy-MM-dd HH:00:00
	 *
	 * @param date
	 * @return
	 */
	public static final String dtSimpleHM(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimpleHM).format(date);
	}

	/**
	 * 获取指定时间的前一月时间
	 *
	 * @param date
	 * @return
	 */
	public static Date getMonthDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获取指定时间的后一月时间
	 *
	 * @param date
	 * @return
	 */
	public static Date getAfterMonthDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获取指定时间的前三月时间
	 *
	 * @param date
	 * @return
	 */
	public static Date getThreeMonthDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -3);
		date = calendar.getTime();
		return date;
	}

	/***
	 * 判断起始时间跨度是否大于92天
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static String checkTimeSpan(Date startDate,Date endDate) {
		long timeSpan = endDate.getTime() - startDate.getTime();
		long sumDay = timeSpan/1000/60/60/24;
		if(sumDay > 92) {
			return " 起始时间跨度不能大于3个月";
		}
		return "";
	}

	/**
	 * 获取从createDate开始到现在有几天
	 * @return
     */
	public static Long getNumDate(Date createDate){
		long timeSpan = new Date().getTime() - createDate.getTime();
		long sumDay = timeSpan/1000/60/60/24;
		return sumDay;
	}

	public static void main(String[] args) {
		System.out.println(DateUtil.getAfterDay(new Date()));
	}

	public static String getYyyyMMddHHmmss(Date date){
		String yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		return yyyyMMddHHmmss;
	}

//	public static String longToString(String date){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String result = null;
//        try {
//			result = sdf2.format(sdf.parse(date));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//        return result;
//	}
//
	public static String shortToYMD(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String result = null;
        try {
        	result =  sdf.format(sdf2.parse(date));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
        return result;
	}



}
