package rest.classFile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cache.AsyncCacheFilter;
import com.googlecode.objectify.util.Closeable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rest.Entity.CrudOperation;

public class ValidationTest {

    CrudOperation crudOperation = new CrudOperation();
    Validation validation= new Validation();

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
    public void test_isValid_withValidProperties(){
        assertEquals(validation.isValid(new Student("name",21,"pasword",23,100)), true);
    }

    @Test
    public void test_isValid_withInValidName(){
        assertEquals(validation.isValid(new Student(null,21,"pasword",23,100)), false);
    }

    @Test
    public void test_isValid_withInValidRegisterNo(){
        assertEquals(validation.isValid(new Student("name",0,"pasword",23,100)), false);
    }

    @Test
    public void test_isValid_withInValidPassword(){
        assertEquals(validation.isValid(new Student("name",21,null,23,100)), false);
    }

    @Test
    public void test_isValid_withInValidAge(){
        assertEquals(validation.isValid(new Student("name",21,"password",0,100)), false);
    }

    @Test
    public void test_isValid_withInValidMarks(){
        assertEquals(validation.isValid(new Student("name",21,"password",23,0)), false);
    }

    @Test
    public void test_isNotExist_ReturnTrue(){
        assertTrue(validation.isNotExist(2,2));
    }

    @Test
    public void test_isNotExist_ExistedRegister(){
        crudOperation.addEntity(1, new Student("StudentName",10,"password",23,100));
        crudOperation.addEntity(1, new Student("StudentName",11,"password",23,100));
        assertFalse(validation.isNotExist(11,10));
    }

    @Test
    public void test_isNotExist_nonExistedRegister(){
        crudOperation.addEntity(1, new Student("StudentName",10,"password",23,100));
        crudOperation.addEntity(1, new Student("StudentName",11,"password",23,100));
        assertTrue(validation.isNotExist(12,10));
    }



}
