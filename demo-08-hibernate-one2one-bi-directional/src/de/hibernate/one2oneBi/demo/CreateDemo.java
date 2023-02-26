package de.hibernate.one2oneBi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.one2oneBi.demo.entity.Instructor;
import de.hibernate.one2oneBi.demo.entity.InstructorDetail;

public class CreateDemo {

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
			
			
			// ** 1 create the objects
			Instructor tempInstructor = new Instructor(
					"demo","demo","demo@gg.de");
			
			InstructorDetail tempIstructorDetail = new InstructorDetail(
					"yotube.com/demo","anime");
			// ** 2 associate the objects
			
			tempInstructor.setInstructorDetail(tempIstructorDetail);
			
			// ** 3 save the instructor	
			// note: this will also save instructorDetail 
			// because of cascadeType.all method
			System.out.println("saving ... \n" + tempInstructor.toString() +"\n\nAND\n\n" + tempIstructorDetail.toString() + "\n");
			session.save(tempInstructor);
			
			
			
			
			// step 4 - commit transaction
			session.getTransaction().commit();
			System.out.println("done!");


		} finally {
			

			// step 5 - close factory			
			factory.close();

		} 
	}

}
