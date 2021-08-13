import java.util.Calendar;
import java.util.Date;

public class Calendarclass {

    public Calendar getCalendarObject() {
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }

    public Date addMethod() {
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MONTH, 4);
        calendar.add(Calendar.YEAR, 2);
        calendar.add(Calendar.DATE, 3);
		return calendar.getTime();
	}

	public int getYear() {
		Calendar calendar=Calendar.getInstance();
        return calendar.get(Calendar.YEAR);     // we can also get day ,date ,minute and second by using get method
	}

	public Date setFieldMethod() {
		Calendar calendar=Calendar.getInstance();
        calendar.set(2022, 6, 22, 12, 40, 23);
        System.out.println(calendar.getTime().toString());
        return calendar.getTime();
	}

	public int getMaximum_WeekOfYear() {
        Calendar calendar =Calendar.getInstance();
		return calendar.getMaximum(Calendar.WEEK_OF_YEAR);
	}

	public int getMinimum_WeekOfYear() {
		Calendar calendar=Calendar.getInstance();
        return calendar.getMinimum(Calendar.WEEK_OF_YEAR);
	}
    
}
