package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 查询用户功能
 * 
 * 程序启动后,要求输入要查询的用户名
 * 然后将该用户信息输出,格式:user,pwd,nick,age
 * 
 * 若输入的用户在user.dat文件中不存在,则提示:
 * 查无此人
 * 
 * 
 * @author adminitartor
 *
 */
public class Test3 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String username = null;
		while(true){
			System.out.println("请输入用户名:");
			username = scanner.nextLine().trim();
			if(username.length()>0){
				break;			
			}
			System.out.println("用户名不能为空!");
		}
		
		RandomAccessFile raf
			= new RandomAccessFile("user.dat","r");
	
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
				//读密码
				raf.read(data);
				String pwd = new String(data,"UTF-8").trim();
				raf.read(data);
				String nick = new String(data,"UTF-8").trim();
				int age = raf.readInt();
				System.out.println(name+","+pwd+","+nick+","+age);
				have = true;
				break;
			}
		}//loop end
		if(!have){
			System.out.println("查无此人!");
		}
		
		raf.close();
	}
}









