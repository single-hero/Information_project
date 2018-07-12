package com.hero.controller;

import com.alibaba.fastjson.JSONObject;
import com.hero.po.User;
import com.hero.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 接口层-用户
 * @author chenwenwei
 * @time 2018.05.09
 */

@Controller
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    UserServiceImpl userServiceimpl;

    //User查询表所有数据
    @RequestMapping(value = "/select" ,method = RequestMethod.GET)
    public @ResponseBody String SelectUser(){
        return userServiceimpl.SelectUser().toString();
    }


    //User查询表所有数据
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public @ResponseBody String InsertUser(HttpServletRequest request)throws Exception{

        String state=request.getParameter("state");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        if (state==null){
            throw new Exception("状态不能为空");
        }
        if (account==null){
            throw new Exception("账号 不能为空");
        }
        if (password==null){
            throw new Exception("密码 不能为空");
        }

        //参数处理
        JSONObject jsonObject= (JSONObject) request.getAttribute("jsonObject");



        User user=new User();
        user.setState(state);
        user.setAccount(account);
        user.setPassword(password);
        return userServiceimpl.InsertUser(user).toString();
    }
}
