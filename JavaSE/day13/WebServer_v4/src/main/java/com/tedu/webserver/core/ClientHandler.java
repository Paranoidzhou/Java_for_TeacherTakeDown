package com.tedu.webserver.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
			
			//2
			//获取请求的路径
			String url = request.getUrl();
			System.out.println("url:"+url);
			
			File file = new File("webapps"+url);
			if(file.exists()){
				System.out.println("找到该文件");
				/*
				 * 3
				 * 将该文件内容回复给客户端
				 * 通过socket获取输出流,给客户端发送一个
				 * 标准的HTTP响应.
				 */
				OutputStream out = socket.getOutputStream();
				//发送状态行内容
				String line = "HTTP/1.1 200 OK";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				//发送响应头
				line = "Content-Type: text/html";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				line = "Content-Length: "+file.length();
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				out.write(13);//written CR
				out.write(10);//written LF
				
				//发送响应正文
				FileInputStream fis 
					= new FileInputStream(file);
				byte[] data = new byte[1024*10];
				int len = -1;
				while((len = fis.read(data))!=-1){
					out.write(data, 0, len);
				}
				fis.close();//finally中完成
				
				
			}else{
				System.out.println("404!!!");
			}
			
			
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






