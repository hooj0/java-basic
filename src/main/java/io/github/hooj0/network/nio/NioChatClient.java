package io.github.hooj0.network.nio;

import io.github.hooj0.BasedTests;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/***
 * nio实现通信客户端
 * @author hoojo
 * @createDate Sep 23, 2010 9:31:39 PM
 * @file NioChatClient.java
 * @package com.hoo.base.nio
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class NioChatClient extends BasedTests {

    // 定义检测SocketChannel的Selector对象
    private Selector selector = null;
    // 定义处理编码和解码字符集对象
    private final Charset charset = Charset.forName("UTF-8");
    // 客户端SocketChannel
    private SocketChannel sc = null;

    public void init() throws Exception {
	    this.selector = Selector.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 29999);
        //调用open静态方法创建连接到指定主机上的SocketChannel
	    this.sc = SocketChannel.open(isa);

        //设置SocketChannel以非阻塞的方式工作
	    this.sc.configureBlocking(false);
        //将sc注册到指定的Selector上
	    this.sc.register(this.selector, SelectionKey.OP_READ);

        //启动读取服务器端数据的多线程
        new NioClientThread(this.selector, this.charset).start();

        //创建键盘输入流
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            //读取键盘输入的数据
            String keyIn = scan.nextLine();
            //将输入的数据输出到SocketChannel中
	        this.sc.write(this.charset.encode(keyIn));
        }
    }

    /**
     * 入口函数
     *
     * @param args
     * @throws Exception
     * @author hoojo
     * @createDate Sep 23, 2010 10:46:48 AM
     */
    public static void main(String[] args) throws Exception {
        new NioChatClient().init();
    }
}
