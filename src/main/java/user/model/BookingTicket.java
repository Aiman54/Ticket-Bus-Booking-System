package user.model;

import user.model.BookingTicket;

public class BookingTicket {
	
	private int ticket_ID;
	private int customer_ID;	
	private int bus_ID;	
	private Customer customer;
	private Bus bus;
	
	public void setTicket_ID(int ticket_ID) {
		this.ticket_ID = ticket_ID;
	}
	public int getTicket_ID() {
		return ticket_ID;
	}
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	public int getBus_ID() {
		return bus_ID;
	}
	public void setBus_ID(int bus_ID) {
		this.bus_ID = bus_ID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
