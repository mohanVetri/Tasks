import java.util.Date;

public class DateClass {

	public Date getDateObject() {
		Date date=new Date();
        System.out.println(date);
        return date;
	}

	public Object cloneMethod() {
		Date date=new Date();
        Date clonedDate=(Date) date.clone();
        System.out.println(date);
       return clonedDate;
	}

}
