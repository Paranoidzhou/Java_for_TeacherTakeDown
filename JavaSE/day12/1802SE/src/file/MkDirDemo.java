package file;

import java.io.File;

/**
 * 使用File创建一个目录
 * @author adminitartor
 *
 */
public class MkDirDemo {
	public static void main(String[] args) {
		/*
		 * 在当前目录中新建一个目录demo
		 */
		File dir = new File("./demo");
		if(!dir.exists()){
			dir.mkdir();
			System.out.println("目录已创建!");
		}else{
			System.out.println("目录已存在!");
		}
	}
}







