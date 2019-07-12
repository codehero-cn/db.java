package cn.codehero.hibernate.helloworld;

//import static org.junit.Assert.*;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void test() {
		//1.创建一个SessionFactory对象
		SessionFactory sessionFactory = null;
		//1).创建Configuration对象:对应hibernate的基本配置信息和对象关系映射信息
		//configure()默认调用根目录下hibarnate.hbm.xml
		Configuration configuration = new Configuration().configure();
		
		//4.0之前这样创建
		//sessionFactory = configuration.buildSessionFactory();
		
		//2).创建一个ServiceRegistry对象：hibernate 4.x新添加的对象
		//hibernate的任何配置和服务都需要在该对象中注册后才能有效.
		ServiceRegistry serviceRegistry = 
				new ServiceRegistryBuilder().applySettings(configuration.getProperties())
											.buildServiceRegistry();
		
		//3).
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//2.创建一个Session地象
		Session session = sessionFactory.openSession();
		
		//3.开启事务
		Transaction transaction = session.beginTransaction();
		
		//4.执行保存操作
		Article article = new Article("Java","ATGUIGU", "test",new Date(new java.util.Date().getTime()));
		session.save(article);
		
		//5.提交事务
		transaction.commit();
		
		//6.关闭Session
		session.close();
		
		//7.关闭SessionFactory对象
		sessionFactory.close();
	}

}
