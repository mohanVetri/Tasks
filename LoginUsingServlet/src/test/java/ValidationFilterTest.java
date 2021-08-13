import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ValidationFilterTest {
    @Mock
    ServletRequest requestWithValidParameter;

    @Mock
    ServletRequest requestWithInvalidParameter;

    @Mock
    ServletResponse responseWithValidParameter;

    @Mock
    ServletResponse responseWithInvalidParameter;

    @Mock
    RequestDispatcher requestDispatcher;

    @Mock
    FilterChain chain;

    StringWriter stringWriter=new StringWriter();
	PrintWriter writer=new PrintWriter(stringWriter);

    @Before
    public void setUp() throws IOException{
        MockitoAnnotations.initMocks(this);
        when(responseWithInvalidParameter.getWriter()).thenReturn(writer);
        when(requestWithValidParameter.getParameter("userName")).thenReturn("anything");
        when(requestWithValidParameter.getParameter("password")).thenReturn("abc123");
        when(requestWithInvalidParameter.getParameter("userName")).thenReturn(null);
        when(requestWithInvalidParameter.getParameter("password")).thenReturn("null");
        when(requestWithInvalidParameter.getRequestDispatcher("/login.html")).thenReturn(requestDispatcher);
    }

    @Test
    public void test_doChain_ValidParameters() throws IOException, ServletException{
        new ValidationFilter().doFilter(requestWithValidParameter, responseWithValidParameter, chain);
        verify(chain,times(1)).doFilter(requestWithValidParameter, responseWithValidParameter);
    }
    @Test
    public void test_RequestDispatcher_WithInvalidParameter() throws IOException, ServletException{
        new ValidationFilter().doFilter(requestWithInvalidParameter, responseWithInvalidParameter, chain);
        verify(requestDispatcher,times(1)).include(requestWithInvalidParameter,responseWithInvalidParameter);
    }

    @Test
    public void test_Output_WithInvalidParameter() throws IOException, ServletException{
        new ValidationFilter().doFilter(requestWithInvalidParameter, responseWithInvalidParameter, chain);
        assertEquals("Invalid Password or UserName...!", stringWriter.getBuffer().toString().trim());
    }
}
