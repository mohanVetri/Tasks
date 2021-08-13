import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setContentType("text/html");
        PrintWriter writer=response.getWriter();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            writer.println("Successfully logged out!!");
        }
        else{
            writer.println("Register First!!<br>");
            writer.println("<a href=\"loginPage\"><button>go to loginPage</button></a>");
        }

    }
}
