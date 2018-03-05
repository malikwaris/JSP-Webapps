

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;//1
import java.sql.Connection;//2
import java.sql.SQLException;
import java.sql.Statement;//3
import java.sql.ResultSet;//4



public class JDBCServlet extends HttpServlet {
	Connection con;
	Statement st;
	ResultSet rs;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JDBC Servlet Invoked");
		
		//1st step: load JDBC MySql Drivers
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drivers Loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2nd Step: create a connection
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtech1", "root", "53267");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "select * from user";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("firstName"));
				System.out.println(rs.getString("lastName"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("password"));
				System.out.println(rs.getString("createdate"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}


}
