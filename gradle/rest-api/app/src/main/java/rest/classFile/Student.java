package rest.classFile;

public class Student {
    public String name;
    public int registerNo;
    public String password;
    public int age;
    public int marks;

    public Student() {

    }

    public Student(String name, int registerNo, String password, int age, int marks) {
        super();
        this.name = name;
        this.registerNo = registerNo;
        this.age = age;
        this.password = password;
        this.marks = marks;
    }
}
