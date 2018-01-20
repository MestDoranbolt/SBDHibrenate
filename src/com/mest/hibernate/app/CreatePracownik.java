package com.mest.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mest.hibernate.app.entity.Zmiany;

public class CreatePracownik {

	public static void main(String[] args) {
		// Create Session Factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

		}
		finally {
			factory.close();
		}

	}

}
