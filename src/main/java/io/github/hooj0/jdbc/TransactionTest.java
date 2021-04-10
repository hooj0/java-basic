package io.github.hooj0.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

/**
 * <b>function:</b> 事务处理
 * @author hoojo
 * @createDate 2011-5-19 下午09:18:17
 * @file TransactionTest.java
 * @package com.hoo.base
 * @project JavaJDBC
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class TransactionTest {
	
	private Connection conn;
	private Statement sm;
	
	
	public TransactionTest() {
		try {
			DBHelper.loadParams(System.getProperty("user.dir") + "/src/jdbc.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void add(String[] sql) throws Exception {
		try {
			conn = DBHelper.getConnection();
			//关闭自动提交，开启事物
			conn.setAutoCommit(false);
			sm = conn.createStatement();
			for (String s : sql) {
				sm.executeUpdate(s);
			}
			//提交事务
			conn.commit();
		} catch (Exception e) {//如果不捕获异常信息，那么当出现出现异常的时候出现将自动回滚
			conn.rollback();
			e.printStackTrace();
		} finally {
			if (sm != null) {
				sm.close();
			}
			DBHelper.close();
		}
	}
	
	public static void main(String[] args) {
		TransactionTest test = new TransactionTest();
		String[] sql = {
				"insert into temp values('transaction');",
				"insert into temp values('commit');",
				"insert into temp values('rollback');",
				//下面这条语句将会自动回滚
				"insert into temp values(1);"
		};
		try {
			test.add(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
