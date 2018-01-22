package com.mest.hibernate.app;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mest.hibernate.app.entity.Cennik;
import com.mest.hibernate.app.entity.Pracownik;
import com.mest.hibernate.app.entity.Wybieg;

public class Delete {

	public static void deletePrac(SessionFactory factory) {
		// Create Session Factory
		
		//SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pracownik.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj id od usuniecia pracownika");
		int id = scanner.nextInt();
			//new session / start transaction
			session= factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id:"+ id);
			Pracownik myPracownik = session.get(Pracownik.class, id);
			session.delete(myPracownik);
			
			//session.createQuery("delete from Student where id=4").executeUpdate();
			//commit
			session.getTransaction().commit();
			System.out.println("Done");
		}
	public static void deleteWyb(SessionFactory factory) {
		// Create Session Factory
		
		//SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pracownik.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj id od usuniecia pracownika");
		int id = scanner.nextInt();
			//new session / start transaction
			session= factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id:"+ id);
			Wybieg myWybieg = session.get(Wybieg.class, id);
			session.delete(myWybieg);
			
			//session.createQuery("delete from Student where id=4").executeUpdate();
			//commit
			session.getTransaction().commit();
			System.out.println("Done");
		}
	public static void deleteCen(SessionFactory factory) {
		// Create Session Factory
		
		//SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pracownik.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj id od usuniecia produktu");
		int id = scanner.nextInt();
			//new session / start transaction
			session= factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id: primary key
//			System.out.println("\nGetting  with id:"+ id);
			Cennik cennik = session.get(Cennik.class, id);
			session.delete(cennik);
			
			//session.createQuery("delete from Student where id=4").executeUpdate();
			//commit
			session.getTransaction().commit();
			System.out.println("Done");
		}
		}