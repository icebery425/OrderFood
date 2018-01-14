package com.worldunion.prophesy.utils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	private static String DATEFORMAT = "yyyy-MM-dd";
	
	public static String format(Date d,String ftm){
		SimpleDateFormat sdf =   new SimpleDateFormat( ftm );
		return sdf.format(d);
	}
	public static String getAfterNday(int num,String ftm){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, num); 
		Date date = calendar.getTime();
		return format(date,ftm);
	}
	public static String getBeforeday(int num,String ftm){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, num); 
		Date date = calendar.getTime();
		return format(date,ftm);
	}
	
	
	
	/**
	 * 当天是星期几
	 * @return
	 */
	public static int getDayOfWeek(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		int day = c.get(Calendar.DAY_OF_WEEK);
		day--;
		return day;
	}
	
	/**
	 * 当天是几号
	 * @return
	 */
	public static int getDayOfMonth(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		int day = c.get(Calendar.DAY_OF_MONTH);
//		day--;
		return day;
	}
	/**
	 * 当天是几月
	 * @return
	 */
	public static int getCurrentMonth(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		int mon = c.get(Calendar.MONTH);
		mon++;
		return mon;
	}
	
	private static String baseWeekGen(Calendar c) {
		int weeki = c.get(Calendar.WEEK_OF_YEAR);
		int day=c.get(Calendar.DAY_OF_WEEK);//当天是星期几
		if(day==1 && weeki > 1){							//如果是星期日，则周减一，因为系统中一周的开始是星期一
			weeki= weeki-1;
		}
		String week = weeki+"";
	    if (week.length() == 1)
	      week = "0" + week;
	    String year = Integer.toString(c.get(Calendar.YEAR));
	    return year +"-"+ week;
	}
	/**
	   * 产生周序列,即得到当前时间所在的年度是第几周
	   *
	   * @return yyyykk
	   *//*
	public static String getSeqWeek() {
	    Calendar c = Calendar.getInstance(Locale.CHINA);
	    return baseWeekGen(c);
	}
	
	*//**
	 * 返回第num天前是该时间所有年度的第几周
	 * @param num
	 * @return yyyykk
	 *//*
	public static String getBeforeWeek(int num){
		String beforeDate = getBeforeday(num, DATEFORMAT);
		String week = null;
		try {
			Date newday = new SimpleDateFormat(DATEFORMAT).parse(beforeDate);
			Calendar c = Calendar.getInstance();
			c.setTime(newday);
			week = baseWeekGen(c);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return week;
	}*/
	public static void main(String[] args) {
		/*try {
			Date newday = new SimpleDateFormat("yy-MM-dd").parse("2017-01-08");
			Calendar c = Calendar.getInstance();
			c.setTime(newday); 
			int week = c.get(Calendar.WEEK_OF_YEAR);
			int hour=c.get(Calendar.DAY_OF_WEEK);
			if(hour==1){
				week= week-1;
			}
			String weekstr = week+"";
		    if (weekstr.length() == 1)
		    	weekstr = "0" + weekstr;
		    String year = Integer.toString(c.get(Calendar.YEAR));
		    System.out.println("0: "+year+weekstr);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		Date day = new Date();
		System.out.println(format(day, "yyyy"));*/
		System.out.println("今天是"+getCurrentMonth()+"月"+getDayOfMonth()+"号");
//		System.out.println("4天后是"+getBeforeWeek(0));
		System.out.println("4天后是"+getBeforeday(4,"yyyyMMdd"));
//		System.out.println("今天是周"+getDayOfWeek());
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        System.out.println(sdf.format(date));
        System.out.println(getLastDate(date,-12));
		
		System.out.println("去年："+getLastYear(-1));
	}

	/**
	 * 从某个时间，获取该时间的后几天
	 * @param startDate
	 * @return 2017-01-02
	 */
	public static String getLastDateDay(String startDate,int number) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(startDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.DATE, number);
		return sdf.format(cal.getTime());
	}

	/**
	 * 从某个时间，获取几个月前的月份
	 * @param startDate
	 * @return 201701
	 */
	public static String getLastDate(String startDate,int number) {
		String endData= null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		try {
			endData = DateUtil.getLastDate(dateFormat.parse(startDate),number);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return endData.replace("-", "");
	}

	/**
	 * 从某个时间，获取几个月前的月份   
	 * @param date
	 * @return 2017-01
	 */
    public static String getLastDate(Date date,int number) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, number);
        return sdf.format(cal.getTime());
    }
    public static String getLastYear(int num){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
		 //过去一年
	   c.setTime(new Date());
	   c.add(Calendar.YEAR, num);
	   Date y = c.getTime();
	  
	   String year =  DateUtil.format( y, "yyyy");
	  return year;
    }
    /**
	 * 从某个时间，获取几个月前的月份   
	 * @param date
	 * @return 2017-01
	 */
    public static String getLastMonthYear(Date date,int number) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, number);
        Date y = cal.getTime();
  	  
 	   	String year =  DateUtil.format( y, "yyyy");
        return year;
    }




	/**
	 * 从某个时间获取某个月前的月份，返回值为 2017年3月
	 * @param date
	 * @param number
	 * @return
	 */
	public static String getMonthByDate(Date date,int number) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, number);
		return sdf.format(cal.getTime());
	}


}
