package io.github.hooj0.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSQLServer {

	/**
	 * SQLServer数据库链接
	 * @author hoojo
	 * @createDate May 4, 2011 10:09:49 PM
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、加载驱动，利用反射机制
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//2、使用DriverManager获取数据库链接，不同的数据库链接都不一样，具体查看官方驱动API
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=extDB", "sa", "sa");
		
		//3、使用Connection来创建一个Statement对象
		Statement sm = conn.createStatement();
		
		//4、执行SQL语句
		/**
		 * execute方法可以执行然后语句，但都返回一个boolean值，如果执行后第一个结果是ResultSet，则返回true
		 * 否则返回false
		 * executeQuery 执行select语句， 返回查询的结果集ResultSet
		 * executeUpdate 用于执行DML语句，返回一个整数，是执行语句影响的记录的行数
		 **/
		ResultSet rs = sm.executeQuery("select * from tree");
		
		//ResultSet 可以通过getXxx(索引下标 || 列名字段名)方法，来获取记录指针指向的行、特定列的值
		//不断地使用next将记录指针指向下一行，直到没有指向的行时，跳出循环
		while (rs.next()) {
			//System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4));
			System.out.println(rs.getInt("id") + "---" + rs.getString("name") + "---" + rs.getInt("parentId") + "---" + rs.getInt("childCount"));
		}
		
		//关闭连接、释放资源
		if (rs != null) {
			rs.close();
		}
		if (sm != null) {
			//System.out.println(sm.isClosed());
			sm.close();
		}
		if (conn != null) {
			//System.out.println(conn.isClosed());
			conn.close();
		}
	}
}
