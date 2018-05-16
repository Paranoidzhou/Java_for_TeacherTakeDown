package date;

import java.util.Calendar;

/**
 * 计算时间操作
 * 
 * void add(int field,int amount)
 * 对指定的时间分量加上指定的值,若给定的值是负数
 * 则是减去.
 * @author adminitartor
 *
 */
public class Calendar_add {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		System.out.println(calendar.getTime());
		/*
		 * 计算3年2个月零25天以后那天所在周的周一是哪天?
		 */
		//加3年
		calendar.add(Calendar.YEAR, 3);
		System.out.println(calendar.getTime());
		
		//加2个月
		calendar.add(Calendar.MONTH, 2);
		System.out.println(calendar.getTime());
		
		//加25天
		calendar.add(Calendar.DAY_OF_YEAR, 25);
		System.out.println(calendar.getTime());
		//设置为周一
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println(calendar.getTime());
	}
}









