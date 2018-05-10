package com.hero.service.impl;

import com.hero.po.User;
import com.hero.util.ResultMsg;

/**
 * 业务逻辑接口-用户
 * @author hero
 * @time 2018.05.05
 */

public interface UserServiceImpl {

    /**
     * 查询所有信息
     * @return
     */
    ResultMsg SelectUser();


    /**
     * 添加用户
     * @param user
     * @return
     */
    ResultMsg InsertUser(User user);
}
