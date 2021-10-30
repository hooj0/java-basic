package io.github.hooj0.network.proxy;

import io.github.hooj0.BasedTests;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * 网络代理链接
 *
 * @author hoojo
 * @version 1.0
 * @createDate Sep 24, 2010 3:04:05 PM
 * @file ProxyTest.java
 * @package com.hoo.base.proxy
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class ProxyTest extends BasedTests {

    private Proxy proxy;
    private URL url;
    private URLConnection conn;
    //通过代理读取网络数据
    private Scanner scan;
    private PrintStream ps;
    //设置ip和端口
    private final String address = "127.0.0.1";
    private final int port = 30000;

    //要请求的网址
    String uri = "http://localhost:8080/JavaNetBase/index.jsp";

    public void init() {
        try {
	        this.url = new URL(this.uri);
            //创建代理服务器
	        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.address, this.port));
            //使用代理打开连接
	        this.conn = this.url.openConnection(this.proxy);
            //设置超时长
	        this.conn.setConnectTimeout(5000);
	        this.scan = new Scanner(this.conn.getInputStream());
            //初始化输出流
	        this.ps = new PrintStream("index.jsp");
            while (this.scan.hasNext()) {
                String line = this.scan.nextLine();
                out(line);
	            this.ps.println(line);
            }
        } catch (Exception e) {
            out(this.uri + "无法访问！");
        } finally {
            if (this.ps != null) {
	            this.ps.close();
            }
        }
    }

    public static void main(String[] args) {
        new ProxyTest().init();
    }
}
