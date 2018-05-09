package com.hero.controller;

import com.hero.po.User;
import com.hero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    UserService userService;

    //User查询表所有数据
    @RequestMapping(value = "/select")
    public @ResponseBody List<User> SelectUser(){
        List<User>list=userService.SelectUser();
        return list;
    }
}
