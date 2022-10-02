package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class Test {

	public static void main(String [] args) {
		System.out.println("connectig to database.....");
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.buildSessionFactory();
		Session session = null;
		Teacher t1= new Teacher("shalini","jaiswal","shalini@org.com");
		Teacher t2= new Teacher("vikas","jaiswal","vikasjaiswal@org.com");
		Teacher t3= new Teacher("anmil","jaiswal","anmiljaiswal@org.com");
		Teacher t4= new Teacher("aryan","jaiswal","aryanjaiswal@org.com");
		
		Transaction tx=null;
		
		//List<Teacher> teachers=null;
		try {
			session = factory.getCurrentSession();
			tx=session.beginTransaction();
			
			// to save the data into database
			//session.save(t1)
			//session.save(t2)
			//session.save(t3)
			//session.save(t4)
			
			
			// to read a single data from database
			//Teacher teacher=session.get(Teacher.class, 2);
			//System.out.println("teacher "+teacher);
			
			//to read the  whole data from database
			//teachers=session.createQuery("from Teacher").list();
			
			//to read the data based on name
			//teachers=session.createQuery("from Teacher t where t.f_name='shalini'").list();
			
			
			//to read the data base on eamil
			//teachers=session.createQuery("from Teacher t whre t.email like '@org.com'")list();
			
			//updating data using setter
			Teacher teachers =session.get(Teacher.class,2);
			//teachers.setF_name("Anmol");
			
			
			//updating values using createQuery and executeupdate
			session.createQuery("update Teacher set email='anmoljaiswl@orl.com' where f_name='Anmol'").executeUpdate(); 
					  
			
			tx.commit();
		}
		catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
			tx.rollback();
		}
		finally{	
			session.close();
		}
		//reading and displaying all data from database;
		//for(Teacher teacher:teachers)
			//System.out.println(teacher);
	}
}
