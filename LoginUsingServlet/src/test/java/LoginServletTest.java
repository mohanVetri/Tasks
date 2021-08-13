import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LoginServletTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    StringWriter stringWriter=new StringWriter();
    PrintWriter printWriter=new PrintWriter(stringWriter);

    @Before
    public void setUp() throws ServletException, IOException{
        MockitoAnnotations.initMocks(this);
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("userName")).thenReturn("mohan");
        new LoginServlet().doPost(request, response);
    }
    
    @Test
	public void test_SendRedirect() throws IOException ,ServletException {
		verify(response).sendRedirect("successful");;
		
	}
	
	@Test
	public void test_GetParameter_UserName() {
		verify(request).getParameter("userName");
	}
	
	@Test
	public void test_GetSession() {
		verify(session).setAttribute("name", "mohan");
	}
}
