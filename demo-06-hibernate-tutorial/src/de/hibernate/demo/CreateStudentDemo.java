package de.hibernate.demo;

import java.awt.print.PrinterIOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import de.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//use the session object to save java object
			// create a student object
			System.out.println("\n#################################\n");
			System.out.println("Creating new student object ...\n");
			Student tempStudent = new Student("reza","fa","r3za@gmail.com");

			// start a transaction
			System.out.println("starting transaction ...\n");
			session.beginTransaction();
			// save the student object
			System.out.println("session started, saving object ...\n");
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("object is saved in db, closing factory...\n");
			
		} finally {
			factory.close();
			System.out.println("factory is closed, done!\n");
			System.out.println("\n#################################\n");

		} 
	}

}
