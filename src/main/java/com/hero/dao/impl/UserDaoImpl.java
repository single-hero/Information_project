package com.hero.dao.impl;

import com.hero.po.User;

import java.util.List;



public interface UserDaoImpl {


    //向数据库查询所有信息
    List<User> SelectUser();
}

