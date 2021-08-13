package com.classFiles;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UpdateDetailController {
    static JSONObject jsonObject = new JSONObject();

    @PostMapping(value = "/updateDetails")
    public void updateDetails(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
            @RequestParam("userName") String userName, @RequestParam("password") String password,
            @RequestParam("emailId") String emailId, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ReloadingWithoutCache.reloadPage(response);
        HttpSession session = request.getSession(false);
        boolean notExist = true;
        long id = UpdateEntity.getIdAndDeleteEntity(session);
        notExist = Validation.checkDetails(request);
        System.out.println("notExist: " + notExist);
        if (notExist) {
            session.setAttribute("name", userName);
            jsonObject.put("session", session);
            OfyHelper.ofy().save().entity(new StudentDetails(id, firstName, lastName, userName, password, emailId))
                    .now();
            Individual.getJson(userName, jsonObject);
            jsonObject.put("message", "Updated Successfully!!");
            response.sendRedirect("/updateDetailsRedirect");
        } else {
            Individual.addEntity();
            response.sendRedirect("/editDetails");
        }
    }

    @GetMapping(value = "/updateJson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getJson(HttpServletResponse response) {
        ReloadingWithoutCache.reloadPage(response);
        return jsonObject.toString();
    }
}
