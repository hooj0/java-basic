package io.github.hooj0.network.socket.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Socket通讯聊天服务器端代码
 * @author hoojo
 * @createDate Sep 23, 2010 10:55:55 AM
 * @file ServerThread.java
 * @package com.hoo.base.socket.chat
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ServerThread extends Thread {
	//定义一个Socket
	private Socket s = null;
	//当前线程所处理的Socket的输入流
	
	BufferedReader br = null;
	public ServerThread(Socket s) throws IOException {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	public void run() {
		try {
			String content = "";
			//采用循环提取Socket中的客户端发送的数据
			while ((content = read4ClientMsg()) != null) {
				//遍历服务器端的socketList, 向每个客户端发送一次消息
				for (Socket s : ChatServer.socketList) {
					PrintStream ps = new PrintStream(s.getOutputStream());
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
					ps.println(s.getInetAddress() + "##" + sdf.format(new Date()) + "  说: ");
					ps.println(content);
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	//读取客户端的消息
	private String read4ClientMsg() {
		String content = "";
		try {
			content = br.readLine();
		} catch (IOException e) {
			//如果出现异常表示客户端的Socket已经关闭和错误
			//e.printStackTrace();
			//出现异常时，删除当前Socket
			ChatServer.socketList.remove(s);
		}
		return content;
	}
}
