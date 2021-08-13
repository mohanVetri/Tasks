package com.classFiles;

import javax.servlet.http.HttpServletRequest;

import com.googlecode.objectify.cmd.Query;

import org.json.JSONObject;

public class Registration {
    static long id;

    public static void getJson(JSONObject jsonObject, HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String emailId = request.getParameter("emailId");
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class);
        boolean isExist = true;
        id = query.list().size();
        if (query.list().size() != 0) {
            for (StudentDetails entity : query) {
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
        if (isExist) {
            OfyHelper.ofy().save().entity(new StudentDetails(++id, firstName, lastName, userName, password, emailId))
                    .now();
            jsonObject.put("success",
                    "You are successfully registered!!.Now You can login with your UserName and Password");
        }

    }

}
