package com.hero.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 接口层-首页跳转
 * @author chenwenwei
 * @time 2018.05.08
 */
@Controller
public class IndexController {
    //后台登陆跳转
    @GetMapping(value ={"/","login","/index"})
    public String toIndex(HttpServletResponse response) throws IOException {
//        System.out.println("测试");
//        response.sendRedirect("/hero/Templates/Login.html");
        return "/Login";
    }

    //退出登陆
    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
//        session.removeAttribute();
        return "";
    }

    @GetMapping(value = "/error")
    public String error(){
        return "/error";
    }
}
