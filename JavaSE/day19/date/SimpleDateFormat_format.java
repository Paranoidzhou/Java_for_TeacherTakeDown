package date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 可以将字符串与Date之间按照指定的日期格式
 * 进行相互转换.
 * @author adminitartor
 *
 */
public class SimpleDateFormat_format {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		/*
		 * 2018-04-26 10:22:23
		 * yyyy-MM-dd HH:mm:ss
		 */
		SimpleDateFormat sdf 
			= new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"
			);
		
		String str = sdf.format(now);
		System.out.println(str);
	}
}






