package com.classFiles;

import com.googlecode.objectify.cmd.Query;

import org.json.JSONObject;

public class Individual {

    static long id;
    static String firstName;
    static String lastName;
    static String userName;
    static String password;
    static String emailId;

    public static void getJson(String name, JSONObject jsonObject) {
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class).filter("userName", name);
        for(StudentDetails details:query){
            jsonObject.put("firstName", details.firstName);
            jsonObject.put("lastName", details.lastName);
            jsonObject.put("userName", details.userName);
            jsonObject.put("password", details.password);
            jsonObject.put("emailId", details.emailId);
        }
    }

    public static void deleteEntity(String name) {
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class).filter("userName", name);
        for(StudentDetails details:query){
            id=details.id;
            firstName=details.firstName;
            lastName=details.lastName;
            userName=details.userName;
            password=details.password;
            emailId=details.emailId;
            OfyHelper.ofy().delete().entity(new StudentDetails(details.id,details.firstName,details.lastName,
            details.userName,details.password,details.emailId));
        }
    }

    public static void addEntity() {
        System.out.println("i am here!! firstName: "+firstName);
        OfyHelper.ofy().save().entity(new StudentDetails(id, firstName, lastName, userName, password, emailId))
        .now();
    }

}
