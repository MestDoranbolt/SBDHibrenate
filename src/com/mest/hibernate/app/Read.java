package com.mest.hibernate.app;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mest.hibernate.app.entity.Pracownik;
import com.mest.hibernate.app.entity.Wybieg;
import com.mest.hibernate.app.entity.Zwierze;

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
//			System.out.println(prac.getZwierzes());
			//retrieve student based on the id: primary key
//			System.out.println("\nGetting student with id:"+ pracowniktemp.getIdPracownika());
//			Pracownik myPracownik = session.get(Pracownik.class, pracowniktemp.getIdPracownika());
//			System.out.println("Get complete"+ myPracownik);
			//commit
			session.getTransaction().commit();
			System.out.println("Done");
			return prac;
		}
public static Pracownik readPracW(SessionFactory factory, int id) {
		
		// Create Session Factory
		
		//SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pracownik.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Scanner in = new Scanner(System.in);
			session= factory.getCurrentSession();
			session.beginTransaction();
			Pracownik prac = session.get(Pracownik.class, id);
			System.out.println(prac.getWybiegs());
			session.getTransaction().commit();
			System.out.println("Done");
			return prac;
		}
public static Zwierze readZwie(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		Scanner in = new Scanner(System.in);
			session= factory.getCurrentSession();
			session.beginTransaction();
			Zwierze zwie = session.get(Zwierze.class, id);
			System.out.println(zwie.getWybiegs());
			session.getTransaction().commit();
			System.out.println("Done");
			return zwie;
			
		}
public static Wybieg readWyb(SessionFactory factory, int id) {
	
	// Create Session Factory
	
	//SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pracownik.class).buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	Scanner in = new Scanner(System.in);
	
		
		session= factory.getCurrentSession();
		session.beginTransaction();
		Wybieg wyb = session.get(Wybieg.class, id);
		System.out.println(wyb.getZwierzes());
		
		session.getTransaction().commit();
		System.out.println("Done");
		return wyb;}
}