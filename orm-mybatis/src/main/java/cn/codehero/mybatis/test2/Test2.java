package cn.codehero.mybatis.test2;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import cn.codehero.mybatis.test1.User;
import cn.codehero.mybatis.util.MybatisUtils;

public class Test2 {
	@Test
	public void testAdd2(){
		SqlSessionFactory sessionFactory = MybatisUtils.getFactory();
		SqlSession session = sessionFactory.openSession(true);
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		int add = mapper.add(new User(-1,"SS",45));
		System.out.println(add);
		session.close();
	}
}
