package cn.codehero.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.codehero.mybatis.test1.Main;
/**
 * 提取出来的工具类
 * @author eleven
 *
 */
public class MybatisUtils {
	public static SqlSessionFactory getFactory(){
		String resource = "cn/codehero/mybatis/test1/conf.xml";
		//方法1
		/*
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		*/
		
		//方法2
		//加载mybatis的配置文件(它也加载关联的映射文件)
		InputStream inputStream= Main.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sessionFactory;
	}
}
