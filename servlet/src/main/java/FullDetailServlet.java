import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.cmd.Query;



@WebServlet(value = "/fullDetails")
public class FullDetailServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        PrintWriter writer = response.getWriter();
        HttpSession session=request.getSession(false);
        if(session!=null){
            Query<StudentDetails> query=OfyHelper.ofy().load().type(StudentDetails.class);
            if(query!=null){
                writer.print("<table border=\"1\">" + "<th>firstName</th>" + "<th>lastName</th>" + "<th>userName</th>"
                + "<th>password</th>" + "<th>mailId</th>");
            }
			for(StudentDetails details: query){
                writer.print("<tr>" + "<td>" + details.firstName + "</td>" + "<td>"
                        + details.lastName + "</td>" + "<td>" + details.userName + "</td>" + "<td>" + details.password + "</td>" + "<td>" + details.emailId
                        + "</td>" + "</tr>");
			}
            writer.print( "</table>");


            // Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

            // Query<Entity> query = Query.newEntityQueryBuilder().setKind("StudentDetails").build();
            // QueryResults<Entity> results = datastore.run(query);
    
            // if (!results.hasNext()) {
            //     writer.println("NO STUDENT CONTACTS AVAILABLE");
            // }
    
            // while (results.hasNext()) {
            //     Entity entity = results.next();
            //     String username = entity.getString("userName");
            //     String password = entity.getString("password");
            //     String firstName = entity.getString("firstName");
            //     String lastName = entity.getString("lastName");
            //     String mailId = entity.getString("emailId");
            //     writer.println("<table border=\"1\">" + "<th>firstName</th>" + "<th>lastName</th>" + "<th>userName</th>"
            //             + "<th>password</th>" + "<th>mailId</th>" + "<tr>" + "<td>" + firstName + "</td>" + "<td>"
            //             + lastName + "</td>" + "<td>" + username + "</td>" + "<td>" + password + "</td>" + "<td>" + mailId
            //             + "</td>" + "<tr>" +
            //             "</table>");
            // }
        }
        else{
            writer.println("Register First!!<br>");
            writer.println("<a href=\"loginPage\"><button>go to loginPage</button></a>");
        }
    }
}