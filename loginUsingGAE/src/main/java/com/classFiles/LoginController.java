package com.classFiles;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("userName") String userName, @RequestParam("password") String password) throws IOException {
        ReloadingWithoutCache.reloadPage(response);
        Credentials.jsonObject.clear();
        if (Credentials.isValid(userName, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("name", userName);
            response.sendRedirect("welcome");
        }
        return "loginForm";
    }

    @GetMapping(value = "/loginJson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String loginJson(HttpServletResponse response) {
        ReloadingWithoutCache.reloadPage(response);
        return Credentials.jsonObject.toString();
    }

}
