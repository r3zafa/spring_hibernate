package de.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJdbc {

	public static void main(String[] args) {

		String dbName = "hb-many2many";
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-many2many?useSSL=false&serverTimezone=UTC";
		String user = "reza";
		String pass = "1990";
		
		try {
			System.out.println("\nConnecting to DB #### " + dbName + " ####\n");
			Connection myConnection =
					DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful\n");
			
			
		} catch(Exception exc) {
			exc.printStackTrace();
		}
		
		
		
	}

}
