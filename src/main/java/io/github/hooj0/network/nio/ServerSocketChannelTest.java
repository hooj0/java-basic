package io.github.hooj0.network.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/***
 *  nio中常有方法测试
 * @author hoojo
 * @createDate Sep 23, 2010 10:47:34 AM
 * @file ServerSocketChannelTest.java
 * @package com.hoo.base.nio
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ServerSocketChannelTest {
	public static void main(String[] args) throws IOException {
		//通过open方法打开一个未绑定ip地址的ServerSocketChannel对象
		ServerSocketChannel server = ServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 30000);
		//将当前server绑定到指定的ip地址上
		server.socket().bind(address);
		
		//设置ServerSocketChannel以非阻塞的方式工作
		server.configureBlocking(false);
		//将ServerSocketChannel注册到指定的Selector上
		Selector s = Selector.open();
		/*
	 	static int OP_ACCEPT 
          		用于套接字接受操作的操作集位。 
		static int OP_CONNECT 
		          用于套接字连接操作的操作集位。 
		static int OP_READ 
		          用于读取操作的操作集位。 
		static int OP_WRITE 
          		用于写入操作的操作集位 
		 */
		server.register(s, SelectionKey.OP_ACCEPT);
	}
}
