package com.hero.service;

import com.alibaba.fastjson.JSONObject;
import com.hero.systemBase.ResultMsg;

/**
 * 登陆service层
 * @author chenwenwei
 * @time 2018.12.27
 */
public interface LoginService {

    //多数据源测试
    ResultMsg selAllUser();

    //系统用户登陆验证
    ResultMsg systemLoginCheckService(JSONObject jsonParam);
}
