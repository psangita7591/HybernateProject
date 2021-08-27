package com.csi.jpa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Service {

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		getData();
		saveData();

	}

	static void saveData() {

		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		Customer cc=new Customer();
		
		cc.setCustName("Priya");
		cc.setCustAdd("sangli");
		session.save(cc);
		
		transaction.commit();
	}
	
	static void getData()
	{
		Session session=factory.openSession();
		
		List<Customer>custList=session.createQuery("from Customer").list();
		
		custList.forEach(System.out::println);
	}
}
