package com.mest.hibernate.app;

import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mest.hibernate.app.entity.Pracownik;
import com.mest.hibernate.app.entity.Zwierze;

public class Update {

	public static void updatePrac(SessionFactory factory) {
		// Create Session Factory

		// SessionFactory factory = new
		// Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pracownik.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj id do edycji");
		int id = scanner.nextInt();
		// new session / start transaction''''
		session = factory.getCurrentSession();
		session.beginTransaction();
		// retrieve student based on the id: primary key
//		System.out.println("\nGetting student with id:" 
		Pracownik myPracownik = session.get(Pracownik.class, id);
		session.getTransaction().commit();
		System.out.println("Pracownik jest "+myPracownik.getStanowisko()+"em");
		int i;
		if(myPracownik.getStanowisko().equals("Treser")) {
			System.out.println("Czy chcesz");
			System.out.println("1.Dodaæ zwierze do tresowania");
			System.out.println("2.Usun¹c zwierze do tresowania");
			i = scanner.nextInt();
			switch (i) {
			case 1:
				QueryList.lista(factory, "Zwierze");
				session = factory.getCurrentSession();
				Set<Zwierze> zwierze = myPracownik.getZwierzes();
				System.out.println(myPracownik.getZwierzes());
				System.out.println("Wyierz zwierze do dodania(id)");
				zwierze.add(Read.readZwie(factory, scanner.nextInt()));
				myPracownik.setZwierzes(zwierze);
				break;
			case 2:
				session = factory.getCurrentSession();
				Set<Zwierze> zwierze2 = myPracownik.getZwierzes();
				System.out.println(myPracownik.getZwierzes());
				System.out.println("Wybierz zwierze do usuniecia(id)");
				Zwierze a = (Zwierze) Read.readZwie(factory, scanner.nextInt());
				if(zwierze2.contains(a))
					System.out.println("XD");
				//System.out.println(Read.readZwie(factory, 24));
				System.out.println(zwierze2);
				myPracownik.setZwierzes(zwierze2);
			default:
				break;
			}
			
		}
		if(myPracownik.getStanowisko().equals("Opiekun"))
			i=2;
		session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("Updating");
		session.update(myPracownik);
		// commit
		session.getTransaction().commit();

		System.out.println("Done");
	}
}