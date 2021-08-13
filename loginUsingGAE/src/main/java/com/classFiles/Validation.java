package com.classFiles;

import javax.servlet.http.HttpServletRequest;

import com.googlecode.objectify.cmd.Query;

import org.json.JSONObject;

public class Validation {
    static JSONObject jsonObject=new JSONObject();
    public static boolean checkDetails(HttpServletRequest request) {
        String userName=request.getParameter("userName");
        String emailId=request.getParameter("emailId");
        boolean isExist=true;
        jsonObject.clear();
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class);
        if (query.list().size() != 0) {
            for (StudentDetails entity : query) {
                System.out.println("UserName: "+userName+" Entity userName: "+entity.userName);
                if (entity.userName.equals(userName)) {
                    jsonObject.put("message", "UserName is already Existed!!");
                    isExist = false;
                    break;
                } else if (entity.emailId.equals(emailId)) {
                    jsonObject.put("message", "EmailId is already Existed!!");
                    isExist = false;
                    break;
                }
            }
        }
        return isExist;
    }

}
