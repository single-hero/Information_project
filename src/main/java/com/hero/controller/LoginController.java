package com.hero.controller;

import com.alibaba.fastjson.JSONObject;
import com.hero.service.LoginService;
import com.hero.systemBase.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Api(description = "用户登陆")
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController{
    @Autowired
    LoginService loginService;

    @Value("${KEY}")
    private String key;

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
    public @ResponseBody Object loginCheck(HttpServletRequest request){
        JSONObject jsonParam= (JSONObject) request.getAttribute("jsonParam");
        try {
            System.out.println(key);
//            System.out.println(new AESUtil().Encrypt(jsonParam.toJSONString(),key));
            System.out.println(loginService.selAllUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonParam;
    }


}
