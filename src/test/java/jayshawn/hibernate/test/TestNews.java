package jayshawn.hibernate.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.security.auth.Destroyable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.mysql.jdbc.*;

import jayshawn.hibernate.helloworld.News;

public class TestNews {

	private Session session = null;
	private SessionFactory sessionFactory = null;
	
	@Before
	public void init(){
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		.configure("/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
		.build();
		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	@After
	public void Destroyable(){
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	public void testSave() {
		session.save( new News("BB","BB",new Timestamp(System.currentTimeMillis())));
	}
	
	@Test
	public void testGetCache(){
		//只发送了一条查询语句, 因为启用了ehcache,二级缓存是sessionFactory级别的,因为sessionFactory没有关闭,所以生效了
		News news1 = session.get(News.class, 1);
		session.getTransaction().commit();
		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();
		News new2 = session.get(News.class, 1);
	}
	
	@Test
	public void testQueryCache(){
		Query query =  session.createQuery("FROM News");
		query.setCacheable(true);
		List<News> list = query.list();
		System.out.println(list.size());
		list = query.list();
		System.out.println(list.size());
		
	}

	

}
