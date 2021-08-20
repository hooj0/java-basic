package io.github.hooj0.network.proxy;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *  网络代理链接
 * @author hoojo
 * @createDate Sep 24, 2010 3:04:05 PM
 * @file ProxyTest.java
 * @package com.hoo.base.proxy
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ProxyTest {
	private Proxy proxy;
	private URL url;
	private URLConnection conn;
	//通过代理读取网络数据
	private Scanner scan;
	private PrintStream ps;
	//设置ip和端口
	private String address = "127.0.0.1";
	private int port = 30000;
	
	//要请求的网址
	String uri = "http://localhost:8080/JavaNetBase/index.jsp";
	
	public void init() {
		try {
			url = new URL(uri);
			//创建代理服务器
			proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(address, port));
			//使用代理打开连接
			conn = url.openConnection(proxy);
			//设置超时长
			conn.setConnectTimeout(5000);
			scan = new Scanner(conn.getInputStream());
			//初始化输出流
			ps = new PrintStream("index.jsp");
			while (scan.hasNext()) {
				String line = scan.nextLine();
				System.out.println(line);
				ps.println(line);
			}
		} catch (Exception e) {
			System.out.println(uri + "无法访问！");
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}
	
	/**
	 * 
	 * @author hoojo
	 * @createDate Sep 24, 2010 3:04:01 PM
	 * @param args
	 */
	public static void main(String[] args) {
		new ProxyTest().init();
	}

}
