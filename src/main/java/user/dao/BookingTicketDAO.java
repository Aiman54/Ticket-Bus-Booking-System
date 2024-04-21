package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.connection.ConnectionManager;
import user.model.BookingTicket;

public class BookingTicketDAO {
	

	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	int ticket_ID, customer_ID, bus_ID;
	
	public void add(BookingTicket bean){		
		customer_ID = bean.getCustomer_ID();
		bus_ID = bean.getBus_ID();

		try {
			//call getConnection() method //3. create statement //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			ps=con.prepareStatement("insert into booking(customer_ID,bus_ID)values(?,?)");
			ps.setInt(1, customer_ID);
			ps.setInt(2, bus_ID);	
			//4. execute query
			ps.executeUpdate();
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	//get all products
	public static List<BookingTicket> getAllBookingTicket() { 
		List<BookingTicket> books = new ArrayList<BookingTicket>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement(); 
			//4. execute query
			rs = stmt.executeQuery("select * from booking order by ticket_ID");

			while (rs.next()) { 
				BookingTicket book = new BookingTicket();
				book.setTicket_ID(rs.getInt("ticket_ID"));
				book.setCustomer_ID(rs.getInt("customer_ID"));
				book.setBus_ID(rs.getInt("bus_ID"));
				books.add(book);

			} 
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return books; 
	}


	//get product by Id
	public static BookingTicket getBookingTicketById(int ticket_ID) {
		BookingTicket book = new BookingTicket();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			//3. create statement
			ps=con.prepareStatement("select * from booking where ticket_ID=?");
			ps.setInt(1, ticket_ID);
			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				book.setTicket_ID(rs.getInt("ticket_ID"));	  
				book.setCustomer_ID(rs.getInt("customer_ID"));
				book.setBus_ID(rs.getInt("bus_ID"));
			}
			//5. close connection
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return book;
	}

	//delete product
	public void deleteBookingTicket(int ticket_ID) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement 
			ps=con.prepareStatement("delete from booking where ticket_ID=?");
			ps.setInt(1, ticket_ID);
			//4. execute query
			ps.executeUpdate();
			//5. close connection
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	//update product
	public void updateBookingTicket(BookingTicket bean) {

		ticket_ID = bean.getTicket_ID();
		customer_ID = bean.getCustomer_ID();
		bus_ID = bean.getBus_ID();
		
		try {
			//call getConnection() method  
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("update booking set customer_ID=?,bus_ID=? WHERE ticket_ID=?"); 		  
			ps.setInt(1,customer_ID);//1 specifies the first parameter in the query i.e. name
			ps.setInt(2,bus_ID);	
			ps.setInt(3,ticket_ID);
			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//get products and supplier
	public static List<BookingTicket> getBusBookingTickets() { 
		List<BookingTicket> books = new ArrayList<BookingTicket>(); 
		try { 
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement 
			stmt = con.createStatement(); 
			//4. execute query
			rs = stmt.executeQuery("SELECT * FROM booking k INNER JOIN bus b ON k.bus_ID = b.bus_ID");

			while (rs.next()) { 
				BookingTicket book = new BookingTicket();
				book.setTicket_ID(rs.getInt("ticket_ID"));	
				book.setCustomer_ID(rs.getInt("customer_ID"));
				book.setBus_ID(rs.getInt("bus_ID"));
				book.setBus(BusDAO.getBusById(rs.getInt("bus_ID")));
				books.add(book);

			} 
			//5. close connection
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return books; 
	}
	//get products and supplier
		public static List<BookingTicket> getCustomerBookingTickets() { 
			List<BookingTicket> books = new ArrayList<BookingTicket>(); 
			try { 
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement 
				stmt = con.createStatement(); 
				//4. execute query
				rs = stmt.executeQuery("SELECT * FROM booking k INNER JOIN customer b ON k.customer_ID = c.customer_ID");

				while (rs.next()) { 
					BookingTicket book = new BookingTicket();
					book.setTicket_ID(rs.getInt("ticket_ID"));	
					book.setCustomer_ID(rs.getInt("customer_ID"));
					book.setBus_ID(rs.getInt("bus_ID"));
					book.setCustomer(CustomerDAO.getCustomerById(rs.getInt("customer_ID")));
					books.add(book);

				} 
				//5. close connection
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			
			}

			return books; 
		}
		
		
	
}
