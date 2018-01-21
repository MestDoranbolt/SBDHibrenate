package com.mest.hibernate.app;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mest.hibernate.app.entity.Pracownik;
import com.mest.hibernate.app.entity.Zmiany;

public class UpdatePracownik {

	public static void main(String[] args) {
		// Create Session Factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pracownik.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
	
		try {
			int pracownikId = 2;
			
			//new session / start transaction
			session= factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id:"+ pracownikId);
			Pracownik myPracownik = session.get(Pracownik.class, pracownikId);
			System.out.println("Updating");
			myPracownik.setImie("Olga");
			myPracownik.setNazwisko("Labondz");
			myPracownik.setPensja(1100);
			//commit
			session.getTransaction().commit();
			
			
			
			System.out.println("Done");
		}finally {
		factory.close();	
		}
		}
		}