package rest.classFile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class StudentTest {
    @Test
    public void test_ObjectOfStudent(){
        Student student= new Student();
        assertNotNull(student);
    }

    @Test
    public void test_Name_afterInstantiation(){
        Student student= new Student("Mohan",10,"password",21,88);
        assertEquals(student.name,"Mohan");
    }

    @Test
    public void test_registerNo_afterInstantiation(){
        Student student= new Student("Mohan",10,"password",21,88);
        assertEquals(student.registerNo,10);
    }

    @Test
    public void test_password_afterInstantiation(){
        Student student= new Student("Mohan",10,"password",21,88);
        assertEquals(student.password,"password");
    }

    @Test
    public void test_age_afterInstantiation(){
        Student student= new Student("Mohan",10,"password",21,88);
        assertEquals(student.age,21);
    }

    @Test
    public void test_marks_afterInstantiation(){
        Student student= new Student("Mohan",10,"password",21,88);
        assertEquals(student.marks,88);
    }


}
