package com.hero.controller;

import com.hero.systemBase.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "用户登陆")
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController{
    @Value("${KEY}")
    String key;

    @ApiOperation(value = "登陆测试",notes = "只是一个测试")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "Username",value = "用户名称",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "Password",value = "用户密码",required = true,dataType = "String"),
    })
    @RequestMapping(value = "/test")
    public @ResponseBody Object test(){
        PageData pd =this.getPageData();
        return pd;
    }

    //系统登陆校验
    @PostMapping(value = "/loginCheck")
    public @ResponseBody Object loginCheck(){
        PageData pd=this.getPageData();
        return pd;
    }


}
