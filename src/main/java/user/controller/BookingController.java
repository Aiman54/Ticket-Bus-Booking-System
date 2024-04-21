package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.BookingTicketDAO;
import user.dao.BusDAO;
import user.dao.CustomerDAO;
import user.model.BookingTicket;

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BookingTicketDAO dao; 
	private int ticket_ID;
	private String forward;
	private static String LIST = "listBooking.jsp";
	private static String VIEW = "viewBooking.jsp";	
	private static String UPDATE = "updateBooking.jsp";
	private static String ADD = "booking.jsp";
	private static String LISTALL = "listAll.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
        dao = new BookingTicketDAO();  
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        
		if(action.equalsIgnoreCase("listBooking")) {
			forward = LIST;
	        request.setAttribute("books", BookingTicketDAO.getAllBookingTicket());       
		}
		
		if(action.equalsIgnoreCase("listAll")) {
			forward = LISTALL;
			request.setAttribute("books", BookingTicketDAO.getBusBookingTickets());
		}
		if(action.equalsIgnoreCase("viewBooking")) { 
			forward = VIEW;
			ticket_ID = Integer.parseInt(request.getParameter("ticket_ID"));  
	        request.setAttribute("book", BookingTicketDAO.getBookingTicketById(ticket_ID));
		}
		if(action.equalsIgnoreCase("updateBooking")) {
			forward = UPDATE;			
			ticket_ID = Integer.parseInt(request.getParameter("ticket_ID"));  	       
	        request.setAttribute("book",BookingTicketDAO.getBookingTicketById(ticket_ID));
	        request.setAttribute("custs", CustomerDAO.getAllCustomer());
	        request.setAttribute("buss", BusDAO.getAllBus());	       
	            
		}
		if(action.equalsIgnoreCase("deleteBooking")) {
			forward = LIST;
			ticket_ID = Integer.parseInt(request.getParameter("ticket_ID"));
		    dao.deleteBookingTicket(ticket_ID);	
		    request.setAttribute("books", BookingTicketDAO.getAllBookingTicket());        
		}
		if(action.equalsIgnoreCase("booking")) {
			forward = ADD;
			request.setAttribute("custs", CustomerDAO.getAllCustomer());
			request.setAttribute("buss", BusDAO.getAllBus());	   
		}
		  
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        
      
		}
            

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookingTicket book = new BookingTicket();
		book.setCustomer_ID(Integer.parseInt(request.getParameter("customer_ID")));
		book.setBus_ID(Integer.parseInt(request.getParameter("bus_ID")));
		
		String ticket_ID = request.getParameter("ticket_ID");
		
	    if(ticket_ID ==null || ticket_ID.isEmpty()) {
	    	dao.add(book);
		}
		else {
			book.setTicket_ID(Integer.parseInt(ticket_ID));
			dao.updateBookingTicket(book);
		}
	   
	    request.setAttribute("books", BookingTicketDAO.getAllBookingTicket());
	    RequestDispatcher view = request.getRequestDispatcher("listBooking.jsp");
        view.forward(request, response);
        System.out.println("tolong");
	  
	}

}
