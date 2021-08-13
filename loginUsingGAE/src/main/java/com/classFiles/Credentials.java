package com.classFiles;

import com.googlecode.objectify.cmd.Query;

import org.json.JSONObject;

public class Credentials {
    static JSONObject jsonObject = new JSONObject();
    public static boolean isValid(String userName, String password) {
        boolean isValid=false;
        jsonObject.put("message", "Invalid Credentials.Sign Up first");
        Query<StudentDetails> query=OfyHelper.ofy().load().type(StudentDetails.class);
        for(StudentDetails details:query){
            if(details.userName.equals(userName)){
                jsonObject.put("message", "Invalid Password!!");
                if(details.password.equals(password)){
                    jsonObject.clear();
                    isValid=true;
                    break;
                }
            }
        }
        return isValid;
    }

}
