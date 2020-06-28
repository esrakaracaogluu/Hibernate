package com.esra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.esra.entity.Kurs;
import com.esra.entity.Ogrenci;
import com.esra.entity.Ogretmen;
import com.esra.entity.OgretmenDetay;

public class HibernateManyToMany {

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
		
		//Ogretmen ogr = session.get(Ogretmen.class, 44);
		
		//62 nolu kursu aldým 2 öðrenciyi kaydettim
		Kurs kurs = session.get(Kurs.class, 62);
		
		Ogrenci ogrenci1=new Ogrenci("Seda","Karakas",111);
		Ogrenci ogrenci2=new Ogrenci("Ceyda","Kar",112);
		
		kurs.addOgrenci(ogrenci1);
		kurs.addOgrenci(ogrenci2);

		session.save(kurs);
        
		session.getTransaction().commit();
		session.close();
		
	}
}
