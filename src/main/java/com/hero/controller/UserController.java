package com.hero.controller;

import com.hero.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 接口层-用户
 * @author hero
 * @time 2018.05.09
 */

@Controller
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    UserServiceImpl userServiceimpl;

    //User查询表所有数据
    @RequestMapping(value = "/select")
    public @ResponseBody String SelectUser(){
        return userServiceimpl.SelectUser().toString();
    }

//    //User查询表所有数据
//    @RequestMapping(value = "/insert")
//    public @ResponseBody String InsertUser(){
//        return userServiceimpl.InsertUser().toString();
//    }
}
