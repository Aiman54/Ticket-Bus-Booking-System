package user.model;

public class Customer {
	
	private int customer_ID;
	private String customer_name;
	private String customer_phoneNum;
	private String customer_email;
	private int id;
	
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_phoneNum() {
		return customer_phoneNum;
	}
	public void setCustomer_phoneNum(String customer_phoneNum) {
		this.customer_phoneNum = customer_phoneNum;
	}
	
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
