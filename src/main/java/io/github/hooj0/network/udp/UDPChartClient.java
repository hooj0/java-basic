package io.github.hooj0.network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP通讯客户端
 * @author hoojo
 * @createDate Sep 23, 2010 4:35:45 PM
 * @file UDPChartClient.java
 * @package com.hoo.base.udp
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class UDPChartClient {
	
	//定义发送数据报的目标
	private final static int DEST_PORT = 29999;
	private static final String DEST_IP = "127.0.0.1";
	
	//定义每个数据报的最大大小为4k
	private static final int DATA_LENGTH = 1024 * 4;
	
	//定义客户端使用的DatagramSocket
	private DatagramSocket dgp = null;
	
	//定义接收网络数据的数组
	private byte[] inBf = new byte[DATA_LENGTH];
	
	//定义一个接收网络数据 数据报的DatagramPacket
	private DatagramPacket inPacket = new DatagramPacket(inBf, 0, inBf.length);
	
	//定义一个用于发送数据报的DatagramPacket
	private DatagramPacket outPacket = null;
	
	public void init() throws Exception {
		try {
			//创建客户端DatagramSocket，使用随机端口
			dgp = new DatagramSocket();
			
			 //初始化发送用的DatagramSocket，它包含一个长度为0的字节数组
			outPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(DEST_IP), DEST_PORT);
			
			//键盘输入流
			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) {
				//将键盘输入的一行数据转换成字节数组
				byte[] bf = sc.nextLine().getBytes();
				
				//设置发送用的DatagramPacket里面的字节
				outPacket.setData(bf);
				
				//定义数据报
				dgp.send(outPacket);
				//读取Socket中的数据，将读到的数据放到inPacket的封装数组中保存
				dgp.receive(inPacket);
				System.out.println(new String(inBf, 0, inPacket.getLength()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dgp != null && !dgp.isClosed()) {
				dgp.close();
			}
		}
	}
	
	/**
	 * @author hoojo
	 * @createDate Sep 23, 2010 3:46:11 PM
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new UDPChartClient().init();
	}
}
