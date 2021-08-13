import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class AlphabetTest {

        Alphabet alphabet = new Alphabet();
    
    @Test
    public void test_AlphabetObject_NotNull(){
        assertNotNull(alphabet);
    }

    @Test
    public void test_ConcatMethod_ReturnsString(){
        assertTrue(String.class.isInstance(Alphabet.concatMethod()));   //Static Method is accessed without creating object
    }

    @Test
    public void test_ConcatMethod(){
        assertEquals("java language.",Alphabet.concatMethod());        //Static Method is accessed without creating object 
    }

    @Test
    public void test_SubStringMethodWithIndex_ReturnsString(){
        assertTrue(String.class.isInstance(alphabet.subStringMethodWithIndex()));
    }

    @Test
    public void test_SubStringMethodWithIndex(){
        assertEquals("language",alphabet.subStringMethodWithIndex());
    }

    @Test
    public void test_SubStringMethodWithTwoIndex_ReturnsString(){
        assertTrue(String.class.isInstance(alphabet.subStringMethodWithTwoIndex()));
    }

    @Test
    public void test_SubStringMethodWithTwoIndex(){
        assertEquals("lan",alphabet.subStringMethodWithTwoIndex());
    }

    @Test
    public void test_TrimMethod_ReturnsString(){
        assertTrue(String.class.isInstance(alphabet.trimMethod()));
    }

    @Test
    public void test_TrimMethod(){
        assertEquals("java language",alphabet.trimMethod());
    }

    @Test
    public void test_CharAtMethod_ReturnsChar(){
        assertTrue(Character.class.isInstance(alphabet.charAtMethod(2)));
    }

    @Test
    public void test_CharAtMethod(){
        assertEquals('v',alphabet.charAtMethod(2));
    }

    @Test
    public void test_EqualsMethod_ReturnsBoolean(){
        assertTrue(Boolean.class.isInstance(alphabet.equalsMethod(Alphabet.word)));       //static variable accessed without creating object
    }

    @Test
    public void test_EqualsMethod(){
        assertTrue(alphabet.equalsMethod("java language"));
    }

    @Test
    public void test_ReplaceMethod_ReturnsString(){
        assertTrue(String.class.isInstance(alphabet.replaceMethod("v","b")));
    }

    @Test
    public void test_ReplaceMethod(){
        assertEquals("jaba language",alphabet.replaceMethod("v","b"));
    }

    @Test
    public void test_SplitMethod(){
        assertArrayEquals(new String[] { "hi", "how", "are you" }, alphabet.splitMethod());
    }

}
