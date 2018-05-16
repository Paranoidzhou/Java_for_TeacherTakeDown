package date;

import java.util.Calendar;

/**
 * 设置指定时间分量所对应的值
 * void set(int field,int value)
 * @author adminitartor
 *
 */
public class Calendar_set {
	public static void main(String[] args) {
		Calendar calendar 
			= Calendar.getInstance();
		System.out.println(calendar.getTime());
		//2008-08-08 20:08:08
		calendar.set(Calendar.YEAR, 2008);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.MONTH,Calendar.AUGUST);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DATE, 8);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 8);
		calendar.set(Calendar.SECOND, 8);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_WEEK, 5);
		System.out.println(calendar.getTime());
	}
}






