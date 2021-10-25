package io.github.hooj0.network.socket.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * <b>function:</b> Socket通讯客户端人口函数
 * @author hoojo
 * @createDate Sep 23, 2010 10:53:20 AM
 * @file ChatClient.java
 * @package com.hoo.base.socket.chat
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ChatClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 30000);
		//客户端启动线程读取服务器端的数据
		new Thread(new ClientThread(s)).start();
		//获取当前Socket中的输出流
		PrintStream ps = new PrintStream(s.getOutputStream());
		/*DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		dos.writeUTF("yourString");
		PrintWriter out = new PrintWriter(s.getOutputStream());
		out.print("aa");*/
		
		String content = "";
		//不断读取键盘输入的信息
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while ((content = br.readLine()) != null) {
			ps.println(content);
		}
	}
}
