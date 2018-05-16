package com.tedu.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 响应对象
 * 每一个实例用于表示一个实际发送给客户端的响应
 * 内容
 * @author adminitartor
 *
 */
public class HttpResponse {
	
	
	
	/*
	 * 响应正文对应的实体文件
	 * 当设置了该文件,那么将来该文件的数据
	 * 就会作为当前响应的响应正文内容被发送
	 * 给客户端.
	 */
	private File entity;

	private Socket socket;
	
	//该输出流通过socket获得,用于给客户端回复内容
	private OutputStream out;
	
	public HttpResponse(Socket socket){
		try {
			this.socket = socket;
			this.out = socket.getOutputStream();
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * 将当前响应内容以HTTP响应的格式回复给客户端
	 */
	public void flush(){
		/*
		 * 回复客户端需要按照HTTP的响应格式来发送
		 * 1:发送状态行
		 * 2:发送响应头
		 * 3:发送响应正文
		 */
		sendStatusLine();
		sendHeader();
		sendContent();
	}
	/**
	 * 发送状态行
	 */
	private void sendStatusLine(){
		try {
			//发送状态行内容
			String line = "HTTP/1.1 200 OK";
			println(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 发送响应头
	 */
	private void sendHeader(){
		try {
			//发送响应头
			String ext = this.entity.getName().split("\\.")[1];
			String line = "Content-Type: "+HttpContext.getMimeType(ext);
			println(line);
			
			line = "Content-Length: "+entity.length();
			println(line);
			
			//单独发送CRLF
			println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 发送响应正文
	 */
	private void sendContent(){
		try(
			FileInputStream fis 
				= new FileInputStream(entity);	
		){			
			byte[] data = new byte[1024*10];
			int len = -1;
			while((len = fis.read(data))!=-1){
				out.write(data, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 向客户端发送一行字符串(自动以CRLF结尾)
	 * @param line
	 */
	private void println(String line){
		try {
			out.write(line.getBytes("ISO8859-1"));
			out.write(13);//written CR
			out.write(10);//written LF
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public File getEntity() {
		return entity;
	}

	public void setEntity(File entity) {
		this.entity = entity;
	}
	
	
}






