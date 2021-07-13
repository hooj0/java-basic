package io.github.hooj0.network.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws Exception {
		
		//根据主机名称获取inetAddress的实例
		InetAddress ip = InetAddress.getByName("localhost");
		ip = InetAddress.getByName("127.0.0.1");
		ip = InetAddress.getByName(null);//默认localhost
		//判断是否可以访问
		System.out.println("localhost 是否可以访问:" + ip.isReachable(2000));
		//获取ip字符串
		System.out.println(ip.getHostAddress());
		//根据原始的ip地址获取inetAddress的实例
		InetAddress local = InetAddress.getByAddress(new byte[] {127, 0, 0, 1});
		System.out.println("是否可以访问：" + local.isReachable(5000));
		//获取inetAddress的完全限定域名
		System.out.println(local.getCanonicalHostName());
		System.out.println("host:" + local.getHostName());
		InetAddress[] ips = InetAddress.getAllByName("localhost");
		for (int i = 0; i < ips.length; i++) {
			System.out.println(ips[i] + "###" + ips[i].isSiteLocalAddress());
		}
	}
}
