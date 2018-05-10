package com.hero.service;

import com.hero.dao.UserDAO;
import com.hero.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 业务逻辑-用户
 * @author hero
 * @time 2018.05.05
 */

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    //User查询表所有数据
    public List<User> SelectUser(){
        return userDAO.SelectUser();
    }
}
