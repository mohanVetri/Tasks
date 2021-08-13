package com.classFiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

    static JSONObject jsonObject = new JSONObject();
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerDetails(HttpServletRequest request) {
        jsonObject.clear();
        Registration.getJson(jsonObject,request);
        return "registration";
    }

    @GetMapping(value = "/registrationPage")
    public String registrationPage(){
        jsonObject.clear();
        return "registration";
    }

    @GetMapping(value = "/registerJson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String registerJson(HttpServletResponse response) {
        ReloadingWithoutCache.reloadPage(response);
        return jsonObject.toString();
    }
}
