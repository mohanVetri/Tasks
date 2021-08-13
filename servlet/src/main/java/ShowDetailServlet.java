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
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

@WebServlet(value = "/showDetails")
public class ShowDetailServlet extends HttpServlet {

    static Key key;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session != null) {
            String userName = (String) session.getAttribute("name");

            Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

            Query<Entity> query = Query.newEntityQueryBuilder().setFilter(PropertyFilter.eq("userName", userName))
                    .setKind("StudentDetails").build();
            QueryResults<Entity> results = datastore.run(query);


            while (results.hasNext()) {
                Entity entity = results.next();
                String username = entity.getString("userName");
                String password = entity.getString("password");
                String firstName = entity.getString("firstName");
                String lastName = entity.getString("lastName");
                String mailId = entity.getString("emailId");
                key = entity.getKey();
                writer.println("<table border=\"1\">" + "<tr>" + "<td> FirstName: </td>" + "<td>" + firstName + "</td>" + "</tr>" +

                        "<tr>" + "<td> LastName: </td>" + "<td>" + lastName + "</td>" + "</tr>" +

                        "<tr>" + "<td> userName: </td>" + "<td>" + username + "</td>" + "</tr>" +

                        "<tr>" + "<td> Password: </td>" + "<td>" + password + "</td>" + "</tr>" +

                        "<tr>" + "<td> MailId: </td>" + "<td>" + mailId + "</td>" + "</tr>" +

                        "</table><br>");
            }

            writer.println("<a href=\"/editDetails\"><button>Edit</button></a>");
            ;

        }
        else{
            writer.println("Register First!!<br>");
            writer.println("<a href=\"loginPage\"><button>go to loginPage</button></a>");
        }

    }
}
