package de.hibernate.demo;

import java.awt.print.PrinterIOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import de.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int StudentId = 1;

			System.out.println("\n#################################\n");

			session.beginTransaction();
			Student myStudent1 = session.get(Student.class, StudentId);
			
			System.out.println("\n#### before updating: " + myStudent1.getEmail() +"\n");
			// update student values
			myStudent1.setEmail("rfaraji@frobese.com");
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("\n#### after updating: " + myStudent1.getEmail());
			
			
			System.out.println("\n############### NEW ##################");
			System.out.println("\n############### NEW ##################\n");
			
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Update all student with lastName of XXX");
			session.createQuery("update Student set email='example@frobese.com'"
					+ " where lastName='fa3'").executeUpdate();

			session.getTransaction().commit();
			
			
			
		} finally {
			factory.close();
			System.out.println("factory is closed, done!\n");
			System.out.println("\n#################################\n");

		} 
	}

}
