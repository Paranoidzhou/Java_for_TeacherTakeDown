package com.tedu.webserver.http;

import java.io.InputStream;
import java.net.Socket;

/**
 * Http请求
 * 该类的每一个实例用于表示客户端发送过来的一个
 * 请求内容.
 * @author adminitartor
 *
 */
public class HttpRequest {
	private Socket socket;
	private InputStream in;
	
	/*
	 * 请求行相关信息定义
	 */
	//请求的方式
	private String method;
	//请求的资源路径
	private String url;
	//请求所使用的协议版本
	private String protocol;
	
	/**
	 * 初始化HttpRequest
	 */
	public HttpRequest(Socket socket){
		try {
			this.socket = socket;
			//通过socket获取输入流读取客户端发送的请求内容
			this.in = socket.getInputStream();
			/*
			 * 开始解析请求内容
			 * 1:解析请求行
			 * 2:解析消息头
			 * 3:解析消息正文
			 */
			//1 解析请求行
			parseRequestLine();
			
			
		} catch (Exception e) {
			
		}
	}
	/**
	 * 解析请求行
	 */
	private void parseRequestLine(){
		/*
		 * 1:通过输入流读取一行字符串,相当于
		 *   读取出了请求行内容
		 * 2:按照空格拆分请求行,可以得到对应的
		 *   三部分内容
		 * 3:分别将methid,url,protocol设置到
		 *   对应的属性上完成请求行的解析工作    
		 */
		String line = readLine();		
		String[] data = line.split("\\s");	
		/*
		 * 这里可能出现下标越界错误,后期优化
		 */
		this.method = data[0];
		this.url = data[1];
		this.protocol = data[2];		
		System.out.println("method:"+method);
		System.out.println("url:"+url);
		System.out.println("protocol:"+protocol);
	}
	
	/**
	 * 读取一行字符串,以CRLF结尾为一行
	 * @return
	 */
	private String readLine(){
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
	/**
	 * 获取请求的方式
	 * @return
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * 获取请求的资源路径
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 获取请求使用的协议版本
	 * @return
	 */
	public String getProtocol() {
		return protocol;
	}
	
	
	
	
}









