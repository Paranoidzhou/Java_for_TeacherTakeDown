package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算商品促销日期
 * 促销日规则:商品过期日前两周的周三为促销日
 * 
 * 程序启动后要求用户输入商品的生产日期:
 * 如 2018-04-26
 * 
 * 输入保质期的天数:
 * 如 21
 * 
 * 经过计算,输出促销日:2018-05-02
 * 
 * @author adminitartor
 *
 */
public class Test2 {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入生产日期:");
		String dateStr = scanner.nextLine();
		
		System.out.println("请输入保质期天数:");
		int days = Integer.parseInt(scanner.nextLine());
		
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd");
		//成产日期
		Date date = sdf.parse(dateStr);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		//计算过日期
		calendar.add(Calendar.DAY_OF_YEAR, days);
		//计算前两周
		calendar.add(Calendar.DAY_OF_YEAR, -14);
		//设置为那周的周三
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		
		date = calendar.getTime();
		String line = sdf.format(date);
		System.out.println("促销日为:"+line);
		
	}
}








