package io.github.hooj0.network.socket.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *  Socket通讯聊天服务器端人口函数 
 * @author hoojo
 * @createDate Sep 23, 2010 10:54:21 AM
 * @file ChartServer.java
 * @package com.hoo.base.socket.chat
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ChatServer {

	//定义一个ArrayList保存客户端请求的Socket
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
	
	/**
	 * 
	 * @author hoojo
	 * @createDate Sep 22, 2010 12:53:08 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(30000);
		while (true) {
			//等待客户端的连接，会一直阻塞
			Socket s = ss.accept();
			socketList.add(s);
			//实现Runnable接口，启动线程的方法
			//new Thread(new ServerThread(s)).start();
			//继承Thread类，启动线程的方法
			new ServerThread(s).start(); 
		}
	}
}
