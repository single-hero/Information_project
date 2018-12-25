package com.hero.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * 接口层-首页跳转
 * @author chenwenwei
 * @time 2018.05.08
 */
@Controller
public class IndexController {
    @RequestMapping(value = {"/login","/","/index"},method = RequestMethod.GET)
    public String toIndex() throws IOException {
//        ModelAndView mv =new ModelAndView("Login");
//        response.sendRedirect("/hero/templates/Login.html");
        return "Login";
    }
}
