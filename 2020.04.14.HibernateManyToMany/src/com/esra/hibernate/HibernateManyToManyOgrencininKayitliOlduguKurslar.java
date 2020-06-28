package com.esra.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.esra.entity.Kurs;
import com.esra.entity.Ogrenci;
import com.esra.entity.Ogretmen;
import com.esra.entity.OgretmenDetay;

public class HibernateManyToManyOgrencininKayitliOlduguKurslar {

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
		
		/*Ogrenci ogrenci = session.get(Ogrenci.class, 111);
		for (Kurs kurs : ogrenci.getKurslar()) {
			System.out.println("Kurs: "+kurs.getKursAdi());
		}*/
		
		Ogrenci ogrenci = session.get(Ogrenci.class, 1);
		List<Ogrenci> ogrenciler=session.createQuery("from Ogrenci where id=1").getResultList();
		System.out.println(ogrenci);
		for (Ogrenci ogrenci2 : ogrenciler) {
			System.out.println(ogrenci2.getKurslar());

		}
		
		session.getTransaction().commit();
		session.close();
		
	}
}
