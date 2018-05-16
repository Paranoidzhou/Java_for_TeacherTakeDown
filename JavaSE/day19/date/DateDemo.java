package date;

import java.util.Date;

/**
 * java.util.Date
 * Date的每一个实例用于表示一个具体的时间.
 * 内部维护一个long值,记录的是自1970年1月1日 00:00:00
 * 到其表示的时间之间所经过的毫秒.
 * 
 * Date设计存在缺陷,所以大部分操作时间的方法都被声明为
 * 过时的,不再建议使用.所以现在使用Date往往只又来表示
 * 一个时间点而已.
 * @author adminitartor
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		/*
		 * 获取Date内部维护的long值
		 */
		long time = date.getTime();
		System.out.println(time);
		
		time += 1000*60*60*24;
		
		date.setTime(time);
		System.out.println(date);
	}
}








