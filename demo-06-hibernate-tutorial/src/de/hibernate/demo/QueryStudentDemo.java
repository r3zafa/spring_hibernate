package de.hibernate.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {


		
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();


				try {
					session.beginTransaction();
				
					// query students
					System.out.println("\n#################################");
					System.out.println("All Students");
					System.out.println("#################################\n");
					List<Student> theStudents = session.createQuery("from Student").getResultList();
					//display students
					displayStudents(theStudents);
				
					
					
					// query students: lastName:"XXX"
					System.out.println("\n#################################");
					System.out.println("Filtered with lastName");
					System.out.println("#################################\n");
					List<Student> filteredStudent1 = session.createQuery("from Student s where s.lastName='fa3'").getResultList();
					//display students filtered
					displayStudents(filteredStudent1);
					
					
					
					// query student with lastName="XXX" OR firstName="XXX"
					System.out.println("\n#################################");
					System.out.println("Filtered with lastName OR firstName");
					System.out.println("#################################\n");
					List<Student> filteredStudent2 = 
							session.createQuery("from Student s where s.lastName='fa3' OR s.firstName='reza2'").getResultList();
					//display students filtered
					displayStudents(filteredStudent2);
					
					
					
					// query student with lastName="XXX" AND firstName="XXX"
					System.out.println("\n#################################");
					System.out.println("Filtered with lastName AND firstName");
					System.out.println("#################################\n");
					List<Student> filteredStudent3 = session.createQuery("from Student s where "
							+ "s.lastName='fa3' AND s.firstName='reza3'").getResultList();
					//display students filtered
					displayStudents(filteredStudent3);
					
					
					
					
					// query student with email like "%XXX.XX" suffix
					System.out.println("\n#################################");
					System.out.println("Filtered with email %suffix ");
					System.out.println("#################################\n");
					List<Student> filteredStudent4 = session.createQuery("from Student s where "
							+ "s.email LIKE '%gmail.de'").getResultList();
					//display students filtered
					displayStudents(filteredStudent4);	
					
					
					
					
					
					
					
					
					
					System.out.println("\n#################################\n");
					session.getTransaction().commit();			

					
				}
				finally {
					factory.close();
 
				} 

		
		
		
		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		int index = 0;
		for (Student tempStudent : theStudents) {
			System.out.println("\n("+ (index++) + "):\n" + tempStudent);
		}
	}

}
