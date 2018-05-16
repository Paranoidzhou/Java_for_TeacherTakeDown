package com.tedu.webserver.core;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

import com.tedu.webserver.http.HttpRequest;
import com.tedu.webserver.http.HttpResponse;

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
			HttpResponse response = new HttpResponse(socket);	
			
			//2
			//获取请求的路径
			String url = request.getUrl();
			System.out.println("url:"+url);
			
			File file = new File("webapps"+url);
			if(file.exists()){
				System.out.println("找到该文件");
				//将客户端请求的文件设置到response中
				response.setEntity(file);				
			}else{
				//响应404错误
				//1设置响应的状态代码为404
				response.setStatusCode(404);
				//2设置错误页面
				File notFoundPage = new File("webapps/sys/404.html");
				response.setEntity(notFoundPage);
			}
			//响应客户端
			response.flush();
			
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






