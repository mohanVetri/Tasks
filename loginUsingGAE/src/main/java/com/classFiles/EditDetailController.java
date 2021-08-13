package com.classFiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EditDetailController {
   static JSONObject jsonObject=new JSONObject();
    @GetMapping(value = "/editDetails")
    public String editDetails(HttpServletRequest request, HttpServletResponse response){
        jsonObject.clear();
        ReloadingWithoutCache.reloadPage(response);
        HttpSession session=request.getSession(false);
        if(session!=null){
            String name=session.getAttribute("name").toString();
            Individual.getJson(name,jsonObject);
            jsonObject.put("session", session);
        }
        return "editPage";
    }

    @GetMapping(value = "/editJson",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getJson(HttpServletResponse response){
        ReloadingWithoutCache.reloadPage(response);
        return jsonObject.toString();
    }

    @GetMapping(value = "/validationJson",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getValidationJson(HttpServletResponse response){
        ReloadingWithoutCache.reloadPage(response);
        return Validation.jsonObject.toString();
    }
}
