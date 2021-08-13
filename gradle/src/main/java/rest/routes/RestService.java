package rest.routes;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class RestService extends Application{
    private Set<Object> singletons= new HashSet<Object>();

    public RestService(){
        this.singletons.add( new Routes());
    }
    @Override
    public Set<Object> getSingletons() {
        return super.getSingletons();
    }
}
