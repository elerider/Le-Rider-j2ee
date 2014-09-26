package fr.epf.computerdatabase.dashboardController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.HibernateEntityManager;

import fr.epf.computerdatabase.dao.CompanyDAO;
import fr.epf.computerdatabase.dao.ComputerDAO;
import fr.epf.computerdatabase.domain.Company;
import fr.epf.computerdatabase.domain.Computer;
import fr.epf.computerdatabase.service.CompanyDBService;
import fr.epf.computerdatabase.service.ComputerDBService;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
		
	/**
	 * Emmanuel Le Rider
	 */
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				// TODO Auto-generated method stub
		
		
						//Get services
						CompanyDBService companyDBService = new CompanyDBService(); 
						ComputerDBService computerDBService = new ComputerDBService();
						
						List<Company> companies = new ArrayList<Company>();
						List<Computer> computers = new ArrayList<Computer>();
						
						//get computer with id = 1
						computers.addAll(computerDBService.getAll());
						computers.toString();
						companies.addAll(companyDBService.getAll());
						
						//add computer list / company list
						req.setAttribute("computers", computers);
						req.setAttribute("companies", companies);
				
						//Add lists
						req.setAttribute("test", "test");
						
						// Get dispatcher JSP
						RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/dashboard.jsp");
						
						//Forward the request
						dispatcher.forward(req,resp);
						
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

			// Get user form request
			int id=-1;
			try {
				id = getDeletedComputer(req);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//req.getParameter("");
	
			ComputerDBService service = new ComputerDBService();
	
			// delete the user

			System.out.println("id after getDeletedComputer = "+id);
			service.delete(id);
	
			doGet(req, resp);

	}
	private int getDeletedComputer(HttpServletRequest req) throws ParseException {
		
			int computerIndex;
			System.out.println("id inside getDeletedComputer = "+req.getParameter("id"));
			String id = (String) req.getParameter("id");
			computerIndex = Integer.parseInt(id);
			return computerIndex;
			
	}
}
