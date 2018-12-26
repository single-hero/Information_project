package com.hero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误控制
 * @author chenwenwei
 * @time 2018.12.26
 */
@Controller
@RequestMapping(value = "/error")
public class ErrorController {

    /**
     * information:501
     * content:服务器不支持当前请求所需要的某个功能。当服务器无法识别请求的方法，并且无法支持其对任何资源的请求
     */
    @GetMapping(value = "/501")
    public String err501(){
//        return "Type_on";
        return "服务器不支持当前请求所需要的某个功能。当服务器无法识别请求的方法，并且无法支持其对任何资源的请求";
    }
}
