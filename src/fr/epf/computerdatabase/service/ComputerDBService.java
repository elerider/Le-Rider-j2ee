package fr.epf.computerdatabase.service;

import java.util.List;

import fr.epf.computerdatabase.dao.ComputerDAO;
import fr.epf.computerdatabase.domain.Computer;

public class ComputerDBService {

//private static ComputerDBService instance = null ;
	
	//static to be call without an instance
//	public static ComputerDBService getInstance(){
//		
//		if(instance == null){
//			//If there is no instance yet just created it.
//			instance = new ComputerDBService();
//		} 
//		return instance;
//	}
	
	public ComputerDBService(){
		
	}
	
	public void create(Computer computer){
			computerDAO.create(computer);
 	}
	
	public void delete (int computerId){
		System.out.println("ENTER SERVICE");
			computerDAO.delete(computerId);
	}
	
	private ComputerDAO computerDAO = new ComputerDAO();
		
		
	public List<Computer> getAll(){
		return computerDAO.getAll();
	}
}