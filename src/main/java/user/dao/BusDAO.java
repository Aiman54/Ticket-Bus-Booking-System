package user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import user.connection.ConnectionManager;
import user.model.Bus;

public class BusDAO {

	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	int bus_ID, bus_seatNum;
	String bus_status, departure_date, departure_time, destination;
	double ticket_price;

	//add product
	public void add(Bus bean){		
		bus_status = bean.getBus_status();
		bus_seatNum = bean.getBus_seatNum();
		departure_date = bean.getDeparture_date();
		departure_time = bean.getDeparture_time();
		destination = bean.getDestination();
		ticket_price = bean.getTicket_price();

		try {
			//call getConnection() method //3. create statement //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			ps=con.prepareStatement("insert into bus(bus_ID,bus_status,bus_seatNum,departure_date,departure_time,destination,ticket_price)values(?,?,?,?,?,?,?)");
			ps.setInt(1,bus_ID);
			ps.setString(2,bus_status);
			ps.setInt(3,bus_seatNum);
			ps.setString(4,departure_date);
			ps.setString(5,departure_time);
			ps.setString(6,destination);
			ps.setDouble(7,ticket_price);
			//4. execute query
			ps.executeUpdate();
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	//get all products
	 public static List<Bus> getAllBus() { 
	  		List<Bus> buss = new ArrayList<Bus>(); 
		  
	  		try { 
	  			//call getConnection() method
	  			con = ConnectionManager.getConnection();
	  			//3. create statement
	  			stmt = con.createStatement(); 
	  			//4. execute query
	  			rs = stmt.executeQuery("select * from bus order by bus_ID");

	  			while (rs.next()) { 
	  				Bus bus = new Bus();
	  				bus.setBus_ID(rs.getInt("bus_ID"));	  
	  				bus.setBus_status(rs.getString("bus_status"));
	  				bus.setBus_seatNum(rs.getInt("bus_seatNum"));
	  				bus.setDeparture_date(rs.getString("departure_date"));
	  				bus.setDeparture_time(rs.getString("departure_time"));
	  				bus.setDestination(rs.getString("destination"));
	  				bus.setTicket_price(rs.getDouble("ticket_price"));
	  				buss.add(bus);

	  			} 
	  			//5. close connection
	  			con.close();
	  		}catch(Exception e) {
	  			e.printStackTrace();
	  		}
	  		
	  		return buss; 
	  	}
		  


	//get product by Id
	 public static Bus getBusById(int bus_ID) {
   	  Bus bus = new Bus();
 		try {
 			//call getConnection() method
 			con = ConnectionManager.getConnection();
 			//3. create statement
 			ps=con.prepareStatement("select * from bus where bus_ID=?");
 			ps.setInt(1, bus_ID);
 			//4. execute query
 			rs = ps.executeQuery();

 			if (rs.next()) {	            
 				bus.setBus_ID(rs.getInt("bus_ID"));	  
 				bus.setBus_status(rs.getString("bus_status"));
 				bus.setBus_seatNum(rs.getInt("bus_seatNum"));
 				bus.setDeparture_date(rs.getString("departure_date"));
  				bus.setDeparture_time(rs.getString("departure_time"));
  				bus.setDestination(rs.getString("destination"));
  				bus.setTicket_price(rs.getDouble("ticket_price"));
 				
 			}
 			//5. close connection
 			con.close();
 		
 		}catch(Exception e) {
 			e.printStackTrace();
 		
 		}

 		return bus;
 	}
     

	 //delete bus
     public void deleteBus(int bus_ID) {
 		try {
 			//call getConnection() method 
 			con = ConnectionManager.getConnection();
 			//3. create statement 
 			ps=con.prepareStatement("delete from bus where bus_ID=?");
 			ps.setInt(1, bus_ID);
 			//4. execute query
 			ps.executeUpdate();
 			//5. close connection
 			con.close();
 		
 		}catch(Exception e) {
 			e.printStackTrace();
 		}
     }
     

	 //update bus
    public void updateBus(Bus bean) {

		bus_ID = bean.getBus_ID();
		bus_status = bean.getBus_status();
		bus_seatNum = bean.getBus_seatNum();
		departure_date = bean.getDeparture_date();
		departure_time = bean.getDeparture_time();
		destination = bean.getDestination();
		ticket_price = bean.getTicket_price();
		
		try {
			//call getConnection() method  
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("update bus set bus_status=?,bus_seatNum=?,departure_date=?,departure_time=?,destination=?,ticket_price=? WHERE bus_ID=?"); 		  
			ps.setString(1,bus_status);//1 specifies the first parameter in the query i.e. name
			ps.setInt(2,bus_seatNum);	
			ps.setString(3,departure_date);			
			ps.setString(4,departure_time);
			ps.setString(5,destination);
			ps.setDouble(6,ticket_price);
			ps.setInt(7,bus_ID);
			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}
    

	//get products and supplier
	public static List<Bus> getBookingTicketBus() { 
		List<Bus> buss = new ArrayList<Bus>(); 
		try { 
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement 
			stmt = con.createStatement(); 
			//4. execute query
			rs = stmt.executeQuery("SELECT * FROM bus b INNER JOIN booking k ON b.ticket_ID = k.ticket_ID");

			while (rs.next()) { 
				Bus bus = new Bus();
				bus.setBus_ID(rs.getInt("bus_ID"));	  
 				bus.setBus_status(rs.getString("bus_status"));
 				bus.setBus_seatNum(rs.getInt("bus_seatNum"));
 				bus.setDeparture_date(rs.getString("departure_date"));
  				bus.setDeparture_time(rs.getString("departure_time"));
  				bus.setDestination(rs.getString("destination"));
  				bus.setTicket_price(rs.getDouble("ticket_price"));
				bus.setBooking(BookingTicketDAO.getBookingTicketById(rs.getInt("ticket_ID")));
				buss.add(bus);

			} 
			//5. close connection
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return buss; 
	}

}
