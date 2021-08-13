import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CircleTest {
    @Test
    public void test_CircleObject_NotNull(){
        Shape circle=new Circle();
        assertNotNull(circle);
    }

    @Test
    public void test_Draw_ReturnsString(){
        Shape circle =new Circle();
        assertTrue(String.class.isInstance((circle.draw())));
    }

    @Test
    public void test_Draw(){
        Shape circle =new Circle();
        assertEquals("Circle",circle.draw());
    }
}
