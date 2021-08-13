package rest.classFile;

import rest.Entity.CrudOperation;

public class Validation {

    CrudOperation crudOperation = new CrudOperation();

    public boolean isValid(Student student) {
        if (student.age != 0 && student.marks != 0 && student.name!=null && student.password!=(null)
                && student.registerNo != 0) {
            return true;
        } else
            return false;
    }

    public boolean isNotExist(int registerNo, int id) {
        if (registerNo == id)
            return true;
        else
            return crudOperation.getEntity(registerNo) == null;
    }
}
