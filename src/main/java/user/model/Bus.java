package user.model;

public class Bus {
	
	private int bus_ID;
	private String bus_status;
	private int bus_seatNum;
	private String departure_date;
	private String departure_time;
	private String destination;
	private double ticket_price;
	private BookingTicket booking;
	
	public int getBus_ID() {
		return bus_ID;
	}
	public void setBus_ID(int bus_ID) {
		this.bus_ID = bus_ID;
	}
	public String getBus_status() {
		return bus_status;
	}
	public void setBus_status(String bus_status) {
		this.bus_status = bus_status;
	}
	public int getBus_seatNum() {
		return bus_seatNum;
	}
	public void setBus_seatNum(int bus_seatNum) {
		this.bus_seatNum = bus_seatNum;
	}
	public String getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}
	public BookingTicket getBooking() {
		return booking;
	}
	public void setBooking(BookingTicket booking) {
		this.booking = booking;
	}
}
