import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SuccessfullPage
 */
public class SuccessfulPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessfulPage() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		response.setContentType("text/html");
		HttpSession session =request.getSession(false);
		if(session!=null) {
			PrintWriter writer=response.getWriter();
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.html");
			requestDispatcher.include(request, response);
			writer.println("you are successfully logged in!!!");
		}
		else {
			request.getRequestDispatcher("/login.html").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
