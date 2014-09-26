package fr.epf.computerdatabase.service;

import java.util.List;

import fr.epf.computerdatabase.dao.CompanyDAO;
import fr.epf.computerdatabase.domain.Company;
import fr.epf.computerdatabase.domain.Computer;

public class CompanyDBService {
	
private static CompanyDBService instance = null ;
	
	//static to be call without an instance
//	public static CompanyDBService getInstance(){
//		
//		if(instance == null){
//			//If there is no instance yet just created it.
//			instance = new CompanyDBService();
//		} 
//		return instance;
//	}
	
	public CompanyDBService(){
		
	}
	
	private CompanyDAO companyDAO = new CompanyDAO();
	
	public void create(Company company){
		companyDAO.create(company);
	}
	public List<Company> getAll(){
		return companyDAO.getAll();
	}
}