package com.qingbo.ginkgo.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * Project:c2-common
 * Package:com.qingbo.ginkgo.common.util
 * FileName:DateUtil.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月5日 上午9:50:45
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description: 常见日期类型处理：字符串、日期Date、长整数new Date(long)，parse(time).getTime()
 * Version:
 */
public class DateUtil {
	/**
	 * yyyy
	 */
	public static final SimpleDateFormat year = new SimpleDateFormat("yyyy");
	/**
	 * yyyy-MM-dd
	 */
	public static final SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * yyyy/MM/dd
	 */
	public static final SimpleDateFormat dayUTC = new SimpleDateFormat("yyyy/MM/dd");
	/**
	 * yyyy年MM月dd日
	 */
	public static final SimpleDateFormat chinaDay = new SimpleDateFormat("MM月dd日");
	/**
	 * yyMMdd
	 */
	public static final SimpleDateFormat shortDay = new SimpleDateFormat("yyMMdd");
	/**
	 * yyyyMMdd
	 */
	public static final SimpleDateFormat longDay = new SimpleDateFormat("yyyyMMdd");
	/**
	 * yyMM
	 */
	public static final SimpleDateFormat yearmonth = new SimpleDateFormat("yyMM");
	/**
	 * yyMMddHHmm
	 */
	public static final SimpleDateFormat shortDayTime = new SimpleDateFormat("yyMMddHHmm");
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * yyyyMMddHHmmssSSS
	 */
	public static final SimpleDateFormat microSeconds = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	/**
	 * yyMMddHHmmss
	 */
	public static final SimpleDateFormat smallMicroSeconds = new SimpleDateFormat("yyMMddHHmmss");
	
	public static enum FormatType { 
		/** yyyy, curdate() */
		YEAR, 
		/** yyyy-MM-dd, curdate() */
		DAY,
		/** yyyy/MM/dd, now() */
		DAYUTC,
		/** yyyy年MM月dd日, curdate() */
		CHINADAY,
		/** yyMMdd, curdate() */
		SHORTDAY,
		/** yyyyMMdd, curdate() */
		LONGDAY,
		/** yyMM, yearmonth */
		YEARMONTH,
		/** yyMMddHHmm, now() */
		SHORTDAYTIME,
		/** yyyy-MM-dd HH:mm:ss, now() */
		DAYTIME, 
		/** yyyyMMddHHmmssSSS, 17位毫秒时间序列号 */
		MICROSECONDS,
		/** yyMMddHHmmss, 12位毫秒时间序列号 */
		SMALLMICROSECONDS,
		/** 1406167122870, System.currentTimeInMillis() */
		JAVA, 
		/** 1406166160, unix_timestamp(now( )) */
		MYSQL
	};

	/** 
	 * @param time 支持格式：<li>yyyy-MM-dd, mysql: curdate()</li>
	 * <li>yyyy-MM-dd HH:mm:ss, mysql: now()</li>
	 * <li>1406167122870，java: System.currentTimeInMillis()</li> 
	 * <li>1406166160，mysql: unix_timestamp(now())</li> 
	 */
	public static Date parse(String time) {
		if(time==null || time.isEmpty()) return null;
		try {
			return dayTime.parse(time);
		}catch(Exception e) {}
		try{
			return day.parse(time);
		}catch (Exception e) {}
		try {
			return shortDayTime.parse(time);
		}catch(Exception e) {}
		try{
			return dayUTC.parse(time);
		}catch (Exception e) {}
		if(time.matches("\\d{10,17}")) {
			if(time.length()==17) {
				try{
					return microSeconds.parse(time);
				}catch(Exception e) {}
			}else if(time.length()==13) {
				return new Date(Long.valueOf(time));
			}else if(time.length()==12) {
				try{
					return smallMicroSeconds.parse(time);
				}catch(Exception e) {}
			}else if(time.length()==10) {
				return new Date(Long.valueOf(time)*1000);
			}
		}
		return null;
	}
	
