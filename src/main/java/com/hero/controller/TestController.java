package com.hero.controller;

import com.hero.po.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口层-测试
 * @author hero
 * @time 2018.05.05
 */

@RestController
@RequestMapping(value = "/test")
public class TestController {
    //日志开启
//    private final Logger logger= LoggerFactory.getLogger(this.getClass());
//    @Autowired()
//    private User user;

    @RequestMapping
    public @ResponseBody String index(){
        return "HelloWorld";
    }


    @RequestMapping(value = "/user")
    public @ResponseBody User hello(){
        User user=new User();
        user.setAccount("name");
        user.setPassword("密码");
        return user;
    }
}
