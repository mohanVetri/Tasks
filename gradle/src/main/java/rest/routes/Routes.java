package rest.routes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.api.HelloWorld;

@Path("demo")
public class Routes {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        HelloWorld HelloWorld = new HelloWorld("I am the data");
        return Response.ok(HelloWorld).build();
    }

}
