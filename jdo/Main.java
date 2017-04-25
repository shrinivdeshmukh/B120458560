
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
	
	public static void main(String[] args) {
		
		Student s;
		EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("$objectdb/db/st.odb");
	    EntityManager em = emf.createEntityManager();
	        
	    em.getTransaction().begin();
	    s = new Student(407001, "Aayush", 67);
	    em.persist(s);
	    s = new Student(407002, "Tapan", 75);
	    em.persist(s);
	    s = new Student(407003, "Askhay", 70);
	    em.persist(s);
	    s = new Student(407014, "Swapnil", 71);
	    em.persist(s);
	    s = new Student(407028, "Prasann", 66);
	    em.persist(s);
	    s = new Student(407030, "Ashwin", 65);
	    em.persist(s);
	    s = new Student(407030, "kishor", 65);
	    em.persist(s);
	    
	    em.getTransaction().commit();
	    
	    Query q1 = em.createQuery("SELECT COUNT(s) FROM Student s");
	    Query q2 = em.createQuery("select name from Student");
	    Query q3 = em.createQuery("select max(aggregate) from Student ");
	    Query q4 = em.createQuery("select name from Student where aggregate = 66 ");
	    //Query q3 = em.createQuery("select * from Student s");
        System.out.println("Total Students: " + q1.getSingleResult());
       //System.out.println("Student Name: " + s.toString());
        System.out.println("Total Students: " + q2.getResultList());
      //  System.out.println("Students details: " + q3.getResultList());
        System.out.println("Max marks of Students: " + q3.getSingleResult());
        System.out.println("Name of student whose Aggregate is 66: " + q4.getSingleResult());
}}
