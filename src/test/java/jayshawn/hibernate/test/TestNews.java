package jayshawn.hibernate.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Test;
import com.mysql.jdbc.*;

import jayshawn.hibernate.helloworld.News;

public class TestNews {

	
	
	@Test
	public void test() {
		
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		.configure() // configures settings from hibernate.cfg.xml
		.build();
		
		SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println(session);
		session.beginTransaction();
		session.save( new News("AA","AA",new Timestamp(System.currentTimeMillis())));
		session.getTransaction().commit();
		session.close();
		
		
	}

	

}
