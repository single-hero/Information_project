package com.hero.dao;

import com.hero.po.User;

import java.util.List;


/**
 * 数据访问接口-用户
 * @author chenwenwei
 * @time 2018.05.09
 */

public interface UserDAO {


    //向数据库查询所有信息
    List<User> SelectUser();


    //向数据库添加信息
    Integer InsertUser(User user);

}

