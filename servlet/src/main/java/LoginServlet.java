
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

// import com.google.appengine.api.datastore.DatastoreService;
// import com.google.appengine.api.datastore.DatastoreServiceFactory;
// import com.google.appengine.api.datastore.Entity;

// import com.google.cloud.datastore.Datastore;
// import com.google.cloud.datastore.DatastoreOptions;
// import com.google.cloud.datastore.Entity;
// import com.google.cloud.datastore.FullEntity;

// import com.google.cloud.datastore.IncompleteKey;
// import com.google.cloud.datastore.Key;
// import com.google.cloud.datastore.KeyFactory;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String password = request.getParameter("password");
		String name = request.getParameter("username");
			Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

			Query<Entity> query = Query.newEntityQueryBuilder().setKind("StudentDetails").build();
			QueryResults<Entity> results = datastore.run(query);
	
			boolean notExist = true;
	
			while (results.hasNext()) {
				Entity entity = results.next();
				if (entity.getString("userName").equals(name)) {
					notExist = false;
					if (entity.getString("password").equals(password)) {
						HttpSession session = request.getSession();
						session.setAttribute("name", name);
						session.setAttribute("password", password);
						OfyHelper.ofy().save().entity(new Student(1,name,password)).now();
						OfyHelper.ofy().save().entity(new Student(2,"name","password")).now();
						response.sendRedirect("welcome");
					} else {
						writer.println("Invaid password!!");
						writer.println("<a href=\"loginPage\"><button>go to loginPage</button></a>");
					}
				}
			}
	
			if (notExist) {
				writer.println("Register First!!");
				writer.println("<a href=\"loginPage\"><button>go to loginPage</button></a>");
			}
	

		// if (!RegistrationServlet.list.isEmpty()) {
		// for (StudentsDetails details : RegistrationServlet.list) {
		// if (name.equals(details.userName)) {
		// notExist=false;
		// break;
		// }
		// }
		// }
		// if (notExist) {
		// request.getRequestDispatcher("index.html").include(request, response);
		// writer.println("Register First");
		// } else {
		// for (StudentsDetails details : RegistrationServlet.list) {
		// if (name.equals(details.userName)) {
		// if (password.equals(details.password)) {
		// HttpSession session = request.getSession();
		// session.setAttribute("name", name);
		// session.setAttribute("password", password);
		// response.sendRedirect("welcome");
		// } else {
		// request.getRequestDispatcher("index.html").include(request, response);
		// writer.println("Invalid Password");
		// }
		// }
		// }
		// }

		// if (password.equals("abc123")) {
		// HttpSession session=request.getSession();
		// session.setAttribute("name", name);
		// session.setAttribute("password", password);
		// response.sendRedirect("welcome");
		// } else {
		// RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
		// dispatcher.include(request, response);
		// writer.println("it's not a valid password");

		// }

		// Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
		// KeyFactory keyFactory = datastore.newKeyFactory().setKind("Message");
		// FullEntity<Key> messageEntity =
		// Entity.newBuilder(keyFactory.newKey(++id)).set("name", name)
		// .set("password", password).build();
		// datastore.put(messageEntity);

		// DatastoreService ds=DatastoreServiceFactory.getDatastoreService();

		// Entity e=new Entity("Person");
		// e.setProperty("propertyName", "hello");
		// e.setProperty("firstName", "value");
		// ds.put(e);
	}
}
