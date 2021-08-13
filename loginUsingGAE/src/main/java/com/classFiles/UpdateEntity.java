package com.classFiles;

import javax.servlet.http.HttpSession;

import com.googlecode.objectify.cmd.Query;

import org.json.JSONObject;

public class UpdateEntity {

    public static long getIdAndDeleteEntity(HttpSession session) {
        long id=0;
        String name=session.getAttribute("name").toString();
        Query<StudentDetails> query= OfyHelper.ofy().load().type(StudentDetails.class).filter("userName",name);
        for(StudentDetails details:query){
            id=details.id;
            break;
        }
        Individual.deleteEntity(name);
        return id;
    }

    public static void getJson(String firstName, String lastName, String userName, String password,
            String emailId, JSONObject jsonObject) {
                jsonObject.put("firstName", firstName);
                jsonObject.put("lastName", lastName);
                jsonObject.put("userName", userName);
                jsonObject.put("password", password);
                jsonObject.put("emailId", emailId);    
    }
}
