package com.mest.hibernate.app;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mest.hibernate.app.entity.Pracownik;
import com.mest.hibernate.app.entity.Zmiany;

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
		}