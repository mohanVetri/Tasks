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



@Controller
public class LogoutController {
    static JSONObject jsonObject=new JSONObject();
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        ReloadingWithoutCache.reloadPage(response);
        jsonObject.clear();
        HttpSession session=request.getSession(false);
        if(session!=null){
            session.invalidate();
            jsonObject.put("message", "you are successfully logged out!!");
            return "logout";
        }
        else{
            return "logout";
        }
    }

    @GetMapping(value = "/logoutJson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getJson(HttpServletResponse response){
        ReloadingWithoutCache.reloadPage(response);
        return jsonObject.toString();
    }
}

