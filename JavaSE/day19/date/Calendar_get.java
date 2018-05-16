package date;

import java.util.Calendar;

/**
 * Calendar提供了方法:
 * int get(int field)
 * 根据给定的时间分量(各种时间单位)获取对应的值.
 * 
 * 时间分量是一个int值,无需记忆数字,Calendar提供
 * 了对应的常量.
 * @author adminitartor
 *
 */
public class Calendar_get {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		//获取年
		int year = calendar.get(Calendar.YEAR);
		//获取月  月从0开始!!
		int month = calendar.get(Calendar.MONTH)+1;
		//获取日
		int date = calendar.get(Calendar.DATE);
		System.out.println(year+"-"+month+"-"+date);
		
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int m = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		System.out.println(h+":"+m+":"+s);
		
		//今天是今年的第几天?
		int d = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("今天是今年的第"+d+"天");
		
		//今天是周几?
		d = calendar.get(Calendar.DAY_OF_WEEK)-1;
		String[] data = {"日","一","二","三","四","五","六"};
		System.out.println("今天是星期"+data[d]);
		
		//查看今年共多少天?
		d = calendar.getActualMaximum(
				Calendar.DAY_OF_YEAR);
		System.out.println("今年共:"+d+"天");
		
		d = calendar.getActualMaximum(
				Calendar.DAY_OF_MONTH);
		System.out.println("当月共:"+d+"天");

	}
}








