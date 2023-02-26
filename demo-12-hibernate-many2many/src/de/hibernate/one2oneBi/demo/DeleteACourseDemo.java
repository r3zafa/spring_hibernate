package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.one2oneBi.demo.entity.Course;
import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;
import de.hibernate.one2oneBi.demo.entity.Review;
import de.hibernate.one2oneBi.demo.entity.Student;

public class DeleteACourseDemo {

	public static void main(String[] args) {

		// step 1 - create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// step 2 - create session
		Session session = factory.getCurrentSession();
		
		try {
			
		
			// step 3 - start a transaction
			session.beginTransaction();
			
			//create a course OR load another course
			int courseId = 12;
			Course tempCourse = session.get(Course.class, courseId);			
			System.out.println("\n\ncourse loaded!\n" + tempCourse);


			
			System.out.println("\ndeleting course ...");
			session.delete(tempCourse);
			

			// step 4 - commit transaction
			System.out.println("commit...");
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
