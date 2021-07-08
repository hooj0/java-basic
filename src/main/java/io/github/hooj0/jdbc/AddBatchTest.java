package io.github.hooj0.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  批量更新
 * @author hoojo
 * @createDate 2011-5-21 下午03:24:43
 * @file AddBatchTest.java
 * @package com.hoo.base
 * @project JavaJDBC
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class AddBatchTest {
	private Connection conn;
	private Statement sm;
	
	public AddBatchTest() {
		try {
			DBHelper.loadParams(System.getProperty("user.dir") + "/src/jdbc.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] executeBatch(String[] sql) throws SQLException {
		int[] result = null;
		conn = DBHelper.getConnection();
		try {
			//获得当前Connection的提交模式
			@SuppressWarnings("unused")
			boolean autoCommit = conn.getAutoCommit();
			//关闭自动提交模式
			conn.setAutoCommit(false);
			sm = conn.createStatement();
			for (String s : sql) {
				sm.addBatch(s);
			}
			//执行批量更新
			result = sm.executeBatch();
			//提交事务
			conn.commit();
			//还原提交模式
			conn.setAutoCommit(autoCommit);
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (sm != null) {
				sm.close();
			}
			DBHelper.close();
		}
		return result;
	}
	
	public static void main(String[] args) throws SQLException {
		AddBatchTest test = new AddBatchTest();
		String[] sql = {
				"update temp set name = 'abc' where id = 22",
				"update temp set name = 'zzz' where id = 33",
				"update temp set name = 'fff' where id = 55",
				"update temp set name = 'eee' where id = 44",
				/*"select * from temp",*/
				"update temp set name = 'ddd' where id = 66"
		};
		int[] result = test.executeBatch(sql);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
