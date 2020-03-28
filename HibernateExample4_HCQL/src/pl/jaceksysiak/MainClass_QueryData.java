package pl.jaceksysiak;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import pl.jaceksysiak.entity.Employee;

public class MainClass_QueryData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
		//-----------Employee	
			Employee tmpEmployee=new Employee("Jack", 1200, 55);

			// start a transaction
			session.beginTransaction();
			
			// save the courses
			session.save(tmpEmployee);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			
			// add clean up code
			session.close();			
			factory.close();
		}
	}

}
