package com.esra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.esra.entity.Ogretmen;
import com.esra.entity.OgretmenDetay;

public class HibernateOneToOneDelete {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		
		session.beginTransaction();
		OgretmenDetay ogrDty=session.get(OgretmenDetay.class,28);
		session.delete(ogrDty);

		session.getTransaction().commit();
		session.close();

	}

}
