package com.mest.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mest.hibernate.app.entity.Pracownik;

public class CreatePracownik {

	public static void main(String[] args) {
		// Create Session Factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	       
        Session session = factory.getCurrentSession();
        session.beginTransaction();
       
        Pracownik pracownik = new Pracownik();
        pracownik.setImie("Karolina");
        pracownik.setNazwisko("Sêtorek");
        pracownik.setDataZatrudnienia(java.sql.Date.valueOf("2017-09-25"));
        pracownik.setStanowisko("Kierownik");
        pracownik.setPensja(3000);
        pracownik.setKwalifikacje("blablabla");
        session.save(pracownik);
        session.getTransaction().commit();
        factory.close();
       
            System.out.println(pracownik.getImie() + "\t" + pracownik.getNazwisko() + "\t" + pracownik.getStanowisko());
}
}
