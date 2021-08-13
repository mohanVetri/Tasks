package rest.Entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class StudentDetails {
    public @Id long id;
    public @Index String name;
    public @Index int age;
    public @Index int registerNo;
    public @Index String password;
    public @Index int marks;

    public StudentDetails() {

    }

    public StudentDetails(long id, String name, int registerNo, String password, int age, int marks) {
        this.id = id;
        this.name = name;
        this.registerNo = registerNo;
        this.age = age;
        this.password = password;
        this.marks = marks;
    }

}
