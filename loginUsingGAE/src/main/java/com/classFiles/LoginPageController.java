package com.classFiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginPageController {
    static JSONObject jsonObject=new JSONObject();
    @RequestMapping("/loginpage")
    public ModelAndView displayLoginPage(HttpServletRequest request, HttpServletResponse response){
        jsonObject.clear();
        Credentials.jsonObject.clear();
        ReloadingWithoutCache.reloadPage(response);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginPage");
        HttpSession session= request.getSession(false);
        if(session!=null){
            jsonObject.put("session", session);
            jsonObject.put("message", "you are Already logged in!!");
        }
        return modelAndView;
    }

    @GetMapping(value = "/loginPageJson",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String displayJson(HttpServletResponse response){
        ReloadingWithoutCache.reloadPage(response);
        return jsonObject.toString();
    }
}
