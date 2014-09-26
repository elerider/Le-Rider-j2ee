package fr.epf.computerdatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.epf.computerdatabase.domain.Company;
import fr.epf.computerdatabase.domain.Computer;

public class CompanyDAO {
	
	
	
	EntityManagerFactory emf;
	
	
	
	public CompanyDAO(){
		emf = Persistence.createEntityManagerFactory("computer-database-PU");
		
	}

	private EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public List<Company> getAll(){
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em.createQuery("SELECT u FROM Company u").getResultList();
		} finally {
			if(em != null){
				em.close();	
			}
		}
	}

	public void create(Company company) {
		
			EntityManager em = null;
			try{
				em = getEntityManager();
				
				//Open a transaction because it's a write operation
				em.getTransaction().begin();
				
				//Save the user
				em.persist(company);
				
				//Really save in DB
				em.getTransaction().commit();
				
			} finally{
				if(em != null){
					em.close();
				}
			}
		
		
	}

}