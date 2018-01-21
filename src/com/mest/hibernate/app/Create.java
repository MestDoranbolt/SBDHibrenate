package com.mest.hibernate.app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mest.hibernate.app.entity.Cennik;
import com.mest.hibernate.app.entity.Pracownik;
import com.mest.hibernate.app.entity.Zwierze;

public class Create {

	public static void createPrac(SessionFactory factory, String opt) {
		// Create Session Factory
		// SessionFactory factory = new
		// Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.getCurrentSession();

		System.out.println(
				"Podaj dane pracownika w kolejnoœci imie nazwisko data_zatrudnienia pensja stanowisko (np. Karol Wojciula 2018-01-10 3000 opiekun");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Creating new obj...");
		// 1System.out.println(scanner.next() + scanner.next() + scanner.next() +
		// scanner.next() + scanner.next());
		Pracownik pracowniktemp = new Pracownik(scanner.next(), scanner.next(), java.sql.Date.valueOf(scanner.next()),
				Integer.parseInt(scanner.next()), scanner.next(), "null");
		// java.sql.Date.valueOf("2017-09-30"), 3000,
		// "opiekun", "null");
		session.beginTransaction();
		System.out.println("Saving the pracownik...");
		System.out.println(pracowniktemp);
		session.save(pracowniktemp);
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
		QueryList.lista(factory, "Pracownik");
		System.out.println("Wybierz pracownika do opieki nad zwierzêciem");
		Set<Pracownik> pracownik = new HashSet<Pracownik>();
		pracownik.add(Read.readPrac(factory, scanner.nextInt()));
		System.out.println("Podaj dane zwierzecia w kolejnoœci gatunek plec imie potomstwo");
		Zwierze tempzwierze = new Zwierze(scanner.next(), scanner.next(), scanner.next(),
				Integer.parseInt(scanner.next()));
		tempzwierze.setPracowniks(pracownik);
		session = factory.getCurrentSession();
		
		// java.sql.Date.valueOf("2017-09-30"), 3000,
		// "opiekun", "null");
		session.beginTransaction();
		System.out.println("Saving the zwierze");
		// System.out.println();
		session.save(tempzwierze);
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