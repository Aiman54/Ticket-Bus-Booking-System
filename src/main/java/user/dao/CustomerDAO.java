package user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import user.connection.ConnectionManager;
import user.model.Bus;
import user.model.Customer;

public class CustomerDAO {
	
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	String customer_name, customer_phoneNum,customer_email;
	int customer_ID, id; 
	
	public void add(Customer bean){		
		customer_ID = bean.getCustomer_ID();
		customer_name = bean.getCustomer_name();
		customer_phoneNum = bean.getCustomer_phoneNum();
		customer_email = bean.getCustomer_email();

		try {
			//call getConnection() method //3. create statement //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			ps=con.prepareStatement("insert into bus(customer_name,customer_phoneNum,customer_email,customer_ID)values(?,?,?,?)");
			ps.setString(1,customer_name);
			ps.setString(2,customer_phoneNum);	
			ps.setString(3,customer_email);			
			ps.setInt(4,customer_ID);
			//4. execute query
			ps.executeUpdate();
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}
	//get all customers
		public static List<Customer> getAllCustomer() {
			List<Customer> custs = new ArrayList<Customer>();
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				//3. create statement  
				stmt = con.createStatement();
				//4. execute query
				rs = stmt.executeQuery("select * from customer order by customer_ID");

				while (rs.next()) {
					Customer cust = new Customer();
					cust.setCustomer_ID(rs.getInt("customer_ID"));
					cust.setCustomer_name(rs.getString("customer_name"));
					cust.setCustomer_phoneNum(rs.getString("customer_phoneNum"));
					cust.setCustomer_email(rs.getString("customer_email"));
					cust.setId(rs.getInt("id"));
					custs.add(cust);
				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}
			return custs;
		}


		//get customer by customer_ID
		public static Customer getCustomerById(int customer_ID) {
			Customer cust = new Customer();
			try {
				//call getConnection() method  
				con = ConnectionManager.getConnection();
				//3. create statement 
				ps=con.prepareStatement("select * from customer where customer_ID=?");
				ps.setInt(1, customer_ID);
				 //4. execute query
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {	            
					cust.setCustomer_ID(rs.getInt("customer_ID"));
					cust.setCustomer_name(rs.getString("customer_name"));
					cust.setCustomer_phoneNum(rs.getString("customer_phoneNum"));
					cust.setCustomer_email(rs.getString("customer_email"));
					cust.setId(rs.getInt("id"));
				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			
			}

			return cust;
		}

		//get Customer by id
		public static Customer getCustomerId(int id) {
			Customer cust = new Customer();
			try {
				//call getConnection() method  
				con = ConnectionManager.getConnection();
				//3. create statement  
				ps=con.prepareStatement("select * from customer where id=?");
				ps.setInt(1, id);
				//4. execute query
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {	            
					cust.setCustomer_ID(rs.getInt("customer_ID"));
					cust.setCustomer_name(rs.getString("customer_name"));
					cust.setCustomer_phoneNum(rs.getString("customer_phoneNum"));

					cust.setCustomer_email(rs.getString("customer_email"));
					cust.setId(rs.getInt("id"));
				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			
			}

			return cust;
		}

		//update Customer
		public void updateCustomer(Customer bean) {

			customer_ID = bean.getCustomer_ID();
			customer_name = bean.getCustomer_name();
			customer_phoneNum = bean.getCustomer_phoneNum();
			customer_email = bean.getCustomer_email();
			
	
			try {
				//call getConnection() method  
				con = ConnectionManager.getConnection();
				//3. create statement  
				ps=con.prepareStatement("update customer set customer_name=?,customer_phoneNum=?, customer_email=? WHERE customer_ID=?"); 		  
				ps.setString(1,customer_name);//1 specifies the first parameter in the query i.e. name
				ps.setString(2,customer_phoneNum);	
				ps.setString(3,customer_email);			
				ps.setInt(4,customer_ID);
				//4. execute query
				ps.executeUpdate();

				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			
			}
		}

}
