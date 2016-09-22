package cn.codehero.mybatis.test1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import cn.codehero.mybatis.util.MybatisUtils;

public class Test1 {
	
	@Test
	public void testAdd(){
		SqlSessionFactory sessionFactory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession();
		
		String statement = "cn.codehero.mybatis.test1.userMapper.addUser";
		int insert = session.insert(statement,new User(-1,"kk",23));
		//提交
		session.commit();
		session.close();
		System.out.println(insert);
	}
	
	@Test
	public void testUpdate(){
		SqlSessionFactory sessionFactory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession(true);
		
		String statement = "cn.codehero.mybatis.test1.userMapper.updateUser";
		
		int update = session.update(statement, new User(7,"kk444",25));
		session.close();
		System.out.println(update);
		
	}
	@Test
	public void testDelete(){
		SqlSessionFactory sessionFactory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession(true);
		String statement = "cn.codehero.mybatis.test1.userMapper.deleteUser";
		
		int delete = session.delete(statement,10);
		session.close();
		System.out.println(delete);
	}
	@Test
	public void testGetUser(){
		SqlSessionFactory sessionFactory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession(true);
		String statement = "cn.codehero.mybatis.test1.userMapper.getUser";
		
		User user = session.selectOne(statement, 2);
		session.close();
		System.out.println(user);
	}
	@Test
	public void testGetAllUser(){
		SqlSessionFactory sessionFactory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession(true);
		String statement = "cn.codehero.mybatis.test1.userMapper.getAllUser";
		
		List<User> list = session.selectList(statement);
		session.close();
		System.out.println(list);
	}
}
