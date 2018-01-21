package com.mest.hibernate.app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mest.hibernate.app.entity.Pracownik;
import com.mest.hibernate.app.entity.Zwierze;


public class Man {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pracownik.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Zwierze zwierzetemp = new Zwierze("Gatunek", "Meska", "fafik", 1);
		Zwierze zwierzetemp2 = new Zwierze("Masd", "asdasd", "Asdasd", 1);
		Pracownik prac = session.get(Pracownik.class, 1);
		Set
		Set<Zwierze> zwierze = new HashSet<Zwierze>();
		zwierze.add(zwierzetemp);

		Pracownik pracowniktemp3 = new Pracownik("Marian","Kozio³",java.sql.Date.valueOf("2017-01-13"),4000,"treser","super trener 2010");
		
		
		pracowniktemp3.setZwierzes(zwierze);
		session.beginTransaction();
		System.out.println("SAVING");
		session.save(zwierzetemp2);
		session.save(zwierzetemp);
		session.save(pracowniktemp3);
		session.getTransaction().commit();
		System.out.println("Done");
		

	}

}
