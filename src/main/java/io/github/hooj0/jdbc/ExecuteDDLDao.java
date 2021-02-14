package io.github.hooj0.jdbc;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * <b>function:</b> 执行SQL语句
 * @author hoojo
 * @createDate 2011-5-11 下午09:19:19
 * @file ExecuteDDLDao.java
 * @package com.hoo.base
 * @project JavaJDBC
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ExecuteDDLDao {
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	public ExecuteDDLDao() {
		try {
			DBHelper.loadParams(System.getProperty("user.dir") + "/src/jdbc.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <b>function:</b>执行DDL语句
	 * @author hoojo
	 * @createDate 2011-5-9 下午09:34:11
	 * @param sql
	 * @return boolean 是否成功
	 */
	public boolean executeDML(String sql) {
		boolean flag = false;
		conn = DBHelper.getConnection();
		try {
			st = conn.createStatement();
			//执行DDL的SQL语句
			int count = st.executeUpdate(sql);
			System.out.println(count);
			flag = count > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBHelper.close();
		}
		return flag;
	}
	
	/**
	 * <b>function:</b> 执行DLL语句
	 * @author hoojo
	 * @createDate 2011-5-11 下午09:19:54
	 * @param sql
	 * @return
	 */
	public int executeDDL(String sql) {
		int count = 0;
		conn = DBHelper.getConnection();
		try {
			st = conn.createStatement();
			//执行DDL的SQL语句
			count = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBHelper.close();
		}
		return count;
	}
	
	/**
	 * <b>function:</b>执行任意SQL语句
	 * @author hoojo
	 * @createDate 2011-5-11 下午09:12:31
	 * @param sql
	 * @return
	 */
	public int executeSQL(String sql) {
		int count = 0;
		conn = DBHelper.getConnection();
		try {
			st = conn.createStatement();
			//执行SQL语句是boolean=true值就表示返回的是ResultSet对象
			boolean flag = st.execute(sql);
			if (flag) {
				//获得结果集
				rs = st.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				while (rs.next()) {
					for (int i = 0; i < cols; i++) {
						System.out.print(rsmd.getColumnName(i + 1) + ":" + rs.getString(i + 1) + "\t");
					}
					System.out.println();
				}
			} else {
				count = st.getUpdateCount();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBHelper.close();
		}
		return count;
	}
	
	/**
	 * <b>function:</b>Statement添加数据效率没有PrepareStatement速度快
	 * @author hoojo
	 * @createDate 2011-5-14 上午11:32:43
	 * @return
	 */
	public int addByStatement() {
		int count = 0;
		conn = DBHelper.getConnection();
		try {
			long start = System.currentTimeMillis();
			st = conn.createStatement();
			for (int i = 0; i < 100; i++) {
				st.executeUpdate("insert into temp values('st-" + i + "')");
			}
			System.out.println("Statement耗时：" + (System.currentTimeMillis() - start));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBHelper.close();
		}
		return count;
	}
	
	/**
	 * <b>function:</b>prepareStatement添加数据比Statement速度快
	 * @author hoojo
	 * @createDate 2011-5-14 上午11:32:10
	 * @return
	 */
	public int add() {
		int count = 0;
		conn = DBHelper.getConnection();
		try {
			long start = System.currentTimeMillis();
			ps = conn.prepareStatement("insert into temp values(?)");
			for (int i = 0; i < 100; i++) {
				ps.setString(1, "ps-" + i);
				count = ps.executeUpdate();
			}
			System.out.println("prepareStatement耗时：" + (System.currentTimeMillis() - start));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBHelper.close();
		}
		return count;
	}
	
	/**
	 * <b>function:</b>statement登陆，可以sql注入
	 * @author hoojo
	 * @createDate 2011-5-14 上午11:31:38
	 * @param name
	 * @return
	 */
	public int loginByStatement(String name) {
		int count = 0;
		conn = DBHelper.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from temp where name = '" + name + "'");
			count = rs.getRow();
			if (rs.next()) {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBHelper.close();
		}
		return count;
	}
	
	/**
	 * <b>function:</b>执行存储过程
	 * @author hoojo
	 * @createDate 2011-5-14 上午11:31:14
	 * @return
	 */
	public int callProc() {
		int result = 0;
		conn = DBHelper.getConnection();
		try {
			//使用Connection来创建一个CallableStatement对象
			cs = conn.prepareCall("{call sum_add(?, ?, ?)}");
			cs.setInt(1, 2);
			cs.setInt(2, 4);
			//设置第三个参数输出参数、参数类型
			cs.registerOutParameter(3, Types.INTEGER);
			boolean flag = cs.execute();
			System.out.println(flag);
			//获得第三个参数
			result = cs.getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBHelper.close();
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		ExecuteDDLDao dao = new ExecuteDDLDao();
		//System.out.println(dao.executeDML("create table temp( id int identity, name varchar(20) )"));
		/*System.out.println(dao.executeDDL("/*insert into temp values('aaaa');" +
				"insert into temp values('bbbb');" +
				"select * from temp;" +
				"update temp set name = 'eft'"));*/
		//System.out.println(dao.executeSQL("update temp set name = 'jojo';"));
		System.out.println(dao.executeSQL("select * from temp;"));
		//System.out.println(dao.addByStatement());
		//System.out.println(dao.add());
		//System.out.println(dao.loginByStatement("st-a1' or 'a' = 'a"));
		System.out.println(dao.callProc());
	}
}
