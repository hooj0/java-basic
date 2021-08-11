package io.github.hooj0.network.socket.m2mChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * 多对多，一对多聊天主功能函数、入口函数
 * @author hoojo
 * @createDate Sep 23, 2010 11:07:54 AM
 * @file ClientHeper.java
 * @package com.hoo.base.socket.m2mChat
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ClientHeper {
	//和服务器端对应的端口
	private static final int SERVER_PORT = 30000;
	private Socket s = null;
	private PrintStream ps = null;
	private BufferedReader br = null;
	//接收用户键盘的输入
	private BufferedReader keyIn = null;
	
	public void init() {
		try {
			keyIn = new BufferedReader(new InputStreamReader(System.in));
			//连接服务器Socket
			s = new Socket("127.0.0.1", SERVER_PORT);
			//获取该Socket的输入流和输出流
			ps = new PrintStream(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			String msg = "";
			//使用循环读取用户输入的信息
			while (true) {
				String userName = JOptionPane.showInputDialog(msg + "输入用户名");
				//将用户输入的用户名，按照协议规则处理后发送出去
				ps.println(BasicProtocol.USER_ROUND + userName + BasicProtocol.USER_ROUND);
				//读取服务器端响应的信息
				String result = br.readLine();
				//用户名重复，继续循环
				if (result.equals(BasicProtocol.NAME_REP)) {
					msg = "用户名重复！重新输入";
					continue;
				}
				//如果是登陆成功，结束循环
				if (result.equals(BasicProtocol.LOGIN_SUCCESS)) {
					break;
				}
			}
			
		} catch (UnknownHostException e) {
			System.out.println("找不到远程服务器，请确定服务器已经启动、服务器地址无错误！");
			this.close();
			System.exit(1);
		} catch (IOException e) {
			System.out.println("网络出现异常，请重新登陆！");
			this.close();
			System.exit(1);
		}
		new ClientThread(br).start();
	}
	
	/**
	 * 读取用户输入数据，发送数据
	 * @author hoojo
	 * @createDate Sep 23, 2010 11:12:31 AM
	 */
	private void readAndSendMsg() {
		try {
			//不断地读取键盘输入的信息
			String keyMsg = null;
			while ((keyMsg = keyIn.readLine()) != null) {
				//如果发送的信息中有冒号，且以//开头，则认为向发送私聊信息
				if (keyMsg.indexOf(":") > 0 && keyMsg.startsWith("//")) {
					keyMsg = keyMsg.substring(2);
					String[] arr = keyMsg.split(":");
					ps.println(BasicProtocol.PRIVATE_ROUND + arr[0] + BasicProtocol.SPLIT_SIGN + arr[1] + BasicProtocol.PRIVATE_ROUND);
				} else {
					ps.println(BasicProtocol.MSG_ROUND + keyMsg + BasicProtocol.MSG_ROUND);
				}
			}
		} catch (Exception e) {
			System.out.println("网络出现异常，请重新登陆！");
			this.close();
			System.exit(1);
		}
	}
	
	/**
	 * 关闭链接
	 * @author hoojo
	 * @createDate Sep 23, 2010 11:13:11 AM
	 */
	private void close() {
		try {
			if (keyIn != null) {
				keyIn.close();
			}
			if (br != null) {
				br.close();
			}
			if (ps != null) {
				ps.flush();
				ps.close();
			}
			if (s != null && !s.isClosed()) {
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ClientHeper ch = new ClientHeper();
		ch.init();
		ch.readAndSendMsg();
	}
}
