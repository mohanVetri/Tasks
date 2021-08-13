package rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import rest.classFile.Student;
import rest.classFile.Validation;
import rest.Entity.CrudOperation;

@Path("/Student")
public class Routes {
    Validation validation= new Validation();
    CrudOperation crudOperation= new CrudOperation();
    static long id = 0;

    @GET
    @Path("/All")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        if (crudOperation.getAllEntities() != null) {
            return Response.status(200).status(Status.OK).entity(crudOperation.getAllEntities()).build();
        } else
            return Response.status(Status.NOT_FOUND).entity("Records are not found!!").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificStudentDetail(@PathParam("id") int id) {
        if (crudOperation.getEntity(id) != null)
            return Response.ok(crudOperation.getEntity(id)).build();
        else
            return Response.status(Status.NOT_FOUND).entity("No such Student Details found!!!").build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postStudentDetail(Student student) {
        if (validation.isValid(student)) {
            if (crudOperation.getEntity(student.registerNo) != null)
                return Response.status(Status.FOUND).entity("Student Register No is already existed!!").build();
            else {
                crudOperation.addEntity(++id, student);
                return Response.status(Status.CREATED).entity(crudOperation.getEntity(student.registerNo)).build();
            }
        } else
            return Response.status(Status.NOT_ACCEPTABLE).entity("Enter Valid Details").build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudentDetail(@PathParam("id") int id) {
        if (crudOperation.getEntity(id) != null) {
            crudOperation.deleteEntity(crudOperation.getEntity(id));
            return Response.ok("deleted Successfully").build();
        } else
            return Response.status(Status.NOT_FOUND).entity("No such Student Details found!!!").build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudentDetail(@PathParam("id") int id, Student student) {
        if (validation.isValid(student)) {
            if (crudOperation.getEntity(id) != null) {
                if (validation.isNotExist(student.registerNo, id)) {
                    crudOperation.updateEntity(crudOperation.getEntity(id).id, student);
                    return Response.ok(crudOperation.getEntity(student.registerNo)).status(Status.OK).build();
                } else
                    return Response.status(302).entity("Student RegisterNo is already existed").build();
            }    else {
                return Response.status(404).entity("Student RegisterNo is not existed").build();
            }
        } else
            return Response.status(Status.NOT_ACCEPTABLE).entity("Enter Valid Details").build();
    }

    @PATCH
    @Path("/patch/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response patchStudentDetail(@PathParam("id") int id, Student student) {
        if (crudOperation.getEntity(id) != null) {
            if (validation.isNotExist(student.registerNo != 0 ? student.registerNo : id, id)) {
                crudOperation.patchEntity(crudOperation.getEntity(id), student);
                return Response.ok(crudOperation.getEntity(student.registerNo != 0 ? student.registerNo : id))
                        .status(Status.OK).build();
            } else
                return Response.status(302).entity("Student RegisterNo is already existed").build();
        } else {
            return Response.status(404).entity("Student RegisterNo is not existed").build();
        }
    }
}