package io.github.hooj0.network.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketTest {

	/**
	 * <b>function:</b>Scoket客户端
	 * @author hoojo
	 * @createDate Sep 22, 2010 11:54:50 AM
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		//30000端口和服务器端的对应
		Socket sk = new Socket("127.0.0.1", 30000);
		//10秒后超时
		sk.setSoTimeout(1000 * 10);
		
		//Socket s = new Socket();
		//s.connect(new InetAddress("127.0.0.1", 30000), 10000);
		
		//将Socket对应的输入流封装成BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		//进行普通的IO操作
		String sayMsg = br.readLine();
		System.out.println("来自服务器端的问候：" + sayMsg);
		sayMsg = br.readLine();
		System.out.println("来自服务器端的Message：" + sayMsg);
		PrintStream ps = new PrintStream(sk.getOutputStream());
		ps.println("向服务器端发送消息1");
		ps.println("向服务器端发送消息2");
		ps.println("向服务器端发送消息3");
		br.close();
		sk.close();
	}
}
