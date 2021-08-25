package io.github.hooj0.network.url;

import java.net.URL;

public class URLTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8080/API/ext2/docs/index.html?query=背影&author=朱自清");
		System.out.println("访问资源名称：" + url.getFile());
		System.out.println("主机名称：" + url.getHost());
		System.out.println("获取访问的路径：" + url.getPath());
		System.out.println("获取访问的端口：" + url.getPort());
		System.out.println("获取访问的默认端口：" + url.getDefaultPort());
		System.out.println("获取协议名称：" + url.getProtocol());
		System.out.println("获取查询字符串部分：" + url.getQuery());//?号后面的参数部分
		System.out.println("授权：" + url.getAuthority());
		System.out.println("内容：" + url.getContent());
		System.out.println("获取访问资源引用：" + url.getRef());
		System.out.println("获取userInfo：" + url.getUserInfo());
		System.out.println(url.toURI().getQuery());
	}

}
