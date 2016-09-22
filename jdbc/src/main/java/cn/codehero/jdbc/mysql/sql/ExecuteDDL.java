package cn.codehero.jdbc.mysql.sql;

import java.util.*;
import java.io.*;
import java.sql.*;
/**
 * Description:
 * <br>Program Name:
 * <br>Date:20161215
 * 参考:疯狂java讲义(第2版) codes\13\13.4\ExecuteDDL.java
 * @author eleven
 * @version 0.2
 * 
 */
public class ExecuteDDL
{
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public void initParam(String paramFile)
		throws Exception
	{
		// 使用Properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	public void createTable(String sql)throws Exception
	{
		// 加载驱动
		Class.forName(driver);
		try(
		// 获取数据库连接
		Connection conn = DriverManager.getConnection(url , user , pass);
		// 使用Connection来创建一个Statment对象
		Statement stmt = conn.createStatement())
		{
			// 执行DDL,创建数据表
			stmt.executeUpdate(sql);
		}
	}
	public static void main(String[] args) throws Exception
	{
		ExecuteDDL ed = new ExecuteDDL();
		File filepath = new File(ed.getClass().getResource("").getPath()); 
		System.out.println(filepath);
		ed.initParam(filepath+"/"+"mysql.ini");
		ed.createTable("create table jdbc_test "
			+ "( jdbc_id int auto_increment primary key, " 
			+ "jdbc_name varchar(255), "
			+ "jdbc_desc text);");
		System.out.println("-----建表成功-----");
	}
}

