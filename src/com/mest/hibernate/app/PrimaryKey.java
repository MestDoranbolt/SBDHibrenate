package com.mest.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mest.hibernate.app.entity.Pracownik;

public class PrimaryKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create Session Factory
		
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pracownik.class).buildSessionFactory();
				
				Session session = factory.getCurrentSession();
			
				try {
					//3 nowe pracowniki
					System.out.println("Creating 3 obj...");
					Pracownik pracowniktemp1 = new Pracownik("Jan","Kowalski",java.sql.Date.valueOf("2017-02-15"),1200,"sprzedawca","null");
					Pracownik pracowniktemp2 = new Pracownik("Micha³","Strach",java.sql.Date.valueOf("2017-03-18"),2100,"opiekun","null");
					Pracownik pracowniktemp3 = new Pracownik("Marian","Kozio³",java.sql.Date.valueOf("2017-01-13"),4000,"treser","super trener 2010");

					session.beginTransaction();
					System.out.println("Saving the pracowniki...");
					session.save(pracowniktemp1);
					session.save(pracowniktemp2);
					session.save(pracowniktemp3);
					session.getTransaction().commit();
					System.out.println("Done");
				}finally {
				factory.close();	
				}
				
	}

}
