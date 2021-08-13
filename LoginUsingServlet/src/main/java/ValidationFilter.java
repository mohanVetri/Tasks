
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidationFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		response.setContentType("text/html");
		String password = request.getParameter("password");
		String name = request.getParameter("userName");
		if ("abc123".equals(password) && name != null && !name.equals("")) {
			chain.doFilter(request, response);
		} else {
			PrintWriter writer = response.getWriter();
			writer.println("Invalid Password or UserName...!");
			request.getRequestDispatcher("/login.html").include(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
