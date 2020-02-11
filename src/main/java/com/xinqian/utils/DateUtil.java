package com.xinqian.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @ClassName: DateUtil 
 * @Description:日期工具类
 * @author:xq
 * @date: 2020年2月11日 下午2:15:36
 */
public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//根据生日计算年龄(string类型)
	public static int getAgeByBirthday(String birthday) throws ParseException {
		//获取日历控件
		//抽象类，不能直接实例化
		Calendar calendar = Calendar.getInstance();
		//获取当前时间的年月日
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_YEAR);
		//获取生日的年月日
		calendar.setTime(sdf.parse(birthday));
		int birYear = calendar.get(Calendar.YEAR);
		int birMonth = calendar.get(Calendar.MONTH);
		int birDay = calendar.get(Calendar.DAY_OF_YEAR);
		int age=nowYear-birYear;
		if (nowMonth>birMonth) {
			age++;
		}if (nowMonth==birMonth && nowDay>=birDay) {
			age++;
		}
		
		return age;
	}

	//根据生日计算年龄(date类型)
	public static int getAgeByBirthday(Date  birthday) throws ParseException{
		return getAgeByBirthday(sdf.format(birthday));
	}
	//计算两天相差的天数(date类型)
	public static int getCutByDay(Date date1,Date date2) {
		//计算当前的毫秒数
		Long time=24L*60*60*1000;
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if (time1>time2) {
			return (int) ((time1-time2)/time);
		}if (time1<time2) {
			return (int) ((time2-time1)/time);
		}
		return 0;
	}
	//计算两天相差的天数(string类型)
	public static int getCutByDay(String date1,String date2) {
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = sdf.parse(date1);
			d2 = sdf.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getCutByDay(d1,d2);
	}
	
	//根据给定的时间  获得当月的第一天的0时0分0秒  2019-12-12 == 2012-12-1 0:0:0
	public static Date getInitDateByMonth(Date date) {
		//获取日历控件
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//设置成初始时间
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime(); //返回设置之后的值
	}
	
	//根据给定的时间  获得当月的第一天的0时0分0秒  2019-12-12 == 2012-12-1 0:0:0
	public static Date getInitDateByMonth(String date) {
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getInitDateByMonth(d);
	}
	
	//获取当月最后一秒(date类型)
	public static Date getEndDateByMonth(Date date) {
		// 获取日历控件
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 设置成初始时间
		calendar.add(Calendar.MONTH,1); //获取当前月份+1
		//获得当月开始的时间
		Date initDateByMonth = getInitDateByMonth(calendar.getTime());
		calendar.setTime(initDateByMonth);
		calendar.add(Calendar.SECOND,-1);
		return calendar.getTime(); // 返回设置之后的值
	}
	//获取当月最后一秒(string类型)
	public static Date getEndDateByMonth(String date) {
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getEndDateByMonth(d);
	}
}
