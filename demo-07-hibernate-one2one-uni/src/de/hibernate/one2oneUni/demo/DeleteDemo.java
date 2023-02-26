package de.hibernate.one2oneUni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.demo.entity.Instructor;
import de.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// step 1 - create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// step 2 - create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// step 3 - start a transaction
			session.beginTransaction();
			
			
			// ** 1 get instructor by primary key
			int theId = 1;
			Instructor theInstructor = session.get(Instructor.class, theId);
			System.out.println("\nfound instructor:\n\n" + theInstructor.toString() + "\n");
			// ** 2 delete the instructor
			// note: will also delete instructordetail object
			if (theInstructor != null) {
				System.out.println("\n> Deleting instructor\n\n" + theInstructor.toString() + "\n");
				session.delete(theInstructor);
			} 
						
			// step 4 - commit transaction
			session.getTransaction().commit();
			System.out.println("done!\n");


		} finally {
			

			// step 5 - close factory			
			factory.close();

		} 
	}

}
