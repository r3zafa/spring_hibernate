package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.one2oneBi.demo.entity.Course;
import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

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
			
			int id1 = 13;

		
			// step 3 - start a transaction
			session.beginTransaction();


			// get a course
			Course tempCourse = session.get(Course.class, id1);

			
			// delete course
			System.out.println("deleting Course: " + tempCourse.getTitle() + "\n\n");
			
			session.delete(tempCourse);
			System.out.println("\n\ndeleted!\n\n");
			
			
			
			
			// step 4 - commit transaction
			session.getTransaction().commit();
			System.out.println("\n\ndone!\n\n");


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
