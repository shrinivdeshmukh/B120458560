package ex6;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
	
	public static void main(String[] args) {
		
		Point s;
		EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("$objectdb/db/st.odb");
	    EntityManager em = emf.createEntityManager();
	        
	    em.getTransaction().begin();
	    s = new Point(407001, "Aayush", 67);
	    em.persist(s);
	    s = new Point(407002, "Tapan", 75);
	    em.persist(s);
	    s = new Point(407003, "Askhay", 70);
	    em.persist(s);
	    s = new Point(407014, "Swapnil", 71);
	    em.persist(s);
	    s = new Point(407028, "Prasann", 66);
	    em.persist(s);
	    s = new Point(407030, "Ashwin", 65);
	    em.persist(s);
	    s = new Point(407030, "kishor", 65);
	    em.persist(s);
	    
	    em.getTransaction().commit();
	    
	    Query q1 = em.createQuery("SELECT COUNT(s) FROM Point s");
	    Query q2 = em.createQuery("select name from Point");
	    Query q3 = em.createQuery("select max(aggregate) from Point ");
	    Query q4 = em.createQuery("select name from Point where aggregate = 66 ");
	    //Query q3 = em.createQuery("select * from Point s");
        System.out.println("Total Points: " + q1.getSingleResult());
       //System.out.println("Point Name: " + s.toString());
        System.out.println("Total Points: " + q2.getResultList());
      //  System.out.println("Points details: " + q3.getResultList());
        System.out.println("Max marks of Points: " + q3.getSingleResult());
        System.out.println("Name of Point whose Aggregate is 66: " + q4.getSingleResult());
}
}