package cn.codehero.jdbc.mysql.sql;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.*;
/**
 * Description:
 * <br>Program Name:调用存储过程
 * <br>来源:疯狂java(第2版)codes/13/13.4/CallableStatementTest.java
 * <br>Date:
 * <br>//TODO 未演示成功
 * @author eleven
 * @version 0.1
 */
public class CallableStatementTest
{
	private String driver;
	private String url;
	private String user;
	private String pass;
	public void initParam(String paramFile)throws Exception
	{
		// 使用Properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	public Connection  loadDriverAndCreatConn(){
		Connection conn = null;
			try {
				// 加载驱动
				Class.forName(driver);
				// 获取数据库连接
			conn = DriverManager.getConnection(this.url, this.user , this.pass);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	
			return conn;
	}
	public void creatProcedure(Connection conn,String procedureSQL){
		try {
			Statement stmt = conn.createStatement();
			System.out.println("hell");
			stmt.execute(procedureSQL);
			
			} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public void callProcedure(Connection conn)throws Exception
	{
		
		try(
			
			// 使用Connection来创建一个CallableStatment对象
			CallableStatement cstmt = conn.prepareCall(
				"{call add_pro(?,?,?)}"))
		{
			cstmt.setInt(1, 4);
			cstmt.setInt(2, 5);
			// 注册CallableStatement的第三个参数是int类型
			cstmt.registerOutParameter(3, Types.INTEGER);
			// 执行存储过程
			cstmt.execute();
			// 获取，并输出存储过程传出参数的值。
			System.out.println("执行结果是: " + cstmt.getInt(3));
		}
	}
	public static void main(String[] args) throws Exception
	{
		//要生成的存储过程sql脚本
		Connection conn;
		//String procedureSQL = "create procedure add_pro(a int,b int,out sum int)"
		String procedureSQL = "create procedure add_pro(a int,b int,out sum int) "
				+"begin "
				+"set sum = a + b; "
				+"end;";
		
		CallableStatementTest ct = new CallableStatementTest();
		
		//加载数据库配置并生成数据库连接
		File filepath = new File(ct.getClass().getResource("").getPath());
		ct.initParam(filepath+"/"+"mysql.ini");
		System.out.println(ct.driver+"/"+ct.url+"/"+ct.user+"/"+ct.pass);
		conn = ct.loadDriverAndCreatConn();
		System.out.println(conn);
		
		//如果已经生成了存储过程,下行注释掉
		//ct.creatProcedure(conn,procedureSQL);
		
		ct.callProcedure(conn);
	}
}

