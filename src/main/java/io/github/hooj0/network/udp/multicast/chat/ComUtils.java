package io.github.hooj0.network.udp.multicast.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/***
 * 聊天交互信息工具类
 * @author hoojo
 * @createDate Sep 23, 2010 6:00:32 PM
 * @file ComUtils.java
 * @package com.hoo.base.udp.multicase.chart
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ComUtils {
	//多点广播ip address
	private static final String BROADCASE_IP = "230.0.0.1";;
	//多点广播端口;DatagramSocket所用的端口为该端口-1
	private static final int BROADCASE_PORT = 29999;
	//每个数据报的最大空间
	private static final int DATA_LENGTH = 1024 * 4;
	//多点广播示例
	private MulticastSocket socket = null;
	//私聊Socket示例
	private  DatagramSocket singleSocket = null;
	
	//多点广播地址
	private InetAddress broadcaseAddress = null;
	
	//定义接收网络数据的字节数组
	private byte[] inBuff = new byte[DATA_LENGTH];
	//将字节数组设置到DatagramPacket对象中
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	//发送数据报的对象
	private DatagramPacket outPacket = null;
	
	//聊天主界面
	private LanChatFrame lan;

	public ComUtils(LanChatFrame lanFrame) throws IOException, InterruptedException {
		this.lan = lanFrame;
		//创建用于接收、发送数据的MulticastSocket对象
		//接收数据需要指定端口
		socket = new MulticastSocket(BROADCASE_PORT);
		//创建私聊用的DatagramSocket
		singleSocket = new DatagramSocket(BROADCASE_PORT + 1);
		broadcaseAddress = InetAddress.getByName(BROADCASE_IP);
		//将该Socket加入指定广播地址中
		socket.joinGroup(broadcaseAddress);
		//设置多播数据报的本地回送
		socket.setLoopbackMode(false);
		//初始化DatagramSocket是，发送一个0字节的数组
		outPacket = new DatagramPacket(new byte[0], 0, broadcaseAddress, BROADCASE_PORT);
		//启动2个读取网络数据的线程
		new ReadBoradThread().start();
		Thread.sleep(10);
		new ReadSingleThread().start();
	}
	
	/**
	 * 广播本消息的方法
	 * @author hoojo
	 * @createDate Sep 23, 2010 6:30:16 PM
	 * @param msg 即将发送的消息
	 */
	public void broadCastMsg(String msg) {
		try {
			//将msg字符串转换成字节数组
			byte[] buff = msg.getBytes();
			//设置发送用的DatagramPacket的字节数据
			outPacket.setData(buff);
			//发送数据报
			socket.send(outPacket);
		} catch (Exception e) {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
			JOptionPane.showMessageDialog(null, "发送信息出现异常，请确认" + BROADCASE_PORT + "端口空闲，且网络连接正常！", "网络正常", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	/**
	 * 	单独发送信息的Message
	 * @author hoojo
	 * @createDate Sep 23, 2010 6:39:35 PM
	 * @param msg
	 * @param dest
	 */
	public void singleSendMsg(String msg, SocketAddress dest) {
		try {
			//将msg转换成字节数组
			byte[] buff = msg.getBytes();
			DatagramPacket packet = new DatagramPacket(buff, buff.length, dest);
			//发送消息
			singleSocket.send(packet);
		} catch (Exception e) {
			if (singleSocket != null && !singleSocket.isClosed()) {
				socket.close();
			}
			JOptionPane.showMessageDialog(null, "发送信息出现异常，请确认" + (BROADCASE_PORT + 1) + "端口空闲，且网络连接正常！", "网络正常", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	class ReadSingleThread extends Thread {
		//接收网络数据的字节数组
		private byte[] singleBuff = new byte[DATA_LENGTH];
		private DatagramPacket singlePacket = new DatagramPacket(singleBuff, singleBuff.length);
		
		public void run() {
			while (true) {
				try {
					//读取Socket中的数据，读到的数据放到singlePacket的封装数组中
					singleSocket.receive(singlePacket);
					//处理读到的信息
					lan.proccessMsg(singlePacket, true);
				} catch (IOException e) {
					if (singleSocket != null && !singleSocket.isClosed()) {
						socket.close();
					}
					JOptionPane.showMessageDialog(null, "发送信息出现异常，请确认" + (BROADCASE_PORT + 1) + "端口空闲，且网络连接正常！", "网络正常", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
				
			}
		}
	}
	
	class ReadBoradThread extends Thread {
		public void run() {
			while (true) {
				try {
					//读取Socket中的数据，并放到inPacket的数组中进行封装
					socket.receive(inPacket);
					//输出读到的内容
					String msg = new String(inBuff, 0, inPacket.getLength());
					//读到的内容是在线信息
					if (msg.startsWith(ConstomProtocol.PRESENCE) && msg.endsWith(ConstomProtocol.PRESENCE)) {
						String userMsg = msg.substring(ConstomProtocol.PROTOCOL_LENGHT, msg.length() - ConstomProtocol.PROTOCOL_LENGHT);
						String[] userInfo = userMsg.split(ConstomProtocol.SPLITTER);
						UserInfo user = new UserInfo(userInfo[1], userInfo[0], inPacket.getSocketAddress(), 0);
						//是否需要添加用户图标
						boolean addFlag = true;
						ArrayList<Integer> delList = new ArrayList<Integer>();
						for (int i = 0; i < lan.getUserNum(); i++) {
							 UserInfo current = lan.getUser(i);
							 //将所有用户失去联系次数加1
							 current.setLost(current.getLost() + 1);
							 //如果该信息由指定用户发送过来的
							 if (current.equals(user)) {
								 current.setLost(0);
								 //设置该用户无须添加
								 addFlag = false;
							 }
							 if (current.getLost() > 2) {
								 delList.add(i);
							 }
						}
						//删除索引中对应的用户
						for (int i = 0; i < delList.size(); i++) {
							lan.removeUser(delList.get(i));
						}
						if (addFlag) {
							//添加新用户
							lan.addUser(user);
						}
					} else {//公聊内容
						lan.proccessMsg(inPacket, false);
					}
				} catch (Exception e) {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
					JOptionPane.showMessageDialog(null, "发送信息出现异常，请确认" + BROADCASE_PORT + "端口空闲，且网络连接正常！", "网络正常", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
		}
	}
}
