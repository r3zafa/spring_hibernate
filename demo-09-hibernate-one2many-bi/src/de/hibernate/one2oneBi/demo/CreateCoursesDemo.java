package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.one2oneBi.demo.entity.Course;
import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			int idOne = 3;
		
			// step 3 - start a transaction
			session.beginTransaction();
			
			// ** 1 load the instructor
			Instructor instructorOne = session.get(Instructor.class, idOne);

			
			// ** 2 create some course objects

			Course theCourse1 = new Course("PC Building 3");
			Course theCourse2 = new Course("Data Mining 3");
			Course theCourse3 = new Course("Computer vision 3");

			// ** 3 add courses to instructor
			instructorOne.add(theCourse1);
			instructorOne.add(theCourse2);
			instructorOne.add(theCourse3);
			

			// ** 4 save the courses
			session.save(theCourse1);
			session.save(theCourse2);
			session.save(theCourse3);
			
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
