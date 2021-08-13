import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdditionTest {
    @Test
    public void test_AdditionObject_NotNull(){
        Addition addition=new Addition(0);
        assertNotNull(addition);
    }

    @Test
    public void test_Add_TwoParam_ReturnsInteger(){
        Addition addition=new Addition(0);
        assertTrue(Integer.class.isInstance(addition.add(1,3)));
    }

    @Test
    public void test_Add_TwoParam(){
        Addition addition=new Addition(0);
        assertEquals(4,addition.add(1,3));
    }

    @Test
    public void test_Add_ThreeParam_ReturnsInteger(){
        Addition addition=new Addition(0);
        assertTrue(Integer.class.isInstance(addition.add(1,3,4)));
    }

    @Test
    public void test_Add_ThreeParam(){
        Addition addition=new Addition(0);
        assertEquals(8,addition.add(1,3,4));
    }
}
