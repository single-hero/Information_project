package com.hero.service;

import com.hero.dao.UserDAO;
import com.hero.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    //User查询表所有数据
    public List<User> SelectUser(){
        return userDAO.SelectUser();
    }
}
