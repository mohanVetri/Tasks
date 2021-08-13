package com.classFiles;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import com.googlecode.objectify.cmd.Query;

import org.json.JSONObject;

public class FetchingDetails {

    public static void getJson(JSONObject jsonObject) {
        LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
        List<LinkedHashMap<String,String>> studentList= new LinkedList<LinkedHashMap<String, String>>();
        Query<StudentDetails> query = OfyHelper.ofy().load().type(StudentDetails.class);
        if(query.list().size()!=0){
            for(StudentDetails details:query){
                map.put("firstName", details.firstName);
                map.put("lastName", details.lastName);
                map.put("userName", details.userName);
                map.put("password", details.password);
                map.put("emailId", details.emailId);
                studentList.add(new LinkedHashMap<String, String>(map));
                }
                jsonObject.put("details", studentList);
                }
                else{
                    jsonObject.put("message", "No Student Details");
                }

    }

}
