package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerTest {
    //扫描限制
    @RequestMapping(value = "/Scan" ,method = RequestMethod.GET)
    public @ResponseBody String SelectUser(){
        return "扫描限制访问";
    }
}
