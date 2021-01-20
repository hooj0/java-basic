package io.github.hooj0.network.socket.m2mChat;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * <b>function:</b> 一对一、多对多聊天多线程
 * @author hoojo
 * @createDate Sep 23, 2010 11:11:34 AM
 * @file ClientThread.java
 * @package com.hoo.base.socket.m2mChat
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ClientThread extends Thread {
	
	//客户端线程复制处理的输入流
	private BufferedReader br = null;
	
	public ClientThread(BufferedReader br) {
		this.br = br;
	}
	
	public void run() {
		try {
			String content = null;
			while ((content = br.readLine()) != null) {
				System.out.println(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
