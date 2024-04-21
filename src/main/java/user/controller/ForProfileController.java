package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.BookingTicketDAO;
import user.dao.CustomerDAO;
import user.dao.UserDAO;
import user.model.Customer;

/**
 * Servlet implementation class ForProfileController
 */
@WebServlet("/ForProfileController")
public class ForProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerDAO dao;
	private static UserDAO sdao;
	private int customer_ID;
	private String forward;
	private static String UPDATE = "addCust.jsp";
	private static String LIST = "profile.jsp";
	
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForProfileController() {
        super();
        dao = new CustomerDAO();
        sdao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
			
		if(action.equalsIgnoreCase("addCust")) { 
			forward = UPDATE;
			customer_ID = Integer.parseInt(request.getParameter("customer_ID"));
	        request.setAttribute("cust", CustomerDAO.getCustomerById(customer_ID));	        
		}
		
		if(action.equalsIgnoreCase("profile")) {
			forward = LIST;
	        request.setAttribute("users", UserDAO.getUserCustomer());        
		}	
		
		 RequestDispatcher view = request.getRequestDispatcher(forward);
		  view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer cust = new Customer();
		cust.setCustomer_name(request.getParameter("customer_name"));
		cust.setCustomer_phoneNum(request.getParameter("customer_phoneNum"));
		cust.setCustomer_email(request.getParameter("customer_email"));
		
		String customer_ID = request.getParameter("customer_ID");
		
		if(customer_ID ==null || customer_ID.isEmpty()) {
	    	dao.add(cust);
		}
		else {
			cust.setCustomer_ID(Integer.parseInt(customer_ID));
		    dao.updateCustomer(cust);
		}
	   
	    request.setAttribute("users", UserDAO.getUserCustomer());
	    RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
	    
        view.forward(request, response);
	}
			
}


