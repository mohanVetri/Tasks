import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

@WebServlet(value="/loginPage")
public class LoginPageServlet extends HttpServlet{

    @Override
	public void init() throws ServletException {
		ObjectifyService.init(new ObjectifyFactory(
			DatastoreOptions.newBuilder()
				.setProjectId("mystical-atlas-310706")
				.build()
				.getService()
			));	
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setContentType("text/html");    
        PrintWriter writer=response.getWriter();
        HttpSession session=request.getSession(false);
        if(session!=null){
            writer.println("You are already logged in!!!");
            writer.println("<br><a href=\"welcome\"><button>go to profile</button></a>");
            writer.println("<br><a href=\"logout\"><button>Logout</button></a>");
        }
        else{
            writer.println("<h1>Welcome to Login Page</h1>");
            request.getRequestDispatcher("index.html").include(request, response);
        }

    }
}
