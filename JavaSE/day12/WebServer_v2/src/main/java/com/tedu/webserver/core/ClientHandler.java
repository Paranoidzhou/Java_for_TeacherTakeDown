package com.tedu.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 线程任务类,用于处理某个客户端的请求并予以响应
 * @author adminitartor
 *
 */
public class ClientHandler implements Runnable{
	private Socket socket;
	
	public ClientHandler(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		System.out.println("一个客户端连接了!");
		try {
			InputStream in = socket.getInputStream();
			//读取请求行内容
			String line = readLine(in);
			System.out.println(line);
		} catch (Exception e) {
			
		} finally{
			//与客户端断开连接
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 读取一行字符串,以CRLF结尾为一行
	 * @param in
	 * @return
	 */
	private String readLine(InputStream in){
		try {
			/*
			 * 顺序从in中读取每个字符,当连续读取了
			 * CR,LF时停止.并将之前读取的字符以一个
			 * 字符串形式返回即可.
			 */
			StringBuilder builder = new StringBuilder();
			int d = -1;
			//c1表示上次读取到的字符,c2为本次读取的字符
			char c1='a',c2='a';
			while((d = in.read()) != -1){
				c2 = (char)d;
				if(c1==13&&c2==10){
					break;
				}
				builder.append(c2);
				c1 = c2;
			}
			//trim的目的是去除最后的CR符号
			return builder.toString().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}






