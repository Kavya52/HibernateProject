package anudip.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
	
	public static void main(String[]args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("Hibernate.config.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sfactory=meta.buildSessionFactory();
		Session session=sfactory.openSession();
		
		Transaction t=session.beginTransaction();
		try {
			States s=new States();
			s.setStateName("Telangana");
			
			States s1=new States();
			s1.setStateName("Andra Pradesh");
			
			States s2=new States();
			s2.setStateName("Assam");
			
			Country c=new Country();
			c.setCountryCode(91);
			c.setCountryName("India");
			
			c.getStates().add(s);
			c.getStates().add(s1);
			c.getStates().add(s2);
			
			s.setCountry(c);
			s1.setCountry(c);
			s2.setCountry(c);
			
			
			session.persist(c);
			
			t.commit();
			
		}finally {
			sfactory.close();
			session.close();
		}
		}
	}
