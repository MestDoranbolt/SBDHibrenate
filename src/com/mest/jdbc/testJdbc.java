package com.mest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://kazimierz.bialystok.pl:3306/ministrant_SBD";
		String user = "ministrant_SBD";
		String pass = "sbd12345678";
		try {
			System.out.println("Connecting to database");
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection success");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
