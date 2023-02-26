package de.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String dbName = "table_student_tracker";
		String jdbcUrl = "jdbc:mysql://localhost:3306/table_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "reza";
		String pass = "1990";
		
		try {
			System.out.println("Connecting to DB" + dbName);
			Connection myConnection =
					DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful");
			
			
		} catch(Exception exc) {
			exc.printStackTrace();
		}
		
		
		
		
		
		
	}

}
