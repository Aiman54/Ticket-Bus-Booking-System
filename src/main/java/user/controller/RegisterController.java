package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.StaffDAO;
import user.dao.UserDAO;
import user.model.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO dao; 
	String forward;
	RequestDispatcher view;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		forward = "registration.jsp";		
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		//retrieve input and set
		user.setEmail(request.getParameter("email"));		
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		
		user = UserDAO.getUser(user);
		//check if user exists
		if(!user.isValid()){
        	try {
        		//if user not exist, add/register the user
				dao.add(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	//redirect to login page
        	request.setAttribute("users", UserDAO.getUserCustomer());  
        	view = request.getRequestDispatcher("login.jsp"); // staff page
			view.forward(request, response);	
        }        
	}

}
