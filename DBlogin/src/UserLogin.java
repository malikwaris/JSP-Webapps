

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;


public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
    public UserLogin() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HnttpServletResponse response) throws ServletException, IOException {
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
