/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date:28 June 2022
 */
package user.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import user.dao.UserDAO;
import user.dao.BookingTicketDAO;
import user.dao.BusDAO;
import user.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO dao;	
	HttpSession session;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		dao = new UserDAO();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			User user = new User();
			//retrieve and set email and password
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));

			user = UserDAO.login(user);
			//set user session if user is valid
			if(user.isValid()){
				session = request.getSession(true);
				session.setAttribute("sessionId", user.getId());
				System.out.println(user.getId());
				session.setAttribute("sessionEmail", user.getEmail());  //set current session based on email
				session.setAttribute("sessionRole", user.getRole()); 
				
				if(user.getRole().equalsIgnoreCase("staff")) {
					request.setAttribute("user", UserDAO.getUserByEmail(user.getEmail()));   					
					request.setAttribute("books", BookingTicketDAO.getCustomerBookingTickets());  
					RequestDispatcher view = request.getRequestDispatcher("listAll.jsp"); // staff page
					view.forward(request, response);	
				}
				else {
					request.setAttribute("user", UserDAO.getUserByEmail(user.getEmail()));					
					request.setAttribute("users", UserDAO.getUserCustomer());       		
					RequestDispatcher view = request.getRequestDispatcher("profile.jsp"); 	 // supplier page
					view.forward(request, response);	
				}											
			}
			//redirect to invalidLoggin.jsp if user is not valid
			else{
				response.sendRedirect("invalidLogin.jsp");
			}		
		}

		catch (Throwable ex) {
			System.out.println(ex);
		}
	}

}