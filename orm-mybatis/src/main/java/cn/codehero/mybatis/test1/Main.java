package cn.codehero.mybatis.test1;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.codehero.mybatis.util.MybatisUtils;
/**
 * 测试主程序
 * @author eleven
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getFactory();
		//创建能执行映射文件中的sqlSession
		SqlSession session = sessionFactory.openSession();
		//映射sql的标识字符串
		String statement = "cn.codehero.mybatis.test1.userMapper.getUser";
		//映射查询返回一个唯一user对象的sql
		User user = session.selectOne(statement,2);
		System.out.println(user);
	}
}
