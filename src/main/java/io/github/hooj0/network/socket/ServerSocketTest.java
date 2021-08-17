package io.github.hooj0.network.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest {

	/**
	 * ServerSocket服务器端
	 * @author hoojo
	 * @createDate Sep 22, 2010 11:45:38 AM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//创建一个ServerSocket，用于监听客户端socket的连接请求
		ServerSocket ss = new ServerSocket(30000);
		//采用循环不断接受来自客户端的请求
		while (true) {
			//只要有客户端的Socket请求，服务器端也对应的产生一个Socket
			Socket s = ss.accept();
			//将socket对应的输入流封装成PrintStream
			PrintStream ps = new PrintStream(s.getOutputStream());
			//进行普通的IO操作
			ps.println("服务器对你说：你好！");
			ps.println("服务器对你说：你好！服务器即将关闭！");
			
			//关闭Socket的输出流
			s.shutdownOutput();
			System.out.println("服务器真的关闭了吗？" + s.isClosed());
			Scanner sc = new Scanner(s.getInputStream());
			if (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			ps.println("服务器对你说：你好！这是无法发送出去的消息！");
			sc.close();
			ps.flush();
			ps.close();
			s.close();
		}
	}
}
