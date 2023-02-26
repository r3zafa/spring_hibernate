package de.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			// create 3 student objects
			
			System.out.println("\n#################################\n");
			Student tempStudent1 = new Student("reza1","fa1","r3za1@gmail.com");
			Student tempStudent2 = new Student("reza2","fa2","r3za2@gmail.com");
			Student tempStudent3 = new Student("reza3","fa3","r3za3@gmail.com");
			// start a transaction
			session.beginTransaction();
			// save the students
			System.out.println("saving students ...\n");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit the transaction
			session.getTransaction().commit();			
		} finally {
			factory.close();
			System.out.println("\n#################################\n");

		} 

		
	}

}
