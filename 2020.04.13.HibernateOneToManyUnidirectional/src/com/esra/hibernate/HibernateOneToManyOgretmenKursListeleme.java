package com.esra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.esra.entity.Konu;
import com.esra.entity.Kurs;
import com.esra.entity.Ogretmen;
import com.esra.entity.OgretmenDetay;

public class HibernateOneToManyOgretmenKursListeleme {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate-config.xml")
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Konu.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
        //kurslara konu eklemek için kod
		Ogretmen ogr = session.get(Ogretmen.class, 44);
		for (Kurs kurs : ogr.getKurslar()) {
			System.out.println("Kurs: "+kurs.getKursAdi());
			for(Konu konu : kurs.getKonular()) {
				System.out.println("\t\t-"+konu.getKonuBasligi());
			}
		}
		
		
		/*Kurs kurs = new Kurs("JEE", 600, ogr);
		kurs.addKonu(new Konu("Basics", "Kontroller,Döngüler"));
		kurs.addKonu(new Konu("OOP", "Inheritance,Polymorphizm"));
		kurs.addKonu(new Konu("Threads", "Thread,Runnable"));
		session.save(kurs);//kursu save ederken kursa baðlý bütün konularýda save ediyor(mappingden dolayý)
        */
		
		session.getTransaction().commit();
		session.close();
		//System.out.println("Kurs: "+ kurs);
		//System.out.println(kurs.getKonular());
	}
}
