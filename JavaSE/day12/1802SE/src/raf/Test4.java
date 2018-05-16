package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 修改密码功能
 * 
 * 程序启动后,要求用户输入用户名及密码,然后将
 * user.dat文件中该用户的密码更改.
 * 若没有该用户,则提示:用户名无效
 * @author adminitartor
 *
 */
public class Test4 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username = scanner.nextLine().trim();
		System.out.println("请输入密码:");
		String password = scanner.nextLine().trim();
		
		RandomAccessFile raf
			= new RandomAccessFile("user.dat","rw");
	
		boolean have = false;//查到用户
		for(int i=0;i<raf.length()/100;i++){
			//移动指针到该记录的用户名位置
			raf.seek(i*100);
			//读用户名
			byte[] data = new byte[32];
			raf.read(data);
			String name = new String(data,"UTF-8").trim();
			if(name.equals(username)){
				//找到了
				//改密码
				data = password.getBytes("UTF-8");
				data = Arrays.copyOf(data, 32);
				raf.write(data);
				have = true;
				System.out.println("修改成功!");
				break;
			}
		}//loop end
		if(!have){
			System.out.println("查无此人!");
		}
	}
}
