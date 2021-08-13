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

public class ProfileServletTest {
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
    public void setUp() throws IOException{
        MockitoAnnotations.initMocks(this);
        when(responseWithSession.getWriter()).thenReturn(writer);
        when(responseWithoutSession.getWriter()).thenReturn(writer);
		when(requestWithoutSession.getSession(false)).thenReturn(null);
        when(requestWithSession.getSession(false)).thenReturn(session);
        when(session.getAttribute("name")).thenReturn("mohan");
        when(requestWithoutSession.getRequestDispatcher("/login.html")).thenReturn(requestDispatcher);
        when(requestWithoutSession.getRequestDispatcher("/index.html")).thenReturn(requestDispatcher);
        when(requestWithSession.getRequestDispatcher("/index.html")).thenReturn(requestDispatcher);
    }
    @Test
	public void test_GetWriter_WithoutSession() throws IOException, ServletException {
        new ProfileServlet().doPost(requestWithoutSession, responseWithoutSession);
		verify(responseWithoutSession).getWriter();
	}
	
	@Test
	public void test_RequestDispatcher_WithoutSession() throws ServletException, IOException {
        new ProfileServlet().doPost(requestWithoutSession, responseWithoutSession);
		verify(requestDispatcher, times(2)).include(requestWithoutSession, responseWithoutSession);
	}
	
	@Test
	public void test_Output_WithoutSession() throws ServletException, IOException {
        new ProfileServlet().doPost(requestWithoutSession, responseWithoutSession);
		assertEquals("login first!",stringWriter.getBuffer().toString().trim());
	}

    @Test
	public void test_GetWriter_WithSession() throws IOException, ServletException {
        new ProfileServlet().doPost(requestWithSession, responseWithSession);
		verify(responseWithSession,times(1)).getWriter();
	}
	
	@Test
	public void test_RequestDispatcher_WithSession() throws ServletException, IOException {
        new ProfileServlet().doPost(requestWithSession, responseWithSession);
		verify(requestDispatcher,times(1)).include(requestWithSession, responseWithSession);
	}
	
	@Test
	public void test_GetAttribute() throws ServletException, IOException {
        new ProfileServlet().doPost(requestWithSession, responseWithSession);
		verify(session).getAttribute("name");
	}
	
	@Test
	public void test_Output_WithSession() throws ServletException, IOException {
        new ProfileServlet().doPost(requestWithSession, responseWithSession);
		assertEquals("Welcome mohan",stringWriter.getBuffer().toString().trim());
	}

}
