package com.mest.hibernate.app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mest.hibernate.app.entity.Cennik;
import com.mest.hibernate.app.entity.Pracownik;
import com.mest.hibernate.app.entity.Wybieg;
import com.mest.hibernate.app.entity.Zmiany;
import com.mest.hibernate.app.entity.Zwierze;

public class Create {

	public static void createPrac(SessionFactory factory, String opt) {
		// Create Session Factory
		// SessionFactory factory = new
		// Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.getCurrentSession();

		System.out.println(
				"Podaj dane pracownika w kolejnoœci imie nazwisko data_zatrudnienia pensja stanowisko(Treser, Opiekun) (np. Karol Wojciula 2018-01-10 3000 opiekun");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Creating new obj...");
		// 1System.out.println(scanner.next() + scanner.next() + scanner.next() +
		// scanner.next() + scanner.next());
		Pracownik pracowniktemp = new Pracownik(scanner.next(), scanner.next(), java.sql.Date.valueOf(scanner.next()),
				Integer.parseInt(scanner.next()), scanner.next(), "null");
		String stanowisko = pracowniktemp.getStanowisko();
		switch (stanowisko) {
		case "Treser":
			QueryList.lista(factory, "Zwierze");

			System.out.println("Wybierz zwierze do tresury");
			Zwierze zwierze = Read.readZwie(factory, scanner.nextInt());
			Set<Zwierze> hashzezwierzeciem = new HashSet<Zwierze>();
			hashzezwierzeciem.add(zwierze);
			pracowniktemp.setZwierzes(hashzezwierzeciem);
			session = factory.getCurrentSession();
			break;
		case "Opiekun":
			QueryList.lista(factory, "Wybieg");

			System.out.println("Wybierz wybieg do opieki");
			Wybieg wybieg = Read.readWyb(factory, scanner.nextInt());
			Set<Wybieg> hashzwybiegiem= new HashSet<Wybieg>();
			hashzwybiegiem.add(wybieg);
			pracowniktemp.setWybiegs(hashzwybiegiem);
			session = factory.getCurrentSession();
			

		default:
			break;
		}
		// java.sql.Date.valueOf("2017-09-30"), 3000,
		// "opiekun", "null");
		
		session.beginTransaction();
		System.out.println("Saving the pracownik...");
		System.out.println(pracowniktemp);
		session.save(pracowniktemp);
//		if(stanowisko=="Opiekun")
//			session.update(wybieg);
		session.getTransaction().commit();
		System.out.println("Done");

	}

	public static void createZwierze(SessionFactory factory) {
		// Create Session Factory
		// SessionFactory factory = new
		// Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.getCurrentSession();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Creating new obj...");
		// 1System.out.println(scanner.next() + scanner.next() + scanner.next() +
		// scanner.next() + scanner.next());
		// Pracownik pracowniktemp = new Pracownik(scanner.next(), scanner.next(),
		// java.sql.Date.valueOf(scanner.next()), Integer.parseInt(scanner.next()),
		// scanner.next(), "null");
		System.out.println("Podaj dane zwierzecia w kolejnoœci gatunek plec imie iloœæ potomstwa");
		Zwierze tempzwierze = new Zwierze(scanner.next(), scanner.next(), scanner.next(),
				Integer.parseInt(scanner.next()));
		           
		
		QueryList.lista(factory, "Wybieg");

		System.out.println("Wybierz wybieg dla zwierzêcia");
		Wybieg wybieg = Read.readWyb(factory, scanner.nextInt());
		Set<Wybieg> hashzwybiegiem = new HashSet<Wybieg>();
		hashzwybiegiem.add(wybieg);
		tempzwierze.setWybiegs(hashzwybiegiem);
		session = factory.getCurrentSession();
		
		QueryList.lista(factory, "Pracownik");

		System.out.println("Wybierz pracownika do opieki nad zwierzêciem");
		Pracownik pracownik = Read.readPrac(factory, scanner.nextInt());
		Set<Pracownik> hashzezwierzeciem = new HashSet<Pracownik>();
		hashzezwierzeciem.add(pracownik);
		tempzwierze.setPracowniks(hashzezwierzeciem);
		session = factory.getCurrentSession();
		
		
		session.beginTransaction();
		System.out.println("Saving the wybieg");
		// System.out.println();
		session.save(tempzwierze);
		session.update(pracownik);
		session.flush();
		session.getTransaction().commit();
		System.out.println("Done");
	}

	public static void createWybieg(SessionFactory factory) {
		// Create Session Factory
		// SessionFactory factory = new
		// Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.getCurrentSession();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Creating new obj...");
		System.out.println("Podaj dane wybiegu w kolejnoœci: temperatura sektor powierzchnia");
		Wybieg tempwybieg = new Wybieg(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),
				scanner.next());
		QueryList.lista(factory, "Pracownik");
		System.out.println("Wybierz pracownika do wybiegu");
		Pracownik pracownik = Read.readPracW(factory, scanner.nextInt());
		Set<Pracownik> lol1 = new HashSet<Pracownik>();
		lol1.add(pracownik);
		tempwybieg.setPracowniks(lol1);
		QueryList.lista(factory, "Zwierze");
		System.out.println("Wybierz zwierze do wybiegu");
		Zwierze zwierze = Read.readZwie(factory, scanner.nextInt());
		Set<Wybieg> hashzwybiegiem = new HashSet<Wybieg>();
		hashzwybiegiem.add(tempwybieg);
		zwierze.setWybiegs(hashzwybiegiem);

		

		session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("Saving the wybieg");
		// System.out.println();
		session.save(tempwybieg);
		session.update(zwierze);
		// session.update(pracownik);
		session.flush();
		session.getTransaction().commit();
		System.out.println("Done");
	}

	public static void createZmiana(SessionFactory factory) {
		// Create Session Factory
		// SessionFactory factory = new
		// Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.getCurrentSession();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Creating new obj...");
		System.out.println("Podaj dane zmiany w kolejnoœci: godzina_od godzina_do");
		Zmiany tempzmiana = new Zmiany(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
		session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("Saving the zmiana");
		// System.out.println();
		session.save(tempzmiana);
		session.getTransaction().commit();
		System.out.println("Done");
	}

	public static void createCennik(SessionFactory factory, String opt) {
		// Create Session Factory
		// SessionFactory factory = new
		// Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.getCurrentSession();

		System.out.println("Podaj dane produktu w kolejnoœci nazwa cena");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Creating new obj...");
		Cennik cenniktemp = new Cennik(scanner.next(), Integer.parseInt(scanner.next()), "null");
		session.beginTransaction();
		System.out.println("Saving the produkt");
		// System.out.println();
		session.save(cenniktemp);
		session.getTransaction().commit();
		System.out.println("Done");
	}

}