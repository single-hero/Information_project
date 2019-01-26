package com.hero.controller;


import com.hero.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

/**
 * 接口层-首页跳转
 * @author chenwenwei
 * @time 2018.05.08
 */
@Controller
public class IndexController {
    @Autowired
    IndexService indexService;

    //后台登陆跳转
    @GetMapping(value ={"/login","/"})
    public String toLogin() throws IOException {
        return "/Login/Login";
    }


    //首页
    @GetMapping(value = "/Index")
    public String toIndex(Model model){
        model.addAttribute("SystemName","后台管理系统");
        indexService.responseMenuList();
        return "/index";
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
