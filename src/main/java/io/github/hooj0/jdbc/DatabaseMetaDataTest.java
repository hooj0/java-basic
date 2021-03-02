package io.github.hooj0.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * <b>function:</b>分析数据库数据
 * @author hoojo
 * @createDate 2011-5-21 下午04:04:20
 * @file DatabaseMetaDataTest.java
 * @package com.hoo.base
 * @project JavaJDBC
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class DatabaseMetaDataTest {
	
	private Connection conn;
	
	
	public DatabaseMetaDataTest() {
		try {
			DBHelper.loadParams(System.getProperty("user.dir") + "/src/jdbc.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void analyseDataBaseInfo() {
		conn = DBHelper.getConnection();
		try {
			//获取DatabaseMetaData对象
			DatabaseMetaData dbmd = conn.getMetaData();
			
			//获取当前数据库支持所有表类型
			ResultSet rs = dbmd.getTableTypes();
			System.out.println("----当前数据库支持表类型----");
			this.printTableTypes(rs);
			
			//获取当前数据库的所有表
			rs = dbmd.getTables(null, null, "%", new String[] { "TABLE" });
			System.out.println("-----当前数据库所有表信息----");
			this.printTableTypes(rs);
			
			//获取指定table的主键
			rs = dbmd.getPrimaryKeys(null, null, "temp");
			System.out.println("----获取当前表的主键信息----");
			this.printTableTypes(rs);
			
			//获取当前数据库全部存储过程
			rs = dbmd.getProcedures(null, null, "%");
			System.out.println("-----当前数据库所有存储过程-----");
			//this.printTableTypes(rs);
			
			//获取某2个table的外键约束
			rs = dbmd.getCrossReference(null, null, "tree", null, null, "temp");
			System.out.println("-----显示当前2个table的外键约束-----");
			printTableTypes(rs);
			
			//获取某个表的所有数据列
			rs = dbmd.getColumns(null, null, "tree", "%");
			System.out.println("----获取某个table的所有数据列----");
			printTableTypes(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printTableTypes(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		//显示列名称
		for (int i = 0, count = rsmd.getColumnCount(); i < count; i++) {
			System.out.print(rsmd.getColumnName(i + 1) + "\t");
		}
		System.out.println();
		while (rs.next()) {
			for (int i = 0, count = rsmd.getColumnCount(); i < count; i++) {
				System.out.print(rsmd.getColumnName(i + 1) + " : " + rs.getString(i + 1) + "\t");
			}
			System.out.println();
		}
		rs.close();
	}
	
	public static void main(String[] args) {
		DatabaseMetaDataTest test = new DatabaseMetaDataTest();
		test.analyseDataBaseInfo();
	}
}
