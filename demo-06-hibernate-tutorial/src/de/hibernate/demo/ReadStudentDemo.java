package de.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {


		
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();


				try {
					Student theStudent = new Student("ali","rad","ali@gmail.com");
					session.beginTransaction();
					session.save(theStudent);
					System.out.println("\n#################################\n");
					System.out.println("new student saved. ID:" + theStudent.getId());
					System.out.println("\n#################################\n");

					Student myStudent = 
							session.get(Student.class, theStudent.getId());
					System.out.println("\n#################################\n");
					System.out.println("getting new student with ID:" + 
							theStudent.getId() + "\n" + myStudent);
					System.out.println("\n#################################\n");

					session.getTransaction().commit();			

					
				}
				finally {
					factory.close();
 
				} 

		
		
		
		
		
	}

}
