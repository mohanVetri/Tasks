package com.classFiles;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Profile {
    static JSONObject jsonObject=new JSONObject();

    public static ModelAndView modelAndViewWhenSessionExists(ModelAndView modelAndView, HttpSession session) {
        String name=(String) session.getAttribute("name");
        modelAndView.setViewName("welcome");
        jsonObject.put("message", "Welcome <b>"+name+"</b>");
        return modelAndView;
    }

    public static ModelAndView modelAndViewWhenSessionNotExists(ModelAndView modelAndView) {
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

}
