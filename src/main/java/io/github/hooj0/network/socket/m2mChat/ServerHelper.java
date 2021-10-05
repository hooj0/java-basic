package io.github.hooj0.network.socket.m2mChat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <b>function:</b> 一对一，多对多聊天服务器端核心函数、入口函数
 * @author hoojo
 * @createDate Sep 23, 2010 11:13:36 AM
 * @file ServerHelper.java
 * @package com.hoo.base.socket.m2mChat
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ServerHelper {
	//服务器端口
	private static final int SERVER_PORT = 30000;
	//保存客户端的详细信息，客户名称和流之间对应的关系
	public static BasicMap<String, PrintStream> clientMap = new BasicMap<String, PrintStream>();
	
	//初始，启动服务器
	public void init() {
		ServerSocket ss = null;
		try {
			//建立监听的ServerSocket
			ss = new ServerSocket(SERVER_PORT);
			while (true) {
				Socket s = ss.accept();
				new Thread(new ServerThread(s)).start();
				System.out.println("服务器启动, 增加一个链接！ ");
			}			
		} catch (Exception e) {
			System.out.println("服务器启动失败，是否端口" + SERVER_PORT + "已经被占用？");
		} finally {
			try {
				if (ss != null && !ss.isClosed()) {
					ss.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	
	/**
	 * <b>function:</b> 测试服务器
	 * @author hoojo
	 * @createDate Sep 22, 2010 2:46:54 PM
	 * @param args
	 */
	public static void main(String[] args) {
		ServerHelper sh = new ServerHelper();
		sh.init();
	}
}
