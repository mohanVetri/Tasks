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
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.Key;

@WebServlet(value = "/update")
public class UpdateDetailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session != null) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String emailId = request.getParameter("emailId");

            Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
            FullEntity<Key> messageEntity = Entity.newBuilder(ShowDetailServlet.key).set("userName", userName)
                    .set("password", password).set("firstName", firstName).set("lastName", lastName)
                    .set("emailId", emailId).build();
            datastore.put(messageEntity);

            writer.println("Updated Successfully");
        } else {
            writer.println("Register First!!<br>");
            writer.println("<a href=\"loginPage\"><button>go to loginPage</button></a>");
        }
    }
}
