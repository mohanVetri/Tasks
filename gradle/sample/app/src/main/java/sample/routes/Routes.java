package sample.routes;

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

import sample.classFile.Student;
import sample.classFile.Validation;
import sample.Entity.CrudOperation;

@Path("/Student")
public class Routes {
    static long id = 0;

    @GET
    @Path("/All")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        if (CrudOperation.getAllEntities() != null) {
            return Response.status(200).status(Status.OK).entity(CrudOperation.getAllEntities()).build();
        } else
            return Response.status(Status.NOT_FOUND).entity("Records are not found!!").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificStudentDetail(@PathParam("id") int id) {
        if (CrudOperation.getEntity(id) != null)
            return Response.ok(CrudOperation.getEntity(id)).build();
        else
            return Response.status(Status.NOT_FOUND).entity("No such Student Details found!!!").build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postStudentDetail(Student student) {
        if (Validation.isValid(student)) {
            if (CrudOperation.getEntity(student.registerNo) != null)
                return Response.status(Status.FOUND).entity("Student Register No is already existed!!").build();
            else {
                CrudOperation.addEntity(++id, student);
                return Response.status(Status.CREATED).entity(student).build();
            }
        } else
            return Response.status(Status.NOT_ACCEPTABLE).entity("Enter Valid Details").build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudentDetail(@PathParam("id") int id) {
        if (CrudOperation.getEntity(id) != null) {
            CrudOperation.deleteEntity(CrudOperation.getEntity(id));
            return Response.ok("deleted Successfully").build();
        } else
            return Response.status(Status.NOT_FOUND).entity("No such Student Details found!!!").build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudentDetail(@PathParam("id") int id, Student student) {
        if (Validation.isValid(student)) {
            if (CrudOperation.getEntity(id) != null) {
                if (Validation.isNotExist(student.registerNo, id)) {
                    CrudOperation.updateEntity(CrudOperation.getEntity(id).id, student);
                    return Response.ok(CrudOperation.getEntity(student.registerNo)).status(Status.OK).build();
                } else
                    return Response.status(302).entity("Student RegisterNo is already existed").build();
            } else {
                return Response.status(404).entity("Student RegisterNo is not existed").build();
            }
        } else
            return Response.status(Status.NOT_ACCEPTABLE).entity("Enter Valid Details").build();
    }

    @PATCH
    @Path("/patch/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response patchStudentDetail(@PathParam("id") int id, Student student) {
        if (CrudOperation.getEntity(id) != null) {
            if (Validation.isNotExist(student.registerNo != 0 ? student.registerNo : id, id)) {
                CrudOperation.patchEntity(CrudOperation.getEntity(id), student);
                return Response.ok(CrudOperation.getEntity(student.registerNo != 0 ? student.registerNo : id))
                        .status(Status.OK).build();
            } else
                return Response.status(302).entity("Student RegisterNo is already existed").build();
        } else {
            return Response.status(404).entity("Student RegisterNo is not existed").build();
        }
    }
}
