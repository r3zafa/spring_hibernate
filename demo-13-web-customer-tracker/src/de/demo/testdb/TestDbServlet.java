package de.demo.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// setup connection variables
		String user = "springmvc";
		String pass = "springmvc";
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		// get connection to database
		try {

			PrintWriter out = response.getWriter();
			
			out.println("Connecting to Db" + jdbcUrl);
			
			Class.forName(driver);
			Connection theConnection = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("connection successful: " + theConnection);
			
			theConnection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
