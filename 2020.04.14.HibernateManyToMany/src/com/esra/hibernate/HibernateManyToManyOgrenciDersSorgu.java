package com.esra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.esra.entity.Kurs;
import com.esra.entity.Ogrenci;
import com.esra.entity.Ogretmen;
import com.esra.entity.OgretmenDetay;

public class HibernateManyToManyOgrenciDersSorgu {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate-config.xml")
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Ogrenci.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		
		//Ogrenci sorgula,kurs sorgula,öðrenciye kursu ekle
		
		Ogrenci ogrenci = session.get(Ogrenci.class, 1);
		Kurs kurs=session.get(Kurs.class, 52);
		//Kurs kurs1=new Kurs("Ýsletim",5,ogretmen);
		
		ogrenci.addKurs(kurs);
		session.save(ogrenci);
        
		session.getTransaction().commit();
		session.close();
		
	}
}
