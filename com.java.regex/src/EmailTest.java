import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmailTest {

        Email email=new Email();

    @Test
    public void test_EmailObject(){
        assertNotNull(email);
    }

    @Test
    public void test_IsMatchMethod(){
        assertTrue(email.isMatch("[abc]","a"));
    }

    @Test
    public void test_FindMethod(){
        assertTrue(email.findMethod("java","javalanguage"));
    }

    @Test
    public void test_StartMethod(){
        assertEquals(8,email.startMethod("java","languagejavalanguage"));
    }

    @Test
    public void test_EndMethod(){
        assertEquals(12,email.endMethod("java","languagejavalanguage"));
    }

    @Test
    public void test_GroupMethod(){
        assertEquals("java",email.groupMethod("java","javalanguage"));
    }

    @Test
    public void test_GroupCountMethod(){
        assertEquals(1,email.groupCountMethod("(java)","javalanguagejava"));
    }

    @Test
    public void test_EmailIsValid(){
        assertTrue(email.emailIsValid("^[a-z0-9+_.,-]+@[a-z]+.[a-z]+$","abcd123@gmail.com"));
    }
}