	/** 
	 * @param type 格式化日期<li>DAY yyyy-MM-dd, mysql: curdate()</li>
	 * <li>DAYTIME yyyy-MM-dd HH:mm:ss, mysql: now()</li>
	 * <li>JAVA 1406167122870，java: System.currentTimeInMillis()</li> 
	 * <li>MYSQL 1406166160，mysql: unix_timestamp(now())</li> 
	 */
	public static String format(Date date, FormatType type) {
		if (date == null) {
			return null;
		}
		switch(type) {
		case YEAR:
			return year.format(date);
		case DAY:
			return day.format(date);
		case DAYUTC:
			return dayUTC.format(date);
		case CHINADAY:
			return chinaDay.format(date);
		case SHORTDAY:
			return shortDay.format(date);
		case LONGDAY:
			return longDay.format(date);
		case YEARMONTH:
			return yearmonth.format(date);
		case SHORTDAYTIME:
			return shortDayTime.format(date);
		case DAYTIME:
			return dayTime.format(date);
		case MICROSECONDS:
			return microSeconds.format(date);
		case SMALLMICROSECONDS:
			return smallMicroSeconds.format(date);
		case JAVA:
			return String.valueOf(date.getTime());
		case MYSQL:
			return String.valueOf(date.getTime()/1000);
		}
		return null;
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年10月10日 下午4:15:05
	 * Description 使用date初始化Calendar
	 * @param date
	 * @return
	 */
	private static Calendar initCalendar(Date date){
		Calendar c = Calendar.getInstance();   
		if(date != null){
			c.setTime(date);
		}
		return c;
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午9:53:48
	 * Description 设置当天开始时间（0时0分0秒）
	 * @param c
	 */
	private static void setDayBegin(Calendar c){
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午9:53:48
	 * Description 设置当天结束时间（23时59分59秒）
	 * @param c
	 */
	private static void setDayEnd(Calendar c){
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午9:30:23
	 * Description 获取当天开始时间
	 * @param date
	 * @return
	 */
	public static Date getDayBegin(Date date){
		Calendar c = initCalendar(date);
		setDayBegin(c);
		return c.getTime();
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午9:30:23
	 * Description 获取当天结束时间
	 * @param date
	 * @return
	 */
	public static Date getDayEnd(Date date) {
		Calendar c = initCalendar(date);
		setDayEnd(c);
		return c.getTime();
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午9:55:04
	 * Description 设置时间往后增加interval天（可以是负数）
	 * @param date
	 * @param interval
	 * @return
	 */
	public static Date getDayAdd(Date date, int interval){
		Calendar c = initCalendar(date);
		c.add(Calendar.DAY_OF_MONTH, interval);
		return c.getTime();
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午10:07:03
	 * Description 设置时间往后增加interval分钟
	 * @param date
	 * @param interval
	 * @return
	 */
	public static Date getTimeAdd(Date date, int interval){
		Calendar c = initCalendar(date);
		c.add(Calendar.MINUTE, interval);
		return c.getTime();
	}

	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午9:31:20
	 * Description 获取下一天开始时间
	 * @param date
	 * @return
	 */
	public static Date getNextDayBegin(Date date) {
		Calendar c = initCalendar(date);
		c.add(Calendar.DAY_OF_MONTH, 1);
		setDayBegin(c);
		return c.getTime();
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午9:31:20
	 * Description 获取下一天结束时间
	 * @param date
	 * @return
	 */
	public static Date getNextDayEnd(Date date) {
		Calendar c = initCalendar(date);
		c.add(Calendar.DAY_OF_MONTH, 1);
		setDayEnd(c);
		return c.getTime();
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午9:32:03
	 * Description 获取当月第一天开始时间
	 * @param date
	 * @return
	 */
	public static Date getMonthDayBegin(Date date){
		Calendar c = initCalendar(date);
		c.set(Calendar.DATE, 1);
		setDayBegin(c);
		return c.getTime();
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午9:33:08
	 * Description 获取当月最后一天结束时间
	 * @param date
	 * @return
	 */
	public static Date getMonthDayEnd(Date date){
		Calendar c = initCalendar(date);
		int max = c.getActualMaximum(Calendar.DATE);
		c.set(Calendar.DATE, max);
		setDayEnd(c);
		return c.getTime();
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年10月10日 下午4:32:25
	 * Description 使用时间参数设置时间
	 * @param date
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @return
	 */
	public static Date getTime(Date date, int hours, int minutes, int seconds){
    	Calendar c = initCalendar(date);
		c.set(Calendar.HOUR_OF_DAY, hours);
		c.set(Calendar.MINUTE, minutes);
		c.set(Calendar.SECOND, seconds);
		return c.getTime();
    }

	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月4日 下午4:24:47
	 * Description 获取当前系统时间
	 * @return
	 */
	public static Date getNow(){
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月3日 下午4:30:25
	 * Description 计算参数时间跟当前时间的差数（当前时间 - 参数时间）
	 * @param date
	 * @return 相差天数
	 */
	public static int getDayDiffer(Date date){
		Calendar c = Calendar.getInstance();
		long time = c.getTimeInMillis() - date.getTime();
		int result = (int) (time / 86400000); // 1000*60*60*24 = 86400000
		return result;
	}
}
