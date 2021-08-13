package sample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sample.classFile.Student;
import sample.classFile.Validation;

public class ValidationTest {
    @Test
    public void test_isValid_withValidProperties(){
        assertEquals(Validation.isValid(new Student("name",21,"pasword",23,100)), true);
    }

    @Test
    public void test_isValid_withInValidName(){
        assertEquals(Validation.isValid(new Student(null,21,"pasword",23,100)), false);
    }

    @Test
    public void test_isValid_withInValidRegisterNo(){
        assertEquals(Validation.isValid(new Student("name",0,"pasword",23,100)), false);
    }

    @Test
    public void test_isValid_withInValidPassword(){
        assertEquals(Validation.isValid(new Student("name",21,null,23,100)), false);
    }

    @Test
    public void test_isValid_withInValidAge(){
        assertEquals(Validation.isValid(new Student("name",21,"password",0,100)), false);
    }

    @Test
    public void test_isValid_withInValidMarks(){
        assertEquals(Validation.isValid(new Student("name",21,"password",23,0)), false);
    }



}
