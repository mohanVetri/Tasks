package rest.api;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cache.AsyncCacheFilter;
import com.googlecode.objectify.cmd.Query;
import com.googlecode.objectify.util.Closeable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rest.Entity.StudentDetails;
import rest.Objectify.OfyHelper;
import rest.classFile.Student;

public class RoutesTest {

    Routes routes = new Routes();

    LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    Closeable session;

    @Before
    public void setUp() {
        this.session = ObjectifyService.begin();
        this.helper.setUp();
    }

    @After
    public void tearDown() {
        AsyncCacheFilter.complete();
        this.session.close();
        this.helper.tearDown();
    }

    @Test
    public void test_status_getDataWithData() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(routes.getData().getStatus(), 200);
    }

    @Test
    public void test_entity_getDataWithData() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.getData();
        Query<StudentDetails> received = (Query<StudentDetails>) response.getEntity();
        assertEquals(received.list().size(), 1);
    }

    @Test
    public void test_status_getDataWithoutData() {
        assertEquals(routes.getData().getStatus(), 404);
    }

    @Test
    public void test_entity_getDataWithoutData() {
        assertEquals(routes.getData().getEntity(), "Records are not found!!");
    }

    @Test
    public void test_status_getSpecificStudentDetailWithData() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(routes.getSpecificStudentDetail(21).getStatus(), 200);
    }

    @Test
    public void test_entity_getSpecificStudentDetailWithData() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        StudentDetails received = (StudentDetails) routes.getSpecificStudentDetail(21).getEntity();
        assertEquals(received.name, "name");
        assertEquals(received.id, 1);
        assertEquals(received.registerNo, 21);
        assertEquals(received.password, "password");
        assertEquals(received.age, 23);
        assertEquals(received.marks, 100);
    }

    @Test
    public void test_status_getSpecificStudentDetailWithoutData() {
        assertEquals(routes.getSpecificStudentDetail(21).getStatus(), 404);
    }

    @Test
    public void test_entity_getSpecificStudentDetailWithoutData() {
        assertEquals(routes.getSpecificStudentDetail(21).getEntity(), "No such Student Details found!!!");
    }

    @Test
    public void test_status_postStudentDetail_ValidData() {
        Response response = routes.postStudentDetail(new Student("Mohan", 11, "password", 20, 98));
        assertEquals(response.getStatus(), 201);
    }

    @Test
    public void test_entity_postStudentDetail_ValidData() {
        Response response = routes.postStudentDetail(new Student("Mohan", 11, "password", 20, 98));
        StudentDetails received = (StudentDetails) response.getEntity();
        assertEquals(received.id, 1);
        assertEquals(received.name, "Mohan");
        assertEquals(received.registerNo, 11);
        assertEquals(received.password, "password");
        assertEquals(received.age, 20);
        assertEquals(received.marks, 98);
    }

    @Test
    public void test_status_postStudentDetail_ExistedData() {
        routes.postStudentDetail(new Student("Mohan", 11, "password", 20, 98));
        Response response = routes.postStudentDetail(new Student("Mohan", 11, "password", 20, 98));
        assertEquals(response.getStatus(), 302);
    }

    @Test
    public void test_entity_postStudentDetail_ExistedData() {
        routes.postStudentDetail(new Student("Mohan", 11, "password", 20, 98));
        Response response = routes.postStudentDetail(new Student("Mohan", 11, "password", 20, 98));
        assertEquals(response.getEntity(), "Student Register No is already existed!!");
    }

    @Test
    public void test_status_postStudentDetail_InvalidName() {
        Response response = routes.postStudentDetail(new Student(null, 11, "password", 20, 98));
        assertEquals(response.getStatus(), 406);
    }

    @Test
    public void test_entity_postStudentDetail_InvalidName() {
        Response response = routes.postStudentDetail(new Student(null, 11, "password", 20, 98));
        assertEquals(response.getEntity(), "Enter Valid Details");
    }

    @Test
    public void test_status_postStudentDetail_InvalidRegisterNo() {
        Response response = routes.postStudentDetail(new Student("Mohan", 0, "password", 20, 98));
        assertEquals(response.getStatus(), 406);
    }

    @Test
    public void test_entity_postStudentDetail_InvalidRegisterNo() {
        Response response = routes.postStudentDetail(new Student("Mohan", 0, "password", 20, 98));
        assertEquals(response.getEntity(), "Enter Valid Details");
    }

    @Test
    public void test_status_postStudentDetail_InvalidPassword() {
        Response response = routes.postStudentDetail(new Student("Mohan", 21, null, 20, 98));
        assertEquals(response.getStatus(), 406);
    }

    @Test
    public void test_entity_postStudentDetail_InvalidPassword() {
        Response response = routes.postStudentDetail(new Student("Mohan", 21, null, 20, 98));
        assertEquals(response.getEntity(), "Enter Valid Details");
    }

    @Test
    public void test_status_postStudentDetail_InvalidAge() {
        Response response = routes.postStudentDetail(new Student("Mohan", 21, "password", 0, 98));
        assertEquals(response.getStatus(), 406);
    }

    @Test
    public void test_entity_postStudentDetail_InvalidAge() {
        Response response = routes.postStudentDetail(new Student("Mohan", 21, "password", 0, 98));
        assertEquals(response.getEntity(), "Enter Valid Details");
    }

    @Test
    public void test_status_postStudentDetail_InvalidMarks() {
        Response response = routes.postStudentDetail(new Student("Mohan", 21, "password", 21, 0));
        assertEquals(response.getStatus(), 406);
    }

    @Test
    public void test_entity_postStudentDetail_InvalidMarks() {
        Response response = routes.postStudentDetail(new Student("Mohan", 21, "password", 21, 0));
        assertEquals(response.getEntity(), "Enter Valid Details");
    }

    @Test
    public void test_status_deleteStudentDetail_existedData() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.deleteStudentDetail(21);
        assertEquals(response.getStatus(),200);
    }

    @Test
    public void test_entity_deleteStudentDetail_existedData() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.deleteStudentDetail(21);
        assertEquals(response.getEntity(),"deleted Successfully");
    }

    @Test
    public void test_status_deleteStudentDetail_nonExistedData() {
        Response response = routes.deleteStudentDetail(21);
        assertEquals(response.getStatus(),404);
    }

    @Test
    public void test_entity_deleteStudentDetail_nonExistedData() {
        Response response = routes.deleteStudentDetail(21);
        assertEquals(response.getEntity(),"No such Student Details found!!!");
    }

    @Test
    public void test_status_updateStudentDetail_ExistedData(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student("Mohan", 21, "password", 21, 80));
        assertEquals(response.getStatus(), 200);
    }

    @Test
    public void test_entity_updateStudentDetail_ExistedData(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student("Mohan", 21, "password123", 21, 80));
        StudentDetails received= (StudentDetails) response.getEntity();
        assertEquals(received.id, 1);
        assertEquals(received.name, "Mohan");
        assertEquals(received.registerNo,21);
        assertEquals(received.password, "password123");
        assertEquals(received.age, 21);
        assertEquals(received.marks, 80);
    }

    @Test
    public void test_status_updateStudentDetail_nonExistedData(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(20,new Student("Mohan", 21, "password", 21, 80));
        assertEquals(response.getStatus(), 404);
    }

    @Test
    public void test_entity_updateStudentDetail_nonExistedData(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(20,new Student("Mohan", 21, "password", 21, 80));
        assertEquals(response.getEntity(), "Student RegisterNo is not existed");
    }

    @Test
    public void test_status_updateStudentDetail_existedRegisterNo(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "name", 20, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student("Mohan", 20, "password", 21, 80));
        assertEquals(response.getStatus(), 302);
    }

    @Test
    public void test_entity_updateStudentDetail_existedRegisterNo(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "name", 20, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student("Mohan", 20, "password", 21, 80));
        assertEquals(response.getEntity(), "Student RegisterNo is already existed");
    }

    @Test
    public void test_status_updateStudentDetail_nonexistedRegisterNo(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "name", 20, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student("Mohan", 22, "password", 21, 80));
        assertEquals(response.getStatus(), 200);
    }

    @Test
    public void test_entity_updateStudentDetail_nonexistedRegisterNo(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "name", 20, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student("Mohan", 22, "password123", 21, 80));
        StudentDetails received= (StudentDetails) response.getEntity();
        assertEquals(received.id, 1);
        assertEquals(received.name, "Mohan");
        assertEquals(received.registerNo,22);
        assertEquals(received.password, "password123");
        assertEquals(received.age, 21);
        assertEquals(received.marks, 80);
    }

    @Test
    public void test_statusAndEntity_updateStudentDetail_invalidName(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student(null, 22, "password123", 21, 80));
        assertEquals(406, response.getStatus());
        assertEquals("Enter Valid Details", response.getEntity());
    }

    @Test
    public void test_statusAndEntity_updateStudentDetail_invalidRegisterNo(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student("Mohan", 0, "password123", 21, 80));
        assertEquals(406, response.getStatus());
        assertEquals("Enter Valid Details", response.getEntity());
    }

    @Test
    public void test_statusAndEntity_updateStudentDetail_invalidPassword(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student("Mohan", 22, null, 21, 80));
        assertEquals(406, response.getStatus());
        assertEquals("Enter Valid Details", response.getEntity());
    }

    @Test
    public void test_statusAndEntity_updateStudentDetail_invalidAge(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student("Mohan", 22, "password", 0, 80));
        assertEquals(406, response.getStatus());
        assertEquals("Enter Valid Details", response.getEntity());
    }

    @Test
    public void test_statusAndEntity_updateStudentDetail_invalidMarks(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.updateStudentDetail(21,new Student("Mohan", 22, "password", 21, 0));
        assertEquals(406, response.getStatus());
        assertEquals("Enter Valid Details", response.getEntity());
    }

    @Test
    public void test_statusAndEntity_patchStudentDetail_nonExistedData(){
        Response response = routes.patchStudentDetail(21,new Student("Mohan", 22, "password", 21, 0));
        assertEquals(404, response.getStatus());
        assertEquals("Student RegisterNo is not existed", response.getEntity());
    }

    @Test
    public void test_statusAndEntity_patchStudentDetail_ExistedData(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.patchStudentDetail(21,new Student("Mohan", 21, "password123", 21, 80));
        assertEquals(200, response.getStatus());
        StudentDetails received= (StudentDetails) response.getEntity();
        assertEquals("Mohan", received.name);
        assertEquals(1, received.id);
        assertEquals(21, received.registerNo);
        assertEquals("password123", received.password);
        assertEquals(21, received.age);
        assertEquals(80, received.marks);
    }

    @Test
    public void test_statusAndEntity_patchStudentDetail_name(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.patchStudentDetail(21,new Student("Mohan", 0, null, 0, 0));
        assertEquals(200, response.getStatus());
        StudentDetails received= (StudentDetails) response.getEntity();
        assertEquals("Mohan", received.name);
        assertEquals(1, received.id);
        assertEquals(21, received.registerNo);
        assertEquals("password", received.password);
        assertEquals(23, received.age);
        assertEquals(100, received.marks);
    }

    @Test
    public void test_statusAndEntity_patchStudentDetail_registerNo(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.patchStudentDetail(21,new Student(null, 22, null, 0, 0));
        assertEquals(200, response.getStatus());
        StudentDetails received= (StudentDetails) response.getEntity();
        assertEquals("name", received.name);
        assertEquals(1, received.id);
        assertEquals(22, received.registerNo);
        assertEquals("password", received.password);
        assertEquals(23, received.age);
        assertEquals(100, received.marks);
    }

    @Test
    public void test_statusAndEntity_patchStudentDetail_existedRegisterNo(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "name", 22, "password", 23, 100)).now();
        Response response = routes.patchStudentDetail(21,new Student(null, 22, null, 0, 0));
        assertEquals(302, response.getStatus());
        assertEquals("Student RegisterNo is already existed", response.getEntity());
    }


    @Test
    public void test_statusAndEntity_patchStudentDetail_password(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.patchStudentDetail(21,new Student(null, 0, "password123", 0, 0));
        assertEquals(200, response.getStatus());
        StudentDetails received= (StudentDetails) response.getEntity();
        assertEquals("name", received.name);
        assertEquals(1, received.id);
        assertEquals(21, received.registerNo);
        assertEquals("password123", received.password);
        assertEquals(23, received.age);
        assertEquals(100, received.marks);
    }

    @Test
    public void test_statusAndEntity_patchStudentDetail_age(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.patchStudentDetail(21,new Student(null, 0, null, 20, 0));
        assertEquals(200, response.getStatus());
        StudentDetails received= (StudentDetails) response.getEntity();
        assertEquals("name", received.name);
        assertEquals(1, received.id);
        assertEquals(21, received.registerNo);
        assertEquals("password", received.password);
        assertEquals(20, received.age);
        assertEquals(100, received.marks);
    }

    @Test
    public void test_statusAndEntity_patchStudentDetail_marks(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        Response response = routes.patchStudentDetail(21,new Student(null, 0, null, 0, 90));
        assertEquals(200, response.getStatus());
        StudentDetails received= (StudentDetails) response.getEntity();
        assertEquals("name", received.name);
        assertEquals(1, received.id);
        assertEquals(21, received.registerNo);
        assertEquals("password", received.password);
        assertEquals(23, received.age);
        assertEquals(90, received.marks);
    }












}
