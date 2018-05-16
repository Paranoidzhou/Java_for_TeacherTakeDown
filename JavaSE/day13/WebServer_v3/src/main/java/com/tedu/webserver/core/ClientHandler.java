package com.tedu.webserver.core;

import java.io.IOException;
import java.net.Socket;

import com.tedu.webserver.http.HttpRequest;

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
			/*
			 * 处理客户端请求的流程
			 * 1:解析请求
			 * 2:处理请求
			 * 3:给予响应 
			 */
			//1
			HttpRequest request = new HttpRequest(socket);
			
			
			
			
			
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

	
	
}






