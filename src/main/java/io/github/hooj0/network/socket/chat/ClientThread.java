package io.github.hooj0.network.socket.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *  Socket通讯客户端多线程代码
 * @author hoojo
 * @createDate Sep 23, 2010 10:54:59 AM
 * @file ClientThread.java
 * @package com.hoo.base.socket.chat
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ClientThread implements Runnable {
	//Socket连接线程
	//private Socket s = null;
	//处理Socket的输入流
	private BufferedReader br = null;
	
	public ClientThread(Socket s) throws IOException {
		//this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	public void run() {
		try {
			String content = "";
			while ((content = br.readLine()) != null) {
				System.out.println(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
