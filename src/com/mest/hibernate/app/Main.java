package com.mest.hibernate.app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mest.hibernate.app.entity.Pracownik;
import com.mest.hibernate.app.entity.Zwierze;

public class Main {

	public static void main(String[] args) {
		//session.beginTransaction();
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Scanner in = new Scanner(System.in);
		Session session;
		session = factory.getCurrentSession();
		int x = 0;
		while (true) {
			// if (x == 0) {
			//
			// Window.menu();
			// x = 1in.nextInt();
			// }
			// System.out.println(x);
			// if(x == 1) {
			// QueryPracownik2.listapracownikow(session);
			// x = 11;
			// }
			switch (x) {
			case 1:
				// QueryPracownik2.listapracownikow(session, "Pracownik");
				QueryList.lista(factory, "Pracownik");

				Window.OptPrac();
				x = in.nextInt();
				break;
			case 11:
				Window.createPrac();
				Create.createPrac(factory, "Pracownik");
				x=in.nextInt();
				break;
			case 12:
				System.out.println("Podaj id pracownika");
				Pracownik prac = Read.readPrac(factory, in.nextInt());
//				Set<Zwierze> zwierze = prac.getZwierzes();
				if(prac.getStanowisko().equals("Treser")) {
					session = factory.getCurrentSession();
					System.out.println("Pracownik "+prac.getImie()+" "+prac.getNazwisko()+" jest Treserem i tresuje "+prac.getZwierzes());
				}
				if(prac.getStanowisko().equals("Opiekun")) {
					System.out.println("Pracownik "+prac.getImie()+" "+prac.getNazwisko()+" jest Opiekunem i opiekuje sie wybiegami "+prac.getWybiegs());
				}
//				System.out.println(Read.readPrac(factory, in.nextInt()).getZwierzes());
				System.out.println("wpisz 0 aby powróciæ");
				x = in.nextInt();
				break;
			case 13:
				Update.updatePrac(factory);
				x=in.nextInt();
				break;
			case 14:
				Delete.deletePrac(factory);
				break;
			case 2:
				QueryList.lista(factory, "Cennik");
				
				Window.OptCennik();
				x=in.nextInt();
				break;
			case 21:
				Create.createCennik(factory, "xD");
				break;
			case 22:
				Delete.deleteCen(factory);
				break;
			case 3:
				Window.OptZwierze();
				x=in.nextInt();
				break;
			case 31:
				Create.createZwierze(factory);
				break;
			case 4:
				Window.OptWybieg();
				x=in.nextInt();
				break;
			case 41:
				Create.createWybieg(factory);
				System.out.println("wpisz 0 aby powróciæ");
				x = in.nextInt();
				break;
			case 42:
				Delete.deleteWyb(factory);
				break;
			case 5:
				Window.OptZmiany();
				x=in.nextInt();
				break;
			case 51:
				Create.createZmiana(factory);
				System.out.println("wpisz 0 aby powróciæ");
				x = in.nextInt();
				break;
				
			
			
			default:
				Window.menu();
				x = in.nextInt();
				break;
			}
		}
		// Create(session);

	}

	public static void Create(Session session, Object obj) {
		System.out.println("Creating new obj...");
		session.save(obj);
		session.getTransaction().commit();
		System.out.println("Done");
	}

	public Pracownik CreatePrac(String imie, String nazwisko, String data, int pensja, String stanowisko,
			String kwalifikacje) {
		System.out.println("Create Pracownik");
		Pracownik pracowniktemp = new Pracownik(imie, nazwisko, java.sql.Date.valueOf(data), pensja, stanowisko,
				kwalifikacje);
		return pracowniktemp;
		}
	

}
