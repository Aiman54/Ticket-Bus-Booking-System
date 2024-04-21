/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date:28 June 2022
 */
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
import user.model.Bus;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/BusController")
public class BusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BusDAO dao;
	private int bus_ID;
	private String forward;
	private static String LIST = "listBus.jsp";
	private static String VIEW = "viewBus.jsp";	
	private static String UPDATE = "updateBus.jsp";
	private static String ADD = "bus.jsp";	
	private static String LISTALL = "listAll.jsp";
	private static String LISTNEW = "forthem.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusController() {
        super();
        dao = new BusDAO();        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        
		if(action.equalsIgnoreCase("listBus")) {
			forward = LIST;
	        request.setAttribute("buss", BusDAO.getAllBus());       
		}	
		
		if(action.equalsIgnoreCase("forthem")) {
			forward = LISTNEW;
	        request.setAttribute("buss", BusDAO.getAllBus());       
		}	
		
		if(action.equalsIgnoreCase("list")) {
			forward = LISTALL;
			request.setAttribute("buss", BusDAO.getBookingTicketBus());
		}
		if(action.equalsIgnoreCase("viewBus")) { 
			forward = VIEW;
			bus_ID = Integer.parseInt(request.getParameter("bus_ID"));  
	        request.setAttribute("bus", BusDAO.getBusById(bus_ID));
		}
		if(action.equalsIgnoreCase("updateBus")) {
			forward = UPDATE;	
			bus_ID = Integer.parseInt(request.getParameter("bus_ID")); 
	        request.setAttribute("bus", BusDAO.getBusById(bus_ID)); 
		
		}
		if(action.equalsIgnoreCase("deleteBus")) {
			forward = LIST;
			bus_ID = Integer.parseInt(request.getParameter("bus_ID"));  
			dao.deleteBus(bus_ID);
			request.setAttribute("buss", BusDAO.getAllBus());    
		}		
		if(action.equalsIgnoreCase("bus")) {
			forward = ADD;			
			request.setAttribute("books", BookingTicketDAO.getAllBookingTicket());	   
		}
         
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Bus bus = new Bus();
		bus.setBus_status(request.getParameter("bus_status"));
		bus.setBus_seatNum(Integer.parseInt(request.getParameter("bus_seatNum")));
		bus.setDeparture_time(request.getParameter("departure_time"));
		bus.setDeparture_date(request.getParameter("departure_date"));
		bus.setDestination(request.getParameter("destination"));
		bus.setTicket_price(Double.parseDouble(request.getParameter("ticket_price")));
		    
		String bus_ID = request.getParameter("bus_ID");
	    if(bus_ID ==null || bus_ID.isEmpty()) {
	    	dao.add(bus);
		}
		else {
			bus.setBus_ID(Integer.parseInt(bus_ID));
			dao.updateBus(bus);
		}
	    
	    request.setAttribute("buss", BusDAO.getAllBus());
	    RequestDispatcher view = request.getRequestDispatcher("listBus.jsp");
        view.forward(request, response);
	}

}
