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
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

@WebServlet(value = "/editDetails")
public class EditDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

        HttpSession session = request.getSession(false);
        if (session != null) {

            String userName = (String) session.getAttribute("name");
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
                writer.println("<form action=\"update\" method=\"POST\"><table>" + "<tr>" + "<td> FirstName: <td>"
                        + "<td> <input type=\"text\" name=\"firstName\" value=" + firstName + "></td>" + "<tr>" +

                        "<tr>" + "<td> LastName: <td>" + "<td> <input type=\"text\" name=\"lastName\" value=" + lastName
                        + "></td>" + "<tr>" +

                        "<tr>" + "<td> userName: <td>" + "<td> <input type=\"text\" name=\"userName\" value=" + username
                        + " readonly></td>" + "<tr>" +

                        "<tr>" + "<td> Password: <td>" + "<td> <input type=\"text\" name=\"password\" value=" + password
                        + " readonly></td>" + "<tr>" +

                        "<tr>" + "<td> MailId: <td>" + "<td> <input type=\"text\" name=\"emailId\" value=" + mailId
                        + " readonly></td>" + "<tr></table>" +

                        "<input type=\"submit\" value=\"Update\"/>" +

                        "</form>");
            }

        }
        else{
            writer.println("Register First!!<br>");
            writer.println("<a href=\"loginPage\"><button>go to loginPage</button></a>");
        }

    }
}
