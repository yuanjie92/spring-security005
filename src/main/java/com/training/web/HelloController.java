package com.training.web;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by admin on 2018/6/17.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
       Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "hello springMVC " + new Date() + ": </br>" + o;
    }

    @RequestMapping("/hello2")
    public String hello2(Model model){
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("hello" ,"hello springMVC " + new Date() + ": </br>" + o);
        return "hello";
    }

    @RequestMapping("/myLogin")
    public String myLogin(){
      return "login";
    }



}
