package de.hibernate.demo;

import java.awt.print.PrinterIOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import de.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
//			int StudentId = 9 ;

//			System.out.println("\n################delete#################\n");
//			System.out.println("\n#################with loading object ################\n");
//
//			session.beginTransaction();
//			Student myStudent1 = session.get(Student.class, StudentId);
//			
//			System.out.println("\n#### before deleting:\n");
//			// delete student values
//			session.delete(myStudent1);
//			session.getTransaction().commit();
//			System.out.println("\n#### deleted!\n");

			
			System.out.println("\n############### delete ##################");
			System.out.println("\n############### with query ##############\n");
			
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("delete all student with lastName of XXX");
			session.createQuery("delete from Student where lastName='rad'").executeUpdate();

			
			session.getTransaction().commit();
			
			System.out.println("\ndone!\n");
			
			
		} finally {
			factory.close();
			System.out.println("factory is closed, done!\n");
			System.out.println("\n#################################\n");

		} 
	}

}
