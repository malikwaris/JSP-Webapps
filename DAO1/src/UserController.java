

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import pk.edu.zab.dao.UserDAO;


public class UserController extends HttpServlet {
	UserDAO userDao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password=request.getParameter("password"); 
		RequestDispatcher dispatch;
		
		boolean flag = userDao.validUser(email, password);
		if(flag){
			//go to home pagehpome
			 request.getRequestDispatcher("home.jsp").forward(request, response);
		}else{
			// go to login page again
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	userDao = new UserDAO();
		
	}
}
