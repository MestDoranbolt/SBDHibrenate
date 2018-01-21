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

public class QueryList {

	public static void lista(SessionFactory factory, String opt) {

		Session session = factory.getCurrentSession();
		// Create Session Factory
		session.beginTransaction();

		// query
		List list = session.createQuery("from " + opt).list();
		// display
		for (Object temppracownik : list) {
			System.out.println(temppracownik);
		}
		// displayPracownikow(list);
		session.getTransaction().commit();
		if(session.getTransaction().isActive())
			System.out.println("Done");
	}
}