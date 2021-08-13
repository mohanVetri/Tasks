package com.classFiles;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class StudentDetails {
    
    @Id long id;
    @Index String firstName;
    @Index String lastName;
    @Index String userName;
    @Index String password;
    @Index String emailId;
    public StudentDetails(){

    }

    public StudentDetails(long id,String firstName, String lastName, String userName, 
    String password, String emailId){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.password=password;
        this.emailId=emailId;
    }

}
