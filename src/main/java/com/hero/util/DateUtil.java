package com.hero.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author chenwenwei
 * @time 2018.12.25
 */
public class DateUtil {
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

	private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat sdfTime2 = new SimpleDateFormat("HH:mm:ss");
	private final static SimpleDateFormat ymdh = new SimpleDateFormat("yyyyMMddHH");
	private final static SimpleDateFormat ymdhms = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}

	/**
	 * 获取YYYYMMDDHH格式
	 * 
	 * @return
	 */
	public static String getYMDH() {
		return ymdh.format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays() {
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	/**
	 * 获取HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime2() {
		return sdfTime2.format(new Date());
	}

	/**
	 * @Title: compareDate
	 * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean
	 * @throws @author
	 *             luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if (fomatDate(s) == null || fomatDate(e) == null) {
			return false;
		}
		return fomatDate(s).getTime() >= fomatDate(e).getTime();
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long aa = 0;
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24))
					/ 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * 得到n天之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	/**
	 * 得到n天之后是周几
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	public static String getYMDHAfterHour(String hours) {
		int daysInt = Integer.parseInt(hours);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.HOUR, daysInt); // 加小时数
		Date date = canlendar.getTime();

		String dateStr = ymdh.format(date);

		return dateStr;
	}

	public static String getYMDHMSAfterHour(String hours) {
		int daysInt = Integer.parseInt(hours);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.HOUR, daysInt); // 加小时数
		Date date = canlendar.getTime();

		String dateStr = ymdhms.format(date);

		return dateStr;
	}

	public static String getYMDHMS() {
		Calendar canlendar = Calendar.getInstance(); // java.util包
		Date date = canlendar.getTime();
		String dateStr = ymdhms.format(date);

		return dateStr;
	}

	public static boolean compareDate1(String s, String e) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date bt = null;
		Date et = null;
		try {
			bt = sdf.parse(s);
			et = sdf.parse(e);
			if (null != et) {
				if (!bt.before(et)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(compareDate1("2018-03-27 15:12:42", "2018-03-27 05:17:20"));
		System.out.println(getDays());
		System.out.println(getAfterDayWeek("3"));
		System.out.println(getAfterDayDate("30"));

		String ymdh2 = getYMDH();
		System.out.println(ymdh2);

		System.out.println(getYMDHAfterHour("3"));
		System.out.println(getYMDHMSAfterHour("24"));
	}

}
