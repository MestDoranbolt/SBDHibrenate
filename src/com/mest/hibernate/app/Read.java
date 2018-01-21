package com.mest.hibernate.app;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mest.hibernate.app.entity.Pracownik;

public class Read {

	public static Pracownik readPrac(SessionFactory factory, int id) {
		
		// Create Session Factory
		
		//SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pracownik.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Scanner in = new Scanner(System.in);
		
			//szukanie pk
			//System.out.println("podaj id: ");
			//new session / start transaction
			session= factory.getCurrentSession();
			session.beginTransaction();
			Pracownik prac = session.get(Pracownik.class, id);
			System.out.println(prac.getZwierzes());
			//retrieve student based on the id: primary key
//			System.out.println("\nGetting student with id:"+ pracowniktemp.getIdPracownika());
//			Pracownik myPracownik = session.get(Pracownik.class, pracowniktemp.getIdPracownika());
//			System.out.println("Get complete"+ myPracownik);
			//commit
			session.getTransaction().commit();
			System.out.println("Done");
			return prac;
		}
}