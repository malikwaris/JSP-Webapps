package pk.edu.zab.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pk.edu.zab.dto.User;

public class UserDAO {
	
	private Connection connection;
	
	  public UserDAO() {
	        connection = null; // create connection
	    }
	  public List<User> getAllUsers(){
		  ArrayList<User> list = new ArrayList<User>();
		  
		  String sql = "select * from user";

try {
	Statement st = connection.createStatement();
	ResultSet rs = st.executeQuery(sql);
	
	while(rs.next()){
		User aUser = new User();// create a user in each loop ieration
		aUser.setId(rs.getInt("id")); ;
		aUser.setFirstName(rs.getString("firstName"));
		aUser.setLastName(rs.getString("lastName"));
		aUser.setEmail(rs.getString("email"));
		aUser.setPassword(rs.getString("password"));
		aUser.setCreateDate(rs.getString("createdate"));
		// add it in list
		list.add(aUser);
	}
	
} catch (SQLException e) {e.printStackTrace();}

		  
		return list;
	  }
	  
	  public boolean validUser(String email,String password){
		  boolean flag = false;
		  String sql = "select * from user where email='"+email+"' and password='"+password+"'";
		  
		  try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				if(rs.next()){
					flag = true;
				}
				
			} catch (SQLException e) {e.printStackTrace();}
		  
			return flag;	  
	  }
	  
	  public User getUserById(int id){
		  User aUser = new User();// create a user
		  String sql = "select * from user where id="+id;
		  
		  try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				if(rs.next()){
					
					aUser.setId(rs.getInt("id")); ;
					aUser.setFirstName(rs.getString("firstName"));
					aUser.setLastName(rs.getString("lastName"));
					aUser.setEmail(rs.getString("email"));
					aUser.setPassword(rs.getString("password"));
					aUser.setCreateDate(rs.getString("createdate"));
				}
				
			} catch (SQLException e) {e.printStackTrace();}
		  
			return aUser;	  
	 }
	  public void addUser(User user){
		  String sql = "insert into user (firstName,lastName,email,password) values('"+user.getFirstName()+"','"+user.getLastName()+"','','');";
		  try {
			Statement st = connection.createStatement();
			st.execute(sql);
			
		} catch (SQLException e) {e.printStackTrace();}
		  
	  }
	  public void deleteUser(int id){
		  String sql = "delete from user where id ="+id; 
		  try {
				Statement st = connection.createStatement();
				st.execute(sql);
				
			} catch (SQLException e) {e.printStackTrace();}
		  
	  }
	  
	  public void updateUser(User user){
		  String sql = "UPDATE user SET firstName='"+user.getFirstName()+"', lastName='"+user.getLastName()+"', email='"+user.getEmail()+"',  password='"+user.getPassword()+"' where id=?";
		  try {
				Statement st = connection.createStatement();
				st.executeUpdate(sql);
				
			} catch (SQLException e) {e.printStackTrace();}
	  }
	  
	  
	  

}
