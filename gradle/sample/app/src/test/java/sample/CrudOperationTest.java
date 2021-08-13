package sample;
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

import sample.Entity.CrudOperation;
import sample.Entity.StudentDetails;
import sample.Objectify.OfyHelper;
import sample.classFile.Student;

public class CrudOperationTest {

    LocalServiceTestHelper helper= new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    Closeable session;

    @Before
    public void setUp(){
        this.session=ObjectifyService.begin();
        this.helper.setUp();
    }

    @After
    public void tearDown(){
        AsyncCacheFilter.complete();
        this.session.close();
        this.helper.tearDown();
    }

    @Test
    public void test_id_getEntity_ReturnsEntity(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(CrudOperation.getEntity(21).id, 1);
    }

    @Test
    public void test_name_getEntity_ReturnsEntity(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "Mohan", 21, "password", 23, 100)).now();
        assertEquals(CrudOperation.getEntity(21).name, "Mohan");
    }

    @Test
    public void test_registerNo_getEntity_ReturnsEntity(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(CrudOperation.getEntity(21).registerNo, 21);
    }

    @Test
    public void test_password_getEntity_ReturnsEntity(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(CrudOperation.getEntity(21).password, "password");
    }

    @Test
    public void test_age_getEntity_ReturnsEntity(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(CrudOperation.getEntity(21).age, 23);
    }

    @Test
    public void test_marks_getEntity_ReturnsEntity(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertEquals(CrudOperation.getEntity(21).marks, 100);
    }

    @Test
    public void test_getEntity_ReturnsNull(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        assertNull(CrudOperation.getEntity(2));
    }

    @Test
    public void test_getAllEntities_ReturnsNull(){
        assertNull(CrudOperation.getAllEntities());
    }


    @Test
    public void test_size_getAllEntities(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "name", 24, "password", 23, 100)).now();
        assertEquals(CrudOperation.getAllEntities().list().size(), 2);
    }

    @Test
    public void test_firstElement_getAllEntities(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "mohan", 24, "password123", 25, 98)).now();
        assertEquals(CrudOperation.getAllEntities().list().get(0).id,1);
        assertEquals(CrudOperation.getAllEntities().list().get(0).name,"name");
        assertEquals(CrudOperation.getAllEntities().list().get(0).registerNo,21);
        assertEquals(CrudOperation.getAllEntities().list().get(0).password,"password");
        assertEquals(CrudOperation.getAllEntities().list().get(0).age,23);
        assertEquals(CrudOperation.getAllEntities().list().get(0).marks,100);
    }

    @Test
    public void test_secondElement_getAllEntities(){
        OfyHelper.ofy().save().entity(new StudentDetails(1, "name", 21, "password", 23, 100)).now();
        OfyHelper.ofy().save().entity(new StudentDetails(2, "mohan", 24, "password123", 25, 98)).now();
        assertEquals(CrudOperation.getAllEntities().list().get(1).id,2);
        assertEquals(CrudOperation.getAllEntities().list().get(1).name,"mohan");
        assertEquals(CrudOperation.getAllEntities().list().get(1).registerNo,24);
        assertEquals(CrudOperation.getAllEntities().list().get(1).password,"password123");
        assertEquals(CrudOperation.getAllEntities().list().get(1).age,25);
        assertEquals(CrudOperation.getAllEntities().list().get(1).marks,98);
    }

    public void test_addEntity_sizeAfterAddingOneEntity(){
        CrudOperation.addEntity(1,new Student("Mohan",21,"password123",23,100));
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class);
        assertEquals(query.list().size(),1);
    }

    public void test_addEntity_sizeAfterAddingTwoEntity(){
        CrudOperation.addEntity(1,new Student("Mohan",21,"password123",23,100));
        CrudOperation.addEntity(2,new Student("prem",22,"password123",23,100));
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class);
        assertEquals(query.list().size(),2);
    }


    public void test_addEntity_WithGetEntity(){
        CrudOperation.addEntity(1,new Student("Mohan",21,"password123",23,100));
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class);
        assertNotNull(CrudOperation.getEntity(21));
        assertEquals(CrudOperation.getEntity(21).name, "Mohan");
        assertEquals(CrudOperation.getEntity(21).registerNo, 21);
        assertEquals(CrudOperation.getEntity(21).password, "password123");
        assertEquals(CrudOperation.getEntity(21).age, 23);
        assertEquals(CrudOperation.getEntity(21).marks, 100);
    }



}
