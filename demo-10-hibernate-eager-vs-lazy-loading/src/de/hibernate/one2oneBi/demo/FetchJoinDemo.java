package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import de.hibernate.one2oneBi.demo.entity.Course;
import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			// step 3 - start a transaction
			session.beginTransaction();
			
			
			int theId = 1;

			// *** option 2 : Hibernate query with HQL
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theInstructorId", 
					Instructor.class);
			
			// *** set parameter on query
			query.setParameter("theInstructorId", theId);
			
			
			// *** execute query and get instructor
			
			Instructor tempInstructor = query.getSingleResult();
			
			// *** print out instructor
			
			System.out.println("\n\n-----" + tempInstructor + "-----\n\n");
				
			// step 4 - commit transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("session closed!\n\n");
			
			
			System.out.println(tempInstructor.getCourses());
			
			
			
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
