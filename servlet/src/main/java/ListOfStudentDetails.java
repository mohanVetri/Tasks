import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

@WebServlet(value = "/showFullDetails")
public class ListOfStudentDetails extends HttpServlet {
    
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        PrintWriter writer = response.getWriter();
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

        Query<Entity> query = Query.newEntityQueryBuilder().setKind("StudentDetails").build();
        QueryResults<Entity> results = datastore.run(query);

        if (!results.hasNext()) {
            writer.println("NO STUDENT CONTACTS AVAILABLE");
        }
        else{
            writer.print("<table border=\"1\">" + "<th>firstName</th>" + "<th>lastName</th>" + "<th>userName</th>"
            + "<th>password</th>" + "<th>mailId</th>");
        }

        while (results.hasNext()) {
            Entity entity = results.next();
            String username = entity.getString("userName");
            String password = entity.getString("password");
            String firstName = entity.getString("firstName");
            String lastName = entity.getString("lastName");
            String mailId = entity.getString("emailId");
            writer.print("<tr>" + "<td>" + firstName + "</td>" + "<td>"
                    + lastName + "</td>" + "<td>" + username + "</td>" + "<td>" + password + "</td>" + "<td>" + mailId
                    + "</td>" + "<tr>");
        }
        writer.print("</table>");
    }
}
