package com.xinqian.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @ClassName: DateUtil 
 * @Description:���ڹ�����
 * @author:xq
 * @date: 2020��2��11�� ����2:15:36
 */
public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//�������ռ�������(string����)
	public static int getAgeByBirthday(String birthday) throws ParseException {
		//��ȡ�����ؼ�
		//�����࣬����ֱ��ʵ����
		Calendar calendar = Calendar.getInstance();
		//��ȡ��ǰʱ���������
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_YEAR);
		//��ȡ���յ�������
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

	//�������ռ�������(date����)
	public static int getAgeByBirthday(Date  birthday) throws ParseException{
		return getAgeByBirthday(sdf.format(birthday));
	}
	//����������������(date����)
	public static int getCutByDay(Date date1,Date date2) {
		//���㵱ǰ�ĺ�����
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
	//����������������(string����)
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
	
	//���ݸ�����ʱ��  ��õ��µĵ�һ���0ʱ0��0��  2019-12-12 == 2012-12-1 0:0:0
	public static Date getInitDateByMonth(Date date) {
		//��ȡ�����ؼ�
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//���óɳ�ʼʱ��
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime(); //��������֮���ֵ
	}
	
	//���ݸ�����ʱ��  ��õ��µĵ�һ���0ʱ0��0��  2019-12-12 == 2012-12-1 0:0:0
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
	
	//��ȡ�������һ��(date����)
	public static Date getEndDateByMonth(Date date) {
		// ��ȡ�����ؼ�
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// ���óɳ�ʼʱ��
		calendar.add(Calendar.MONTH,1); //��ȡ��ǰ�·�+1
		//��õ��¿�ʼ��ʱ��
		Date initDateByMonth = getInitDateByMonth(calendar.getTime());
		calendar.setTime(initDateByMonth);
		calendar.add(Calendar.SECOND,-1);
		return calendar.getTime(); // ��������֮���ֵ
	}
	//��ȡ�������һ��(string����)
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
