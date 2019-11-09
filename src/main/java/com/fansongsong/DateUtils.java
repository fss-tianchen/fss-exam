package com.fansongsong;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author fan
 *
 */
public class DateUtils {

	/**
	 * һ���ж��ٺ���
	 */
	static final long millionSecondsPerDay = 1000 * 60 * 60 * 24;

	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compare(Date date1, Date date2) {

		if (date1 == null || date2 == null)
			throw new RuntimeException("��������Ϊ��");

		return date1.compareTo(date2);
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public static int calculateAge(Date birthday) {

		if (birthday.compareTo(new Date()) > 0) {
			throw new RuntimeException("���������ղ��ܴ��ڵ�ǰ���� " + birthday);
		}

		// �������յ� �� �� ��
		Calendar canlendar = Calendar.getInstance();
		canlendar.setTime(birthday);

		int bdYear = canlendar.get(Calendar.YEAR);// ���������
		int bdMonth = canlendar.get(Calendar.MONTH);// �������·�
		int bdDay = canlendar.get(Calendar.DAY_OF_MONTH);// ��������

		System.out.println(" bdYear: " + bdYear + " bdMonth:" + bdMonth + " bdDay: " + bdDay);

		// ���㵱ǰ���� �� �� ��
		canlendar.setTime(new Date());
		int currentYear = canlendar.get(Calendar.YEAR);// ��ǰ�����
		int currentMonth = canlendar.get(Calendar.MONTH);// ��ǰ���·�
		int currentDay = canlendar.get(Calendar.DAY_OF_MONTH);// ��ǰ����

		System.out.println(
				" currentYear: " + currentYear + " currentMonth:" + currentMonth + " currentDay: " + currentDay);

		int age = currentYear - bdYear;
		if (currentMonth < bdMonth) {
			age--;
		} else if (currentMonth == bdMonth && currentDay < bdDay) {
			age--;
		}

		return age;
	}

	/**
	 * ���㵽������һ������ ��ʣ�������
	 * 
	 * @param futureDate
	 *            δ����ĳһ��
	 * @return
	 * @throws CmsException
	 */
	public static int remainDays(Date futureDate) throws CmsException {
		/**
		 * �����Ĳ����Ƿ�Ϸ���С�ڵ�ǰ��������Ϊ���Ϸ����׳��쳣
		 */
		if (futureDate.compareTo(new Date()) < 0) {
			throw new CmsException("δ�����ڲ���С�ڵ�ǰ���� �� " + futureDate);
		}

		// �����ж�����
		int days = (int) ((futureDate.getTime() - new Date().getTime()) / millionSecondsPerDay);

		return days;

	}

	/**
	 * �ж��Ƿ�Ϊ����
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		// ��ȡ���ڵ��ַ���
		String dateStr = sdf.format(date);

		// ��ȡ���ڵ��ַ���
		String todayStr = sdf.format(new Date());

		return (dateStr.equals(todayStr));

	}

	/**
	 * �ж��Ƿ��ڱ���
	 * @param date
	 * @return
	 */
	public static boolean isThisWeek(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

		firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

		firstDayOfWeek.add(Calendar.DATE, -day + 1 + 1);// �����+1����Ϊ�����տ�ʼ

		// ����һ������

		System.out.println(format.format(firstDayOfWeek.getTime()));

		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

		lastDayOfWeek.add(Calendar.DATE, 7 - day + 1);

		// ���������������

		System.out.println(format.format(lastDayOfWeek.getTime()));

		return (date.getTime() < lastDayOfWeek.getTime().getTime()
				&& date.getTime() > firstDayOfWeek.getTime().getTime());

	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public boolean isThisMonth(Date date) {
		// �Լ�ȥ��ɰɡ�����
		return false;
	}
	
	
	
	/**
	 *  ����ʱ����󣬳�ʼ�������³���1��0ʱ0��0��0����
	 *  ��ȡ�³���ʱ��  BOM��begin of the month�� 
	 * @param date
	 * @return
	 * 
	 */
	public static Date getBOM(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
		
	}
	
	/**
	 *  �������һ���µ��³�  Ȼ���һ�롣���Ǳ�����ĩ��ʱ��
	 *   
	 * @param date
	 * @return
	 */
	public static Date getEOM(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, -1);

		return calendar.getTime();
		
	}
	
	
	
	

}
