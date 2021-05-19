package io.github.hooj0.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <b>function:</b> 数据库连接助手类、工具类、辅助类
 * @author hoojo
 * @createDate 2011-5-9 下午09:36:00
 * @file DBHelper.java
 * @package com.hoo.base
 * @project JavaJDBC
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public abstract class DBHelper {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	private static Connection conn;
	
	/**
	 * <b>function:</b> 加载参数信息
	 * @author hoojo
	 * @createDate May 9, 2011 9:25:45 PM
	 * @param paramFile
	 * @throws IOException
	 */
	public static void loadParams(String paramFile) throws IOException {
		//使用properties文件来加载参数信息
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(paramFile));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("文件不存在" + e);
		}
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		password = props.getProperty("password");
	}
	
	/**
	 * <b>function:</b> 获得数据库连接
	 * @author hoojo
	 * @createDate 2011-5-9 下午09:47:21
	 * @return 返回数据库连接
	 */
	public final static Connection getConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(driver + " 驱动类不存在！" + e);
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库连接出现错误 " + e);
		}
		return conn;
	}
	
	/**
	 * <b>function:</b> 关闭数据库连接
	 * @author hoojo
	 * @createDate 2011-5-9 下午09:46:53
	 * @return 关闭是否成功
	 */
	public final static boolean close() {
		boolean flag = false;
		try {
			if (conn != null && !conn.isClosed()) {
				try {
					conn.close();
					flag = true;
				} catch (SQLException e) {
					e.printStackTrace();
					flag = false;
					throw new RuntimeException("数据库关闭错误" + e);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			throw new RuntimeException("数据库关闭错误" + e);
		}
		return flag;
	}
}
