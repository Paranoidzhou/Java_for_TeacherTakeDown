package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 程序启动后,要求用户输入自己的生日,
 * 格式如:1992-08-02
 * 
 * 然后通过程序计算,输出到今天为止一共活了多少天.
 * 
 * 再输出,自己出生10000天的纪念日是哪天?(已经活够
 * 的同学....输出20000天的)
 * @author adminitartor
 *
 */
public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入您的生日:");
		String birthStr = scanner.nextLine();
		SimpleDateFormat sdf 
			= new SimpleDateFormat(
				"yyyy-MM-dd"
			);		
		Date birthDate = sdf.parse(birthStr);//生日		
		Date now = new Date();//今天		
		long time = now.getTime()-birthDate.getTime();
		time = time/1000/60/60/24;
		System.out.println("恭喜您!一共活了"+time+"天,请继续保持!");
		//计算出生10000天纪念日
		time = birthDate.getTime()+10000L*1000*60*60*24;
		Date date = new Date(time);		
		String str = sdf.format(date);
		System.out.println("您出生10000天的纪念日是:"+str);
		
	}
}







