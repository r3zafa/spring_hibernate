package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.one2oneBi.demo.entity.Course;
import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// step 1 - create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// step 2 - create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int id1 = 1;

		
			// step 3 - start a transaction
			session.beginTransaction();
			
			// ** 1 load the instructor
			Instructor instructor1 = session.get(Instructor.class, id1);


			// ** 2 print out instructors and related courses
			System.out.println("\n----- Instructor: " + instructor1 + "\n\n------");
			
			
			// *** option 1 : lazy loading get method while the session is still open
			System.out.println("\n----- Courses:\n" + instructor1.getCourses() + "\n\n------");
		
			
			// step 4 - commit transaction
			session.getTransaction().commit();
			System.out.println("done!");

			

		}	
		
		catch (Exception e) {
			e.printStackTrace();
		} 
		
		finally {
			
			session.close();
			// step 5 - close factory			
			factory.close();

		} 
	}

}
