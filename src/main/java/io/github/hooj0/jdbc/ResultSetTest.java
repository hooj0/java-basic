package io.github.hooj0.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  ResultSet操作
 * @author hoojo
 * @createDate 2011-5-14 下午12:58:54
 * @file ResultSetTest.java
 * @package com.hoo.base
 * @project JavaJDBC
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ResultSetTest {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ResultSetTest() {
		try {
			DBHelper.loadParams(System.getProperty("user.dir") + "/src/jdbc.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateResultSetRowData() {
		try {
			conn = DBHelper.getConnection();
			//创建一个可以滚动，可以更新的prepareStatement
			ps = conn.prepareStatement("select * from temp", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			rs.last();//最后一条
			int rows = rs.getRow();
			//倒序循环
			for (int i = rows; i > 0; i--) {
				rs.absolute(i);
				System.out.println(rs.getString(1) + "#" + rs.getString(2));
				//修改当前记录的第二列值
				rs.updateString(2, "Java" + i);
				//执行修改
				rs.updateRow();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBHelper.close();
		}
	}
	
	
	
	/**
	 * 
	 * @author hoojo
	 * @createDate 2011-5-14 下午12:58:55
	 * @param args
	 */
	public static void main(String[] args) {
		ResultSetTest test = new ResultSetTest();
		test.updateResultSetRowData();
	}
}
