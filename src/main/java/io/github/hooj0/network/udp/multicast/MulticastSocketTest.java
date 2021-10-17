package io.github.hooj0.network.udp.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 多点广播
 * @author hoojo
 * @createDate Sep 23, 2010 4:38:19 PM
 * @file MulticaseSocketTest.java
 * @package com.hoo.base.udp.multicast
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class MulticastSocketTest implements Runnable {
	
	//本地多点广播地址
	private static final String BROADCASE_IP = "230.0.0.1";
	
	//端口
	private static final int BROADCASE_PORT = 29999; 
	
	//每个数据报的最大大小为4k
	private static final int DATA_LENGTH = 1024 * 4;
	
	//程序的MulticastSocket实例
	private MulticastSocket socket = null;
	
	private InetAddress broadcaseAddress = null;
	
	//private Scanner scan = null;
	
	//接收网络数据字节数组
	private byte[] inBuff = new byte[DATA_LENGTH];
	
	//将数字放到接收网络数据 数据报的对象中
	private DatagramPacket inPacket = new DatagramPacket(inBuff, 0, inBuff.length);
	
	//用于发送数据的对象
	private DatagramPacket outPacket = null;
	
	ChatFrame frame = null;
	public void init() throws Exception {
		//创建用于接收数据的、发送数据的MulticastSocket对象
		//因为当前MulticastSocket对象需要接收数据，故要指定端口
		socket = new MulticastSocket(BROADCASE_PORT);
		broadcaseAddress = InetAddress.getByName(BROADCASE_IP);
		
		//将当前socket加入到多点广播地址
		socket.joinGroup(broadcaseAddress);
		//设置multicastSocket发送的数据报被回送到自身
		socket.setLoopbackMode(false);
		//初始化发送用的DatagramPacket，它的长度为0字节的数组
		outPacket = new DatagramPacket(new byte[0], 0, broadcaseAddress, BROADCASE_PORT);
		
		//启动线程
		new Thread(this).start();
		frame = new ChatFrame(outPacket, socket);
		/*scan = new Scanner(System.in);
		
		while (scan.hasNext()) {
			byte[] readBf = scan.nextLine().getBytes();
			//设置发送数据数组
			outPacket.setData(readBf);
			//发送数据
			socket.send(outPacket);
		}*/
	}
	
	public void run() {
		try {
			while (true) {
				//读取Socket中的数据，读到的数据放到inPacket对象中封装成数组
				socket.receive(inPacket);
				
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String time = sdf.format(new Date());
				//打印输出从Socket中读取的数据
				//System.out.println("Message " + time + "  sya ：" + new String(inBuff, 0, inPacket.getLength()));
				frame.addString("Message " + time + "  sya ：\n" + new String(inBuff, 0, inPacket.getLength()) + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (socket != null && !socket.isClosed()) {
					//让当前Socket退出多点广播
					socket.leaveGroup(broadcaseAddress);
					
					socket.close();
				}
				System.exit(1);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	/**
	 *
	 * @author hoojo
	 * @createDate Sep 23, 2010 4:37:57 PM
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new MulticastSocketTest().init();
	}
}
