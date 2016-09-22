package cn.codehero.jdbc.mysql.sql;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.*;
/**
 * Description:
 * <br>Program Name:
 * <br>Date:20161217
 * 参考:疯狂java讲义(第2版) codes\13\13.4\LoginFrame.java
 * 操作:第1个框中输入 ' or true or '可以显示登录成功。eleven实验不成功.
 * @author eleven
 * @version 0.1
 */
public class LoginFrameOld
{
	private final String PROP_FILE = "mysql.ini";
	private String driver;
	// url是数据库的服务地址
	private String url;
	private String user;
	private String pass;
	// 登录界面的GUI组件
	private JFrame jf = new JFrame("登录");
	private JTextField userField = new JTextField(20);
	private JTextField passField = new JTextField(20);
	private JButton loginButton = new JButton("登录");
	public void init()throws Exception
	{
		Properties connProp = new Properties();
		File filepath = new File(this.getClass().getResource("").getPath());
		connProp.load(new FileInputStream(filepath+"/"+PROP_FILE));
		driver = connProp.getProperty("driver");
		url = connProp.getProperty("url");
		user = connProp.getProperty("user");
		pass = connProp.getProperty("pass");
		// 加载驱动
		Class.forName(driver);
		// 为登录按钮添加事件监听器
		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// 登录成功则显示"登录成功"
				if (validate(userField.getText(), passField.getText()))
				{
					JOptionPane.showMessageDialog(jf, "登录成功");
				}
				// 否则显示"登录失败"
				else
				{
					JOptionPane.showMessageDialog(jf, "登录失败");
				}
			}
		});
		jf.add(userField , BorderLayout.NORTH);
		jf.add(passField);
		jf.add(loginButton , BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}
	private boolean validate(String userName, String userPass)
	{
		// 执行查询的SQL语句
		String sql = "select * from jdbc_test "
			+ "where jdbc_name='" + userName 
			+ "' and jdbc_desc='" + userPass + "'";
		System.out.println(sql);
		try(
			Connection conn = DriverManager.getConnection(url
				, user ,pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql))
		{
			// 如果查询的ResultSet里有超过一条的记录，则登录成功
			if (rs.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

public static void main(String[] args) throws Exception
	{
		new LoginFrameOld().init();
	}
}
