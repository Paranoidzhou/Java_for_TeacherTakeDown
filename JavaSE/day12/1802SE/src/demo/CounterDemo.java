package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CounterDemo {
	public static void main(String[] args) 
		throws IOException{
		File dir=new File("D:/tts9/workspace");
		countLines(dir);
		System.out.println(lines);
	}
	/**
	 * 统计一个文件夹中全部Java文件的行数
	 * @param dir
	 */
	public static int lines=0;
	public static void countLines(File dir)
		throws IOException{
		//想清楚当前的第一层
		//1 列文件夹的目录内容
		//2 遍历全部内容
		//3 如果是一个文件,并且以Java为结尾,
		//  统计文件中行数
		//4 如果是一个文件夹, 则统计这个文件夹
		// 中的全部Java文件 countLines()
		File[] files = dir.listFiles();
		System.out.println("dir:"+dir);
		for(int i=0; i<files.length; i++){
			File file=files[i];
			if(file.isFile()){
				if(file.getName().endsWith(".java")){
					lines += count(file);
					System.out.println(
						"Count File:"+
					    file.getCanonicalPath());//完整路径名
				}
			}else{
				if(! file.getName().startsWith(".")){
					//统计子文件夹中的java文件行数
					countLines(file);
				}
			}
		}
					
	}
	private static int count(File file) 
		throws IOException{
		BufferedReader in=
				new BufferedReader(
				new InputStreamReader(
				new FileInputStream(file)));
		String str;
		int n=0;
		while((str=in.readLine())!=null){
			if(! str.trim().isEmpty()){
				n++;
			}
		}
		in.close();
		return n;
	}
}






