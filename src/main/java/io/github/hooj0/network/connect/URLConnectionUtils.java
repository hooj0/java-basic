package io.github.hooj0.network.conn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/***
 *  URLConnection 发送get、post请求
 * @author hoojo
 * @createDate Sep 18, 2010 11:14:13 PM
 * @file URLConnSend.java
 * @package com.hoo.base.conn
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class URLConnectionUtils {
	/***
	 * <b>function:<br/></b>
	 * 向指定的url发送get请求
	 * @createDate 2010-9-17
	 * @author hoojo
	 * @param url 发送请求的url地址
	 * @param param 请求的参数key=value&key2=val2
	 * @return 请求资源的响应
	 */
	public static String sendGet(String url, String params) {
		String result = "";
		BufferedReader bReader = null;
		try {
			String urlStr = url + "?" + params;
			URL requestURL = new URL(urlStr);
			//打开url连接
			URLConnection conn = requestURL.openConnection();
			
			//设置请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mazilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			//建立链接
			conn.connect();
			
			//获取响应的头字段信息
			/*Map<String, List<String>> map = conn.getHeaderFields();
			//遍历字段信息
			for (String key : map.keySet()) {
				System.out.println("key:" + key + "==>>" + map.get(key));
			}*/
			
			//定义bufferedReader流读取url资源信息
			bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = "";
			//读取一行内容，直到读取null退出循环
			while((line = bReader.readLine()) != null) {
				result += "\n" + line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bReader != null) {
					bReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 向指定url资源发送post请求
	 * @author hoojo
	 * @createDate Sep 18, 2010 11:11:21 PM
	 * @param url 发送请求的url地址
	 * @param param 请求的参数key=value&key2=val2
	 * @return 请求服务器响应消息
	 */
	public static String sendPost(String url, String params) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL requestURL = new URL(url);
			
			//和当前url进行链接
			URLConnection conn = requestURL.openConnection();
			//设置请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mazilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			//post请求核心属性
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			//获取响应的头字段信息
			/*Map<String, List<String>> map = conn.getHeaderFields();
			//遍历字段信息
			for (String key : map.keySet()) {
				System.out.println("key:" + key + "==>>" + map.get(key));
			}*/
			
			//获得conn对象的输入流
			out = new PrintWriter(conn.getOutputStream());
			//发送请求参数
			out.print(params);
			
			//flush 输出流缓冲
			out.flush();
			
			//定义BufferedReader输入流读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			while ((line = in.readLine()) != null) {
				result += "\n" + line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		//String result = URLConnSend.sendGet("http://localhost:8080/JavaNetBase/HelloServlet", "name=java&say=hello world");
		//System.out.println(result);
		String result = URLConnectionUtils.sendPost("http://localhost:8080/JavaNetBase/HelloServlet", "name=hoo&say=hello world");
		System.out.println("result:"+ result);
	}
}
