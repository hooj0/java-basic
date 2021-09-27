package io.github.hooj0.network.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NioClientThread extends Thread {
	private Selector selector = null;
	private Charset charset = null;
	
	public NioClientThread(Selector selector, Charset charset) {
		this.selector = selector;
		this.charset = charset;
	}
	
	public void run() {
		try {
			while (selector.select() > 0) {
				//遍历每个有可用的IO操作 Channel对应的SelectionKey
				for (SelectionKey sk : selector.keys()) {
					//删除正在处理的SelectionKey
					selector.selectedKeys().remove(sk);
					//如果当前SelectionKey对应的Channel中有可读数据
					if (sk.isReadable()) {
						//使用NIO读取Channel中的数据
						SocketChannel sc = (SocketChannel) sk.channel();
						ByteBuffer bf = ByteBuffer.allocate(1024);
						String content = "";
						while (sc.read(bf) > 0) {
							sc.read(bf);
							bf.flip();
							content += charset.decode(bf);
						}
						//打印读取的数据
						System.out.println("Message：" + content);
						//为下一次读取做准备
						sk.interestOps(SelectionKey.OP_READ);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
