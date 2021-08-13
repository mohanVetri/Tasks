package com.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddController {
    
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request,HttpServletResponse response,Model model){
        int number1=Integer.parseInt(request.getParameter("number1"));
        int number2=Integer.parseInt(request.getParameter("number2"));
        AddService addService=new AddService();
        int addResult=addService.add(number1,number2);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("result", addResult);
        return "resultPage.jsp";
    }
}
