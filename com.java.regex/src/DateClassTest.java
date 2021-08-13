import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

public class DateClassTest {

    DateClass dateClass=new DateClass();

    @Test
    public void test_DateClassObject_NotNull(){
        assertNotNull(dateClass);
    }

    @Test
    public void test_getDateObject(){
        Date date=new Date();
        assertEquals(date, dateClass.getDateObject());
    }
    
    @Test
    public void test_CloneMethod(){
        Date date=new Date();
        assertEquals(date,dateClass.cloneMethod());
    }
}
