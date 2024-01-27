package session_demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="WELCOME_SERVLET",
		value ="/welcome",
		loadOnStartup = 0
	)
public class WelcomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder pageBuilder = new StringBuilder();
		pageBuilder.append("<h1>Welcome Page</h1>");
		
		String username = (String) request.getSession().getAttribute("username");
		if(username==null) {
			pageBuilder.append("<p>Sorry!! session is expired</p>");
		}else {
			pageBuilder.append("<p>Welcome "+username+"</p>");
		}
		
		response
			.getWriter()
			.append(pageBuilder.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
