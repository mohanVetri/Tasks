
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		PrintWriter writer=response.getWriter();
		request.getRequestDispatcher("/index.html").include(request, response);
//		Cookie cookie[]=request.getCookies();
//		if (cookie != null) {
//			String name = cookie[0].getValue();
//			if (name != null | !name.equals("")) {
//				writer.println("Welcome " + name);
//			}
//		}
//		 else {
//				writer.println("login first!!");
//				request.getRequestDispatcher("login.html").include(request, response);
//			}
		HttpSession session=request.getSession(false);
		if(session!=null) {
		String name=(String) session.getAttribute("name");
		writer.println("Welcome "+name);
	}
		else {
			writer.println("login first!");
			request.getRequestDispatcher("/login.html").include(request, response);
		}
		writer.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
