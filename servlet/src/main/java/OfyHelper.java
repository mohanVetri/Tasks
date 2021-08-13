import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class OfyHelper {
    static{
        ObjectifyService.factory().register(Student.class);
        ObjectifyService.factory().register(StudentDetails.class); 
    }

    public static Objectify ofy(){
        return ObjectifyService.ofy();
    }
 }
