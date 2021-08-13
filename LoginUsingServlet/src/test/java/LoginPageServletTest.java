import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LoginPageServletTest {
    @Mock
    HttpServletRequest requestWithSession;

    @Mock
    HttpServletRequest requestWithoutSession;

    @Mock
    HttpServletResponse responseWithSession;

    @Mock
    HttpServletResponse responseWithoutSession;

    @Mock 
    HttpSession session;

    @Mock
    RequestDispatcher requestDispatcher;

    StringWriter stringWriter=new StringWriter();
	PrintWriter writer=new PrintWriter(stringWriter);

    @Before
    public void before() throws IOException, ServletException{
        MockitoAnnotations.initMocks(this);
		when(requestWithoutSession.getSession(false)).thenReturn(null);
		when(responseWithoutSession.getWriter()).thenReturn(writer);
		when(requestWithoutSession.getRequestDispatcher("/login.html")).thenReturn(requestDispatcher);
		when(requestWithSession.getSession(false)).thenReturn(session);
		when(responseWithSession.getWriter()).thenReturn(writer);
		when(requestWithSession.getRequestDispatcher("/index.html")).thenReturn(requestDispatcher);
    }

    
	@Test
	public void test_RequestDispatcher_WithoutSession() throws ServletException, IOException {
        new LoginPageServlet().doPost(requestWithoutSession, responseWithoutSession);
		verify(requestDispatcher).include(requestWithoutSession,responseWithoutSession);
	}

	@Test
	public void test_getWriter_WithoutSession() throws IOException, ServletException {
        new LoginPageServlet().doPost(requestWithoutSession, responseWithoutSession);
		verify(responseWithoutSession,times(0)).getWriter();
	}

	@Test
	public void test_Output_WithoutSession() throws IOException, ServletException {
        new LoginPageServlet().doPost(requestWithoutSession, responseWithoutSession);
		assertEquals("",stringWriter.getBuffer().toString().trim());
	}

    @Test
	public void test_getWriter_WithSession() throws IOException, ServletException {
        new LoginPageServlet().doPost(requestWithSession, responseWithSession);
		verify(responseWithSession).getWriter();
	}
	
	@Test
	public void test_RequestDispatcher_WithSession() throws ServletException, IOException {
        new LoginPageServlet().doPost(requestWithSession, responseWithSession);
		verify(requestDispatcher).include(requestWithSession, responseWithSession);
	}
	
	@Test
	public void test_Output_WithSession() throws IOException, ServletException {
        new LoginPageServlet().doPost(requestWithSession, responseWithSession);
		assertEquals("you are already logged in",stringWriter.getBuffer().toString().trim());
	}
	
}
