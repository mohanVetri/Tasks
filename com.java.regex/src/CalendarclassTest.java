import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;

public class CalendarclassTest {
    Calendarclass calendarclass=new Calendarclass();

    @Test
    public void test_CalendarclassObject_NotNull(){
        assertNotNull(calendarclass);
    }

    @Test
    public void test_GetCalendarObject_NotNull(){
        assertNotNull(calendarclass.getCalendarObject());
    }

    @Test
    public void test_AddMethod(){
        Calendar calendar=Calendar.getInstance();
        calendar.set(2023, 5, 26);
        assertEquals(calendar.getTime().toString(),calendarclass.addMethod().toString());
    }

    @Test
    public void test_GetYear(){
        assertEquals(2021,calendarclass.getYear());
    }

    @Test
    public void test_setMethod(){
        assertEquals("Fri Jul 22 12:40:23 IST 2022",calendarclass.setFieldMethod().toString());
    }

    @Test
    public void test_getMaximum_WeekOfYear(){
        assertEquals(53,calendarclass.getMaximum_WeekOfYear());
    }

    @Test
    public void test_getMinimum_WeekOfYear(){
        assertEquals(1,calendarclass.getMinimum_WeekOfYear());
    }
}
