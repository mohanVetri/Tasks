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
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

@WebServlet(value = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        request.getRequestDispatcher("registration.html").include(request, response);
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("emailId");
        boolean notExist = true;
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("StudentDetails").build();
        QueryResults<Entity> queryResults = datastore.run(query);
        if (queryResults.hasNext()) {
            Entity entity = queryResults.next();
            if (entity.getString("userName").equals(userName)) {
                writer.println("UserName is Already existed");
                notExist = false;
            } else if (entity.getString("emailId").equals(email)) {
                writer.println("EmailId is Already existed");
                notExist = false;
            }
        }
        // if(!list.isEmpty()){
        // for(StudentsDetails details: list){
        // if(userName.equals(details.userName)){
        // writer.println("UserName is Already existed");
        // notExist=false;
        // }
        // else if (email.equals(details.emailId)){
        // writer.println("EmailId is Already existed");
        // notExist=false;
        // }
        // }
        // }

        if (notExist) {
            KeyFactory keyFactory = datastore.newKeyFactory().setKind("StudentDetails");
            FullEntity<IncompleteKey> messageEntity = Entity.newBuilder(keyFactory.newKey()).set("userName", userName)
                    .set("password", password).set("firstName", firstName).set("lastName", lastName)
                    .set("emailId", email).build();
            datastore.put(messageEntity);

            writer.println("You are successfully registered!!.Now You can login with your UserName and Password");
        }
    }
}
