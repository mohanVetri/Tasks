
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.Key;

/**
 * Servlet implementation class WelcomeServlet
 */

@WebServlet(value = "/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("name");
			writer.println("Welcome " + name+"<br><br>");

			writer.println("Using objectify!!");
			Student entity=OfyHelper.ofy().load().key(Key.create(Student.class, 1)).now();
			writer.println("name: "+entity.userName+" password: "+entity.password+"<br>");

			response.getWriter().println("<a href=\"/logout\"><button>Logout</button></a>");
			response.getWriter().println("<a href=\"/showDetails\"><button>ShowDetails</button></a>");
			response.getWriter().println("<a href=\"/fullDetails\"><button>ShowAllDetails</button></a><br>");



		}
		else{
			writer.println("Register First!!<br>");
			writer.println("<a href=\"loginPage\"><button>go to loginPage</button></a>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
