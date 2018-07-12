package com.hero.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接口层-首页跳转
 * @author chenwenwei
 * @time 2018.05.08
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public void toIndex(HttpServletResponse response) throws IOException {
        response.sendRedirect("/hero/html/Login.html");
    }
}
