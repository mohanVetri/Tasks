package rest.Entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cache.AsyncCacheFilter;
import com.googlecode.objectify.util.Closeable;
import com.googlecode.objectify.cmd.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rest.Objectify.OfyHelper;
import rest.classFile.Student;

public class CrudOperationTest {

    CrudOperation crudOperation= new CrudOperation();

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
    public void test_id_getEntity_ReturnsEntity() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(crudOperation.getEntity(21).id, 1);
    }

    @Test
    public void test_name_getEntity_ReturnsEntity() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "Mohan", 21, "password", 23, 100)).now();
        assertEquals(crudOperation.getEntity(21).name, "Mohan");
    }

    @Test
    public void test_registerNo_getEntity_ReturnsEntity() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(crudOperation.getEntity(21).registerNo, 21);
    }

    @Test
    public void test_password_getEntity_ReturnsEntity() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(crudOperation.getEntity(21).password, "password");
    }

    @Test
    public void test_age_getEntity_ReturnsEntity() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(crudOperation.getEntity(21).age, 23);
    }

    @Test
    public void test_marks_getEntity_ReturnsEntity() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(crudOperation.getEntity(21).marks, 100);
    }

    @Test
    public void test_getEntity_ReturnsNull() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertNull(crudOperation.getEntity(20));
    }

    @Test
    public void test_getAllEntities_ReturnsNull() {
        assertNull(crudOperation.getAllEntities());
    }

    @Test
    public void test_size_getAllEntities() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "name", 24, "password", 23, 100)).now();
        assertEquals(crudOperation.getAllEntities().list().size(), 2);
    }

    @Test
    public void test_firstElement_getAllEntities() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "mohan", 24, "password123", 25, 98)).now();
        assertEquals(crudOperation.getAllEntities().list().get(0).id, 1);
        assertEquals(crudOperation.getAllEntities().list().get(0).name, "name");
        assertEquals(crudOperation.getAllEntities().list().get(0).registerNo, 21);
        assertEquals(crudOperation.getAllEntities().list().get(0).password, "password");
        assertEquals(crudOperation.getAllEntities().list().get(0).age, 23);
        assertEquals(crudOperation.getAllEntities().list().get(0).marks, 100);
    }

    @Test
    public void test_secondElement_getAllEntities() {
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "mohan", 24, "password123", 25, 98)).now();
        assertEquals(crudOperation.getAllEntities().list().get(1).id, 2);
        assertEquals(crudOperation.getAllEntities().list().get(1).name, "mohan");
        assertEquals(crudOperation.getAllEntities().list().get(1).registerNo, 24);
        assertEquals(crudOperation.getAllEntities().list().get(1).password, "password123");
        assertEquals(crudOperation.getAllEntities().list().get(1).age, 25);
        assertEquals(crudOperation.getAllEntities().list().get(1).marks, 98);
    }

    @Test
    public void test_addEntity_sizeAfterAddingOneEntity() {
        crudOperation.addEntity(1, new Student("Mohan", 21, "password123", 23, 100));
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class);
        assertEquals(query.list().size(), 1);
    }

    @Test
    public void test_addEntity_sizeAfterAddingTwoEntity() {
        crudOperation.addEntity(1, new Student("Mohan", 21, "password123", 23, 100));
        crudOperation.addEntity(2, new Student("prem", 22, "password123", 23, 100));
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class);
        assertEquals(query.list().size(), 2);
    }

    @Test
    public void test_addEntity_WithGetEntity() {
        crudOperation.addEntity(1, new Student("Mohan", 21, "password123", 23, 100));
        assertNotNull(crudOperation.getEntity(21));
        assertEquals(crudOperation.getEntity(21).name, "Mohan");
        assertEquals(crudOperation.getEntity(21).registerNo, 21);
        assertEquals(crudOperation.getEntity(21).password, "password123");
        assertEquals(crudOperation.getEntity(21).age, 23);
        assertEquals(crudOperation.getEntity(21).marks, 100);
    }

    @Test
    public void test_updateEntity_WithName() {
        crudOperation.addEntity(1, new Student("Student", 22, "password", 23, 98));
        crudOperation.updateEntity(1, new Student("Mohan", 22, "password123", 23, 100));
        assertEquals(crudOperation.getEntity(22).name, "Mohan");
    }

    @Test
    public void test_updateEntity_WithRegisterNo() {
        crudOperation.addEntity(1, new Student("Student", 22, "password", 23, 98));
        crudOperation.updateEntity(1, new Student("Mohan", 22, "password123", 23, 100));
        assertEquals(crudOperation.getEntity(22).registerNo, 22);
    }

    @Test
    public void test_updateEntity_WithPassword() {
        crudOperation.addEntity(1, new Student("Student", 22, "password", 23, 98));
        crudOperation.updateEntity(1, new Student("Mohan", 22, "password123", 23, 100));
        assertEquals(crudOperation.getEntity(22).password, "password123");
    }

    @Test
    public void test_updateEntity_WithAge() {
        crudOperation.addEntity(1, new Student("Student", 22, "password", 23, 98));
        crudOperation.updateEntity(1, new Student("Mohan", 22, "password123", 23, 100));
        assertEquals(crudOperation.getEntity(22).age, 23);
    }

    @Test
    public void test_updateEntity_WithMarks() {
        crudOperation.addEntity(1, new Student("Student", 22, "password", 23, 98));
        crudOperation.updateEntity(1, new Student("Mohan", 22, "password123", 23, 100));
        assertEquals(crudOperation.getEntity(22).marks, 100);
    }

    @Test
    public void test_patchEntity_updatingOnlyName(){
        crudOperation.addEntity(1, new Student("Student", 22, "password", 23, 98));
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class).filter("registerNo =", 22);
        crudOperation.patchEntity(query.list().get(0), new Student("Mohan", 0, null, 0, 0));
        assertEquals(crudOperation.getEntity(22).name,"Mohan");
        assertEquals(crudOperation.getEntity(22).registerNo,22);
        assertEquals(crudOperation.getEntity(22).password,"password");
        assertEquals(crudOperation.getEntity(22).age,23);
        assertEquals(crudOperation.getEntity(22).marks,98);
    }

    @Test
    public void test_patchEntity_updatingOnlyRegisterNo(){
        crudOperation.addEntity(1, new Student("Student", 22, "password", 23, 98));
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class).filter("registerNo =", 22);
        crudOperation.patchEntity(query.list().get(0), new Student(null, 21, null, 0, 0));
        assertNull(crudOperation.getEntity(22));
        assertEquals(crudOperation.getEntity(21).name,"Student");
        assertEquals(crudOperation.getEntity(21).registerNo,21);
        assertEquals(crudOperation.getEntity(21).password,"password");
        assertEquals(crudOperation.getEntity(21).age,23);
        assertEquals(crudOperation.getEntity(21).marks,98);
    }

    @Test
    public void test_patchEntity_updatingOnlyPassword(){
        crudOperation.addEntity(1, new Student("Student", 22, "password", 23, 98));
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class).filter("registerNo =", 22);
        crudOperation.patchEntity(query.list().get(0), new Student(null, 0, "password123", 0, 0));
        assertEquals(crudOperation.getEntity(22).name,"Student");
        assertEquals(crudOperation.getEntity(22).registerNo,22);
        assertEquals(crudOperation.getEntity(22).password,"password123");
        assertEquals(crudOperation.getEntity(22).age,23);
        assertEquals(crudOperation.getEntity(22).marks,98);
    }

    @Test
    public void test_patchEntity_updatingOnlyAge(){
        crudOperation.addEntity(1, new Student("Student", 22, "password", 23, 98));
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class).filter("registerNo =", 22);
        crudOperation.patchEntity(query.list().get(0), new Student(null, 0, null, 30, 0));
        assertEquals(crudOperation.getEntity(22).name,"Student");
        assertEquals(crudOperation.getEntity(22).registerNo,22);
        assertEquals(crudOperation.getEntity(22).password,"password");
        assertEquals(crudOperation.getEntity(22).age,30);
        assertEquals(crudOperation.getEntity(22).marks,98);
    }

    @Test
    public void test_patchEntity_updatingOnlyMarks(){
        crudOperation.addEntity(1, new Student("Student", 22, "password", 23, 98));
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class).filter("registerNo =", 22);
        crudOperation.patchEntity(query.list().get(0), new Student(null, 0, null, 0, 77));
        assertEquals(crudOperation.getEntity(22).name,"Student");
        assertEquals(crudOperation.getEntity(22).registerNo,22);
        assertEquals(crudOperation.getEntity(22).password,"password");
        assertEquals(crudOperation.getEntity(22).age,23);
        assertEquals(crudOperation.getEntity(22).marks,77);
    }





}
