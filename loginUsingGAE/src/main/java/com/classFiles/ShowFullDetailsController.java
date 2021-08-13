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
public class ShowFullDetailsController {
    static JSONObject jsonObject=new JSONObject();
    @GetMapping(value = "/showFullDetails")
    public static String showDetails(){
        jsonObject.clear();
        FetchingDetails.getJson(jsonObject);
        return "fullDetails";
    }

    @GetMapping(value = "/showFullDetailsAfterLogin")
    public String showFullDetailsAfterLogin(HttpServletRequest request,HttpServletResponse response){
        ReloadingWithoutCache.reloadPage(response);
        HttpSession session=request.getSession(false);
        if(session!=null){
            return ShowFullDetailsController.showDetails();
        }
        else{
            jsonObject.clear();
            return "fullDetails";
        }
    }

    @GetMapping(value = "/detailsJson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getJson(){
        return jsonObject.toString();
    }
}
