package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.one2oneBi.demo.entity.Course;
import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			int id2 = 2;
			int id3 = 3;
		
			// step 3 - start a transaction
			session.beginTransaction();
			
			// ** 1 load the instructor
			Instructor instructor1 = session.get(Instructor.class, id1);
			Instructor instructor2 = session.get(Instructor.class, id2);
			Instructor instructor3 = session.get(Instructor.class, id3);

			// ** 2 print out instructors and related courses
			System.out.println("\nInstructor: " + instructor1.getId() + "\n");
			System.out.println("\nCourses:\n\n " + instructor1.getCourses().toString());

			System.out.println("\nInstructor: " + instructor2.getId() + "\n");
			System.out.println("\nCourses:\n\n " + instructor2.getCourses().toString());
			
			System.out.println("\nInstructor: " + instructor3.getId() + "\n");
			System.out.println("\nCourses:\n\n " + instructor3.getCourses().toString());
		
			
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
