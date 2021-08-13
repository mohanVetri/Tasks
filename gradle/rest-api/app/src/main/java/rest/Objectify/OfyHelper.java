package rest.Objectify;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import rest.Entity.StudentDetails;

public class OfyHelper {
    static {
        // ObjectifyInitializer.initilize_objectify();
        ObjectifyService.factory().register(StudentDetails.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }
}
