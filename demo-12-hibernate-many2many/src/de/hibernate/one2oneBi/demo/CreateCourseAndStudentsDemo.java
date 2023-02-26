package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.one2oneBi.demo.entity.Course;
import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;
import de.hibernate.one2oneBi.demo.entity.Review;
import de.hibernate.one2oneBi.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//create a course
			Course tempCourse = new Course("Sport 2");			
			System.out.println("\n\nsaving course ...\n");
			session.save(tempCourse);

			// create students
			Student reza = new Student("reza","F","r3@gm.de");
			Student timo = new Student("timo","T","t3@gm.de");
			Student lina = new Student("lina","L","l3@gm.de");
			System.out.println("\n\nsaving students ...\n");
			session.save(reza);
			session.save(timo);
			session.save(lina);
			// save the Course ... and leverage the cascade.all :)
						
			
			
			System.out.println("\nadding students to course ...");
			// add some students
			tempCourse.addStudent(reza);
			tempCourse.addStudent(timo);
			tempCourse.addStudent(lina);
			

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
