package io.github.hooj0.network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *  用UDP数据报协议通讯
 * @author hoojo
 * @createDate Sep 23, 2010 3:17:12 PM
 * @file UDPChartServer.java
 * @package com.hoo.base.udp
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class UDPChartServer {
	
	private static final int PORT = 29999;
	//定义数据报的对大空间4k
	private static final int DATA_LENGTH = 1024 * 4;
	//定义服务器使用的DatagramSocket
	private DatagramSocket dgs = null;
	//定义接收网络数据的字节数组
	byte[] bt = new byte[DATA_LENGTH];

	//以指定字节数组创建准备接收数据的DatagramPacket对象
	private DatagramPacket inDgp = new DatagramPacket(bt, bt.length);
	//定义一个DatagramPacket发送数据
	private DatagramPacket outDgp = null;
	
	//定义即将发送的数据数组
	String[] datas = {"这是一个UDP协议传输的数据", "基于Java的DatagramSocket的", "Hello world 示例", "使用DatagramPacket发送接收数据"};
	
	public void init() {
		try {
			//创建DatagramSocket对象
			dgs = new DatagramSocket(PORT) ;
			//采用循环接收数据
			for (int i = 0; i < 1000; i++) {
				//读取Socket中的数据，读到的数据放到DatagramPacket对象中的封装数组中
				dgs.receive(inDgp);
				
				//判断DatagramPacket的getData方法和bt是否是同一个数组
				System.out.println(bt == inDgp.getData());
				//将接收到的数据转换成字符串输出
				System.out.println(new String(bt, 0, inDgp.getLength()));
				//从字符串数组中提取一个数据，作为发送数据
				byte[] sendData = new String(bt, 0, inDgp.getLength()).getBytes();//datas[i % 4].getBytes();
				//以指定的字节数组作为发送数据、即刚接受到的DatagramPacket的源SocketAddress作为目标创建DatagramPacket
				outDgp = new DatagramPacket(sendData, sendData.length, inDgp.getSocketAddress());
				//发送数据
				dgs.send(outDgp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dgs != null && !dgs.isClosed()) {
				dgs.close();
			}
		}
	}
	
	
	/**
	 *
	 * @author hoojo
	 * @createDate Sep 23, 2010 3:17:07 PM
	 * @param args
	 */
	public static void main(String[] args) {
		new UDPChartServer().init();
	}
}
