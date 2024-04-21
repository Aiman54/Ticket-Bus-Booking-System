package user.dao;

import java.security.*;
import java.sql.*;
import java.util.*;
import user.connection.ConnectionManager;
import user.model.User;

public class UserDAO {

	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String email, password, role;
	static int id;

	//login
	public static User login(User bean) throws NoSuchAlgorithmException{
		//get email and password
		email = bean.getEmail();
		password = bean.getPassword();

		//convert the password to MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		String query = "select * from users where email='" + email + "'AND password='" + sb.toString() + "'";

		try {
			//call getConnection() method //3. create statement  //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
		    //4. execute query
			rs = stmt.executeQuery(query);
			boolean more = rs.next();

			// if user exists set the isValid variable to true
			if (more) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String role = rs.getString("role");
				bean.setId(id);
				bean.setEmail(email);
				bean.setRole(role);

				System.out.println(role);
				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				bean.setValid(false);
			}

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return bean;
	}

	//add new user (register)
	public void add(User bean) throws NoSuchAlgorithmException{
		//get email,name and password
		email = bean.getEmail();
		password = bean.getPassword();
		role = bean.getRole();

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		String pass = sb.toString();

		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("insert into users(email,password,role)values(?,?,?)");
			ps.setString(1,email);
			ps.setString(2,pass);
			ps.setString(3,role);
			//4. execute query
			ps.executeUpdate();			
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

	}

	//get user
	public static User getUser(User bean)  {   
		//get email
		email = bean.getEmail();
		String searchQuery = "select * from users where email='" + email + "'";
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			stmt = con.createStatement();
			//execute statement
			rs = stmt.executeQuery(searchQuery);

			boolean more = rs.next();

			// if user exists set the isValid variable to true
			if (more) {
				String email = rs.getString("email");
				bean.setEmail(email);
				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				bean.setValid(false);
			}
			//5. close connection
			con.close();	
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return bean;
	}

	//get user by email
	public static User getUserByEmail(String email) {
		User us = new User();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("select * from users where email=?");
			ps.setString(1, email);
			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				us.setId(rs.getInt("id"));
				us.setEmail(rs.getString("email"));				
				us.setPassword(rs.getString("password"));

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return us;
	}

	//get user by id
	public static User getUserById(int id) {
		User us = new User();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("select * from users where id=?");
			ps.setInt(1, id);
			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {
				us.setId(rs.getInt("id"));
				us.setEmail(rs.getString("email"));
				us.setPassword(rs.getString("password"));

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return us;
	}
	
	//get all user by id
	public static List<User> getUserId() {
		List<User> users = new ArrayList<User>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			stmt = con.createStatement();
			//4. execute query
			rs = stmt.executeQuery("select id, email from users");

			while (rs.next()) {
				User us = new User();
				us.setId(rs.getInt("id"));
				us.setEmail(rs.getString("email"));
				users.add(us);

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return users;
	}
	//get all user role customer
	public static List<User> getUserCustomer() {
		List<User> users = new ArrayList<User>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			stmt = con.createStatement();
			//4. execute query
			rs = stmt.executeQuery("SELECT * FROM users u INNER JOIN customer c ON u.id = c.id");

			while (rs.next()) {
				User us = new User();
				us.setId(rs.getInt("id"));
				us.setEmail(rs.getString("email"));
				us.setCustomer(CustomerDAO.getCustomerId(rs.getInt("id")));
				users.add(us);

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return users;
	}
	
		
	//delete staff and customer from table users
	public void deleteUser(int id) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("delete from users where id=?");
			ps.setInt(1, id);
			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}		

}
