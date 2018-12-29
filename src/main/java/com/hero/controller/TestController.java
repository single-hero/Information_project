package com.hero.controller;

import com.hero.po.User;
import com.hero.systemBase.BaseConfig;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口层-测试
 * @author chenwenwei
 * @time 2018.05.05
 */
@Api(description = "接口测试")
@RestController
@RequestMapping(value = "/test")
public class TestController extends BaseConfig {
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
        user.setUserName("name");
        user.setPassword("密码");
        logger.info("测试");
        return user;
    }
}
