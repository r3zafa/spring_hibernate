package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.one2oneBi.demo.entity.Course;
import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;
import de.hibernate.one2oneBi.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// step 1 - create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// step 2 - create session
		Session session = factory.getCurrentSession();
		
		try {
			
		
			// step 3 - start a transaction
			session.beginTransaction();
			
			
			// get the course
			int courseId = 10;
			
			Course course1 = session.get(Course.class, courseId);
			// print the course
			System.out.println("\n\n" + course1 + "\n\n");
			
			// deleting course
			System.out.println("\n\n" + "deleting course ..." + "\n\n");
			
			session.delete(course1);
			
			System.out.println("\n\n" + "deleted!" + "\n\n");

			
			
			// step 4 - commit transaction
			session.getTransaction().commit();
			System.out.println("done!");


		}		
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			session.close();
			// step 5 - close factory			
			factory.close();

		} 
	}

}
