package com.hero.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接口层-首页跳转
 * @author chenwenwei
 * @time 2018.05.08
 */
@Controller
public class IndexController {
    //后台登陆跳转
    @GetMapping(value ="login")
    public String toIndex(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/hero/Templates/Login.html");
        return "/Login";
    }

    //退出登陆
/*    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
//        session.removeAttribute();
        return "";
    }*/

/*    @GetMapping(value = "/error")
    public String error(){
        return "/error";
    }*/
}
