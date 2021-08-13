package com.classFiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public ModelAndView welcomePage(HttpServletRequest request, HttpServletResponse response){
        ReloadingWithoutCache.reloadPage(response);
        Profile.jsonObject.clear();
        HttpSession session =request.getSession(false);
        ModelAndView modelAndView= new ModelAndView();
        if (session!=null){
            modelAndView=Profile.modelAndViewWhenSessionExists(modelAndView,session);
        }
        else{
            modelAndView=Profile.modelAndViewWhenSessionNotExists(modelAndView);
        }
        return modelAndView;
    }

    @GetMapping(value = "/welcomeJson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String loginJson(HttpServletResponse response) {
        ReloadingWithoutCache.reloadPage(response);
        return Profile.jsonObject.toString();
    }

}
