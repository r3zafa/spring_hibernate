package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			
			// ** get instructor detail object
			int theId = 3;
			InstructorDetail temp = session.get(InstructorDetail.class, theId);
			// ** print the object
			System.out.println("\ninstructorDetail: \n" + temp);
			// ** print the associated instructor
			System.out.println("\nassociated instructor: \n" + temp.getInstructor());

			
			// **** remove the associated object reference
			// **** break bidirectional link
			System.out.println("\nbreak bidirectional link...");
			temp.getInstructor().setInstructorDetail(null);
			System.out.println("done!\n");

			
			// ** delete instructor detail
			System.out.println("\ndeleting ...\n");
			session.delete(temp);
			
			
			
			
			
			// step 4 - commit transaction
			session.getTransaction().commit();
			
			System.out.println("\ndone!\n");
			
			

		} 
		// *** 1 exception handling
		catch (Exception e) {
			e.printStackTrace();
		} 
		
		finally {
			// *** 2 handle connection leak issue
			session.close();
			
			// step 5 - close factory			
			factory.close();

		} 
	}

}
