package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.one2oneBi.demo.entity.Course;
import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;
import de.hibernate.one2oneBi.demo.entity.Review;
import de.hibernate.one2oneBi.demo.entity.Student;

public class DeleteAStudentDemo {

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
			int stdId = 1;
			Student temp = session.get(Student.class, stdId);			
			System.out.println("\n\nstudent loaded!\n" + temp);


			
			System.out.println("\ndeleting student ...");
			session.delete(temp);
			

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
