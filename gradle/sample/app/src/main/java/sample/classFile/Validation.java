package sample.classFile;

import sample.Entity.CrudOperation;

public class Validation {

    public static boolean isValid(Student student) {
        if (student.age != 0 && student.marks != 0 && student.name!=null && student.password!=(null)
                && student.registerNo != 0) {
            return true;
        } else
            return false;
    }

    public static boolean isNotExist(int registerNo, int id) {
        if (registerNo == id)
            return true;
        else
            return CrudOperation.getEntity(registerNo) == null;
    }
}
