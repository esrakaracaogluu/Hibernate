package com.esra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.esra.entity.Ogretmen;
import com.esra.entity.OgretmenDetay;

public class HibernateOneToOne {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		OgretmenDetay ogrDty = new OgretmenDetay("java", "sinema", "https://google.com", "face");
		Ogretmen ogr = new Ogretmen(ogrDty, "esra12", "karacaoglu", "aad@hotmail");
		session.beginTransaction();
		//session.save(ogrDty);//Cascade'i ekleyince buraya gerek kalmadý
		session.save(ogr);

		session.getTransaction().commit();
		session.close();

	}

}
