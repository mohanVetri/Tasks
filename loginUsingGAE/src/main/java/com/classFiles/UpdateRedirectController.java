package com.classFiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpdateRedirectController {
    @GetMapping(value = "/updateDetailsRedirect")
    public String redirecting(HttpServletRequest request, HttpServletResponse response) {
        ReloadingWithoutCache.reloadPage(response);
        HttpSession session = request.getSession(false);
        if (session != null) {
            return "updatePage";
        } else {
            UpdateDetailController.jsonObject.clear();
            return "updatePage";
        }
    }
}
