package com.hero.dao;

import com.hero.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据访问-用户
 * @author hero
 * @time 2018.05.09
 */

@Repository
public class UserDAO {

    //注入jdcb驱动
    @Autowired
    JdbcTemplate jdbcTemplate;


    //向数据库查询所有信息
    public List<User> SelectUser(){
        List<User>list=jdbcTemplate.query("select * from userbo",new BeanPropertyRowMapper(User.class));
        return list;
    }
}
