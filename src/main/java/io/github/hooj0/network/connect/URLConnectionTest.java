package io.github.hooj0.network.connect;

import io.github.hooj0.BasedTests;

import java.net.URL;
import java.net.URLConnection;

/**
 * url connection 测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 14:08:00
 */
public class URLConnectionTest extends BasedTests {

	public static void main(String[] args) throws Exception {
		//设置访问资源
		URL url = new URL("http://localhost:8080/API/ext2/docs/index.html");
		//打开访问资源链接
		URLConnection conn = url.openConnection();
		
		//设置请求头字段
		
		//如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查
		conn.setAllowUserInteraction(true);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		//有些协议支持跳过对象获取，除非该对象在某个特定时间点之后又进行了修改
		conn.setIfModifiedSince(200);
		conn.setUseCaches(true); // 使用缓存
		conn.setRequestProperty("userName", "admin");
		conn.addRequestProperty("accpet", "*/*");
		Object content = conn.getContent();

		System.out.println(content);
		System.out.println(conn.getHeaderField(100));
	}
}
