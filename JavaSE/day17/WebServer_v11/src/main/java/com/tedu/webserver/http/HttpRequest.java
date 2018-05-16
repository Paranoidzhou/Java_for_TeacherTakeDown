package com.tedu.webserver.http;

import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

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
	//请求路径中的请求部分(url中"?"左面的内容)
	private String requestURI;
	//请求路径中的参数部分(url中"?"右面的内容)
	private String queryString;
	
	//请求所使用的协议版本
	private String protocol;
	
	/*
	 * 消息头相关信息定义
	 */
	private Map<String,String> headers = new HashMap<String,String>();
	
	
	/*
	 * 客户端传递过来的参数内容
	 * key:参数名
	 * value:参数值
	 */
	private Map<String,String> parameters = new HashMap<String,String>();
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
			//2 解析消息头
			parseHeaders();
			
		} catch (Exception e) {
			
		}
	}
	/**
	 * 解析消息头
	 */
	private void parseHeaders(){
		System.out.println("开始解析消息头");
		/*
		 * 循环读取每一行(若干消息头),当读取的这行
		 * 字符串是空字符串时,说明单独读取了CRLF,
		 * 那么就可以停止读取消息头操作.
		 * 
		 * 每读取一个消息头时,将消息头的名字作为key
		 * 消息头的值作为value,存入到headers这个map
		 * 中.最终完成解析消息头工作
		 */
		String line = null;
		while(true){
			line = readLine();
			if("".equals(line)){
				break;
			}
			String[] arr = line.split(":\\s");
			headers.put(arr[0], arr[1]);
		}	
		System.out.println("headers:"+headers);
		System.out.println("解析消息头完毕");
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
		
		//进一步解析url
		parseURL();
//		System.out.println("method:"+method);
//		System.out.println("url:"+url);
//		System.out.println("protocol:"+protocol);
	}
	/**
	 * 进一步解析请求行中的url部分
	 * url可能的两种样子如:
	 * /myweb/reg.html
	 * /myweb/reg?username=123&password=123...
	 */
	private void parseURL(){
		try{
			/*
			 * 由于请求有两种情况,带参数或不带参数,那么
			 * 要先判断url是否带参数,不带则直接将url的
			 * 值赋值给属性requestURI即可.
			 * 若带参数,则需要按照?先拆分url,然后将?左面
			 * 内容设置到requestURI中,将?右面的内容设置
			 * 到queryString中.并进一步对参数部分解析,
			 * 将每个参数解析出来,将参数名作为key,参数值
			 * 作为value存入到parameters这个Map类型的属
			 * 性中.
			 */
			System.out.println("进一步解析URL");
			//判断url中是否含有?
			if(this.url.contains("?")){
				String[] data = this.url.split("\\?");
				this.requestURI = data[0];
				//确保url中"?"右侧有内容
				if(data.length>1){
					this.queryString = data[1];
					//按照&拆分queryString
					data = this.queryString.split("&");
					//将每个参数按照"="拆分并存入parameters
					for(String parameter : data){
						String[] paraArr = parameter.split("=");
						if(paraArr.length>1){
							parameters.put(paraArr[0], paraArr[1]);
						}else{
							parameters.put(paraArr[0], "");
						}
					}
				}else{
					this.queryString = "";
				}	
			}else{
				this.requestURI = this.url;
			}
			
			System.out.println("requestURI:"+requestURI);
			System.out.println("queryString:"+queryString);
			System.out.println("parameter:"+parameters);
			System.out.println("进一步解析URL完毕!");
		}catch(Exception e){
			e.printStackTrace();
		}
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
	public String getRequestURI() {
		return requestURI;
	}
	public String getQueryString() {
		return queryString;
	}
	/**
	 * 获取给定名字对应的参数
	 * @param name
	 * @return
	 */
	public String getParameter(String name){
		return this.parameters.get(name);
	}
	
	
	
}









