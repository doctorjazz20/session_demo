package session_demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		name="LOGOUT_SERVLET",
		value ="/logout",
		loadOnStartup = 0
	)
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request
			.getRequestDispatcher("index.html")
			.include(request, response);
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response
		.getWriter()
		.append("you log out!!!");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
