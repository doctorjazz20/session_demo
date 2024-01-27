package session_demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		name="LOGIN_SERVLET",
		value ="/login",
		loadOnStartup = 0
	)
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);		
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");  
	    String password=request.getParameter("password");  
		
	    if(password.trim().equals("admin123")) {
	    	
			HttpSession session=request.getSession();  
		    session.setAttribute("username",name);  
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome");
			dispatcher.forward(request, response); 
			
		}else {
			
			response
	        	.sendRedirect("login.html");
			
			response
				.getWriter()
				.append("wrong password!!!");
			
		}
	}

}
