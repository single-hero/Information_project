package com.hero.controller;

import com.hero.systemBase.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController{

    @RequestMapping(value = "/test")
    @ResponseBody
    public Object test(){
        PageData pd =this.getPageData();

        return pd;
    }
}
