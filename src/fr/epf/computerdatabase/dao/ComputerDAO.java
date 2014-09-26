package fr.epf.computerdatabase.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epf.computerdatabase.domain.Computer;

public class ComputerDAO {
	
	
	
	EntityManagerFactory emf;
	
	
	
	public ComputerDAO(){
		emf = Persistence.createEntityManagerFactory("computer-database-PU");	
		
	}

	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public List<Computer> getAll(){
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em.createQuery("SELECT c FROM Computer c").getResultList();
		} finally {
			if(em != null){
				em.close();	
			}
		}
	}
	
	public void create(Computer computer){
		EntityManager em = null;
		try{
			em = getEntityManager();
			
			//Open a transaction because it's a write operation
			em.getTransaction().begin();
			
			//Save the computer
			em.persist(computer);
			
			
			//Really save in DB
			em.getTransaction().commit();
			
		} finally{
			if(em != null){
				em.close();
			}
		}
	}
	
	public void delete (int computerId){
		EntityManager em = null;
		System.out.println("ENTER DAO");
		try{
			em = getEntityManager();
			
			Computer computer = (Computer) em.createQuery("FROM Computer c WHERE c.id ="+computerId).getSingleResult();
			System.out.println("COMPUTER DELETED !");
			
			//Open a transaction because it's a write operation
			em.getTransaction().begin();
			
			//remove the computer
			
			em.remove(em.merge(computer));
			
			
			//Really save in DB
			em.getTransaction().commit();
			
		} finally{
			if(em != null){
				em.close();
			}
		}
		
		
	}

	

}