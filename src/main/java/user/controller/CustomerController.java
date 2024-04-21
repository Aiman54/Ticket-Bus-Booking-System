package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;
import user.dao.CustomerDAO;
import user.model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerDAO dao;
	private static UserDAO sdao;
	private int customer_ID;
	private String forward;
	private static String LIST = "listCustomer.jsp";
	private static String UPDATE = "updateCustomer.jsp";
	private static String VIEW = "viewCustomer.jsp";	
	private static String VIEW_PROFILE = "viewProfile.jsp";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
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
		
		
		if(action.equalsIgnoreCase("listCustomer")) {
			forward = LIST;
	        request.setAttribute("users", UserDAO.getUserCustomer());        
		}	
		if(action.equalsIgnoreCase("profile")) {
			forward = "profile.jsp";
	        request.setAttribute("users", UserDAO.getUserCustomer());        
		}	
		if(action.equalsIgnoreCase("viewCustomer")) {    
			forward = VIEW;
			customer_ID = Integer.parseInt(request.getParameter("customer_ID"));
			request.setAttribute("cust", CustomerDAO.getCustomerById(customer_ID));
		}		
		if(action.equalsIgnoreCase("updateCustomer")) { 
			forward = UPDATE;
			customer_ID = Integer.parseInt(request.getParameter("customer_ID"));
	        request.setAttribute("cust", CustomerDAO.getCustomerById(customer_ID));	        
		}
		if(action.equalsIgnoreCase("deleteCustomer")) {
			forward = LIST;
	        int id = Integer.parseInt(request.getParameter("id"));
		    sdao.deleteUser(id);		    
		    request.setAttribute("users", UserDAO.getUserCustomer());        
		}
		if(action.equalsIgnoreCase("viewProfile")) {
			forward = VIEW_PROFILE;
			int id = Integer.parseInt(request.getParameter("id"));
	        request.setAttribute("cust", CustomerDAO.getCustomerById(id));      
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
	    RequestDispatcher view = request.getRequestDispatcher("listCustomer.jsp");
	    
        view.forward(request, response);
	}

	}

