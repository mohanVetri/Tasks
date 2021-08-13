package sample.Entity;

import com.googlecode.objectify.cmd.Query;


import sample.Objectify.OfyHelper;
import sample.classFile.Student;

public class CrudOperation {
    public static void addEntity(long id, Student student) {
        OfyHelper.ofy().save().entity(
                new StudentDetails(id, student.name, student.registerNo, student.password, student.age, student.marks))
                .now();
    }

    public static void deleteEntity(StudentDetails student) {
        OfyHelper.ofy().delete().entity(new StudentDetails(student.id, student.name, student.registerNo,
                student.password, student.age, student.marks)).now();
    }

    public static void updateEntity(long id, Student student) {
        OfyHelper.ofy().save().entity(
                new StudentDetails(id, student.name, student.registerNo, student.password, student.age, student.marks))
                .now();
    }

    public static void patchEntity(StudentDetails entity, Student student) {
        String name = student.name != null ? student.name : entity.name;
        int registerNo = student.registerNo != 0 ? student.registerNo : entity.registerNo;
        String password = student.password != null ? student.password : entity.password;
        int age = student.age != 0 ? student.age : entity.age;
        int marks = student.marks != 0 ? student.marks : entity.marks;
        OfyHelper.ofy().save().entity(new StudentDetails(entity.id, name, registerNo, password, age, marks)).now();
    }

    public static Query<StudentDetails> getAllEntities() {
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class);
        if (query.list().size() > 0) {
            return query;
        } else
            return null;
    }

    public static StudentDetails getEntity(int id) {
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class).filter("registerNo =", id);
        if (query.list().size() > 0) {
            return query.list().get(0);
        } else
            return null;
    }

}
