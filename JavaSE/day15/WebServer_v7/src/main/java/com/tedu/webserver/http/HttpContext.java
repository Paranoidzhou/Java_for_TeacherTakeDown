package com.tedu.webserver.http;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP协议相关内容定义
 * @author adminitartor
 *
 */
public class HttpContext {
	/**
	 * 介质类型映射
	 * key:资源后缀名
	 * value:Content-Type中对应的值
	 */
	private static Map<String,String> MIME_MAPPING = new HashMap<String,String>();

	static{
		//初始化
		initMimeMapping();
	}
	/**
	 * 初始化介质类型映射
	 * 
	 */
	private static void initMimeMapping(){
		MIME_MAPPING.put("html", "text/html");
		MIME_MAPPING.put("png", "image/png");
		MIME_MAPPING.put("gif", "image/gif");
		MIME_MAPPING.put("jpg", "image/jpeg");
		MIME_MAPPING.put("css", "text/css");
		MIME_MAPPING.put("js", "application/javascript");
	}
	/**
	 * 根据给定的资源后缀名获取对应的Content-Type值
	 * @param name
	 * @return
	 */
	public static String getMimeType(String name){
		return MIME_MAPPING.get(name);
	}
	
	public static void main(String[] args) {
		String type = HttpContext.getMimeType("jpg");
		System.out.println(type);
	}
	
}







