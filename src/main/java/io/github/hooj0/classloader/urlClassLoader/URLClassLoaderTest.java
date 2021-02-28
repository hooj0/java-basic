package io.github.hooj0.classloader.urlClassLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class URLClassLoaderTest {
	private static Connection conn;
	
	public static Connection getConn(String url, String user, String pwd) throws MalformedURLException, Exception {
		if (conn == null) {
			//URL[] urls = {new URL("file:mysql-connector-java-3.1.10-bin.jar")};
			URL[] urls = {new URL("file:sqljdbc.jar")};
			//默认的ClassLoader作为父类的ClassLoader，创建URLClassLoader
			URLClassLoader ucl = new URLClassLoader(urls);
			//加载MySQL的JDBC的驱动，并创建默认实例
			Driver driver = (Driver) ucl.loadClass("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			//创建一个设置连接的Properties的对象
			Properties pro = new Properties();
			pro.setProperty("user", user);
			pro.setProperty("password", pwd);
			//调用driver的connect方法来获取链接
			//conn = driver.connect("jdbc:mysql://localhost:3306/mysql", pro);
			conn = driver.connect(url, pro);
		}
		return conn;
	}
	
	/**
	 * 
	 * @author hoojo
	 * @createDate Oct 4, 2010 11:56:27 AM
	 * @param args
	 * @throws SQLException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, Exception {
		System.out.println(getConn("jdbc:sqlserver://localhost:1433;databaseName=extDB", "sa", "sa"));
		
	}
}
