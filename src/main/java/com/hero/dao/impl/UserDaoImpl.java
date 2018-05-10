package com.hero.dao.impl;

import com.hero.po.User;

import java.util.List;


/**
 * 数据访问接口-用户
 * @author hero
 * @time 2018.05.09
 */

public interface UserDaoImpl {


    //向数据库查询所有信息
    List<User> SelectUser();


    //

}

