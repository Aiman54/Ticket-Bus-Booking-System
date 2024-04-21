package user.model;

public class Orders {
	private int order_ID;
	private int customer_ID;
	private int ticket_ID;
	
	
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public int getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}
	public int getTicket_ID() {
		return ticket_ID;
	}
	public void setTicket_ID(int ticket_ID) {
		this.ticket_ID = ticket_ID;
	}

}