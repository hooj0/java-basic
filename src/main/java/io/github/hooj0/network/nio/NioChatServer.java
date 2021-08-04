package io.github.hooj0.network.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 *  使用nio通讯服务器端代码
 * @author hoojo
 * @createDate Sep 23, 2010 10:48:11 AM
 * @file NioChatServer.java
 * @package com.hoo.base.nio
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class NioChatServer {
	//用于检定所有的Channel状态的Selector
	private Selector selector = null;
	
	//定义编码、解码的字符集对象
	private Charset charset = Charset.forName("UTF-8");
	
	public void init() throws IOException {
		selector = Selector.open();
		//通过open方法打开一个未绑定的ServerSocketChannel
		ServerSocketChannel server = ServerSocketChannel.open();
		
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 29999);
		//将当前server绑定到指定的ip地址上
		server.socket().bind(address);
		
		//设置非阻塞的方式工作
		server.configureBlocking(false);
		//将server注册到selector对象上
		server.register(selector, SelectionKey.OP_ACCEPT);
		
		while (selector.select() > 0) {
			//依次处理SelectionKey上每个已经选择的SelectionKey
			for (SelectionKey sk : selector.selectedKeys()) {
				//对selector上的已经选择的key 集中删除正在处理的SelectionKey
				selector.selectedKeys().remove(sk);
				//如果sk对应的通道包含客户端的连接请求
				if (sk.isAcceptable()) {
					//调用accept方法接受连接请求，产生服务器对应的SocketChannel
					SocketChannel sc = server.accept();
					//设置采用非阻塞方式
					sc.configureBlocking(false);
					//将当前的SocketChannel也注册到selector上
					sc.register(selector, SelectionKey.OP_READ);
					sk.interestOps(SelectionKey.OP_ACCEPT);
				}
				//如果sk对应的通道有数据需要读取
				if (sk.isReadable()) {
					//获取当前的SelectionKey对应的Channel，该Channel中有读取的数据
					SocketChannel sc = (SocketChannel) sk.channel();
					//定义准备执行读取数据的ByteBuffer
					ByteBuffer bf = ByteBuffer.allocate(1024);
					String content = "";
					try {
						while (sc.read(bf) > 0) {
							bf.flip();
							content += charset.decode(bf);
						}
						//打印从sk中读取的数据
						System.out.println("######" + content);
						//设置sk对应的Channel为准备下一次读取
						sk.interestOps(SelectionKey.OP_READ);
					} catch (Exception e) {
						// 如果出现该sk中对应的Channel的异常，就表明该Channel
						//对应的Client出现了问题，所以要从Selector中取消sk的注册
						//从Selector中删除指定的SelectionKey
						sk.cancel();
						if (sk.channel() != null && sk.channel().isOpen()) {
							//&& sk.channel().isRegistered()
							sk.channel().close();
						}
					}
					//如果content的长度不为null，即得到的数据（聊天信息）不为空
					if (content.length() > 0) {
						//遍历该selector里注册的所有SelectionKey
						for (SelectionKey key : selector.keys()) {
							//获取该key对应的Channel
							Channel currentChannel = key.channel();
							//如果该channel是SocketChannel对象
							if (currentChannel instanceof SocketChannel) {
								//将读取到的内容写入该Channel中
								SocketChannel writeSc = (SocketChannel) currentChannel;
								writeSc.write(charset.encode(content));
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new NioChatServer().init();
	}
}
