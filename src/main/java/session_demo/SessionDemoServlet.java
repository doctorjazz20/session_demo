package session_demo;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionDemoServlet
 */
@WebServlet("/session-demo")
public class SessionDemoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String epochToString(long epoch) {
		
		Date date = new Date(epoch);
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd:hh-mm");
		return formatter.format(date);
		
	}
       
    public SessionDemoServlet() {
        super();
    }

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Servlet destroyed");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Servlet started");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		StringBuilder pageBuilder = new StringBuilder();
		
		pageBuilder.append("<h1>Session Demo</h1>");
		
		String sessionId = request.getSession().getId();
		pageBuilder.append("<p>Session Id=");
		pageBuilder.append(sessionId);
		pageBuilder.append("</p>");
		
		long createdAt = request.getSession().getCreationTime();
		pageBuilder.append("<p>Creation Date=");
		pageBuilder.append(epochToString(createdAt));
		pageBuilder.append("</p>");
		
		long lastVisitedAt = request.getSession().getLastAccessedTime();
		pageBuilder.append("<p>last Visit Date=");
		pageBuilder.append(epochToString(lastVisitedAt));
		pageBuilder.append("</p>");
		
		System.out.println("Session Id="+sessionId);
		System.out.println("Creation Date="+epochToString(createdAt));
		System.out.println("last Visit Date="+epochToString(lastVisitedAt));
		
		response
			.getWriter()
			.append(pageBuilder.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
