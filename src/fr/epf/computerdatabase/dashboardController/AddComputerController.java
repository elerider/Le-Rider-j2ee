package fr.epf.computerdatabase.dashboardController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.computerdatabase.dao.CompanyDAO;
import fr.epf.computerdatabase.dao.ComputerDAO;
import fr.epf.computerdatabase.domain.Company;
import fr.epf.computerdatabase.domain.Computer;
import fr.epf.computerdatabase.service.CompanyDBService;
import fr.epf.computerdatabase.service.ComputerDBService;

@WebServlet("/addComputer")
public class AddComputerController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Get services
		CompanyDBService companyDBService = new CompanyDBService();

		List<Company> companies = new ArrayList<Company>();

		// get computer with id = 1
		companies.addAll(companyDBService.getAll());

		// add computer list / company list
		
		req.setAttribute("companies", companies);


		// Get dispatcher JSP
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("WEB-INF/views/addComputer.jsp");

		// Forward the request
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Get user form request
		Computer computer = populateComputer(req);
		//req.getParameter("");
		System.out.println(computer);

		ComputerDBService service = new ComputerDBService();

		// Persist the computer
		service.create(computer);

		doGet(req, resp);

	}

	private Computer populateComputer(HttpServletRequest req) {
		// GEt form data
	CompanyDAO companyDAO = new CompanyDAO();
	ComputerDAO computerDAO = new ComputerDAO();
		
		Date dateIntroduced = null;
		try {
			System.out.println(req.getParameter("introduced"));
			dateIntroduced = new SimpleDateFormat("y-MM-d", Locale.ENGLISH).parse(req.getParameter("introduced"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date dateDiscontinued = null;
		try {
			dateDiscontinued = new SimpleDateFormat("y-MM-d", Locale.ENGLISH).parse(req.getParameter("discontinued"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String name = (String) req.getParameter("name");
		System.out.println("TEST"+name);
		//
		Computer computer2 = computerDAO.getAll().get(1);
		System.out.println("exemple : "+computer2);
		Company company = companyDAO.getAll().get(Integer.parseInt((String) req.getParameter("company"))-1);
		
		// try {
		//
		// dateIntroduced = formatter.parse(introduced);
		// dateDiscontinued = formatter.parse(discontinued);
		// System.out.println(dateIntroduced);
		//
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }

		Computer computer = Computer.builder().name(name)
				.introduced(dateIntroduced).discontinued(dateDiscontinued)
				.company(company).build();
		return computer;
	}
}
