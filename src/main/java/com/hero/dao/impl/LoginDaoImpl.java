package com.hero.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.hero.dao.LoginDao;
import com.hero.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 登陆dao层impl
 * @author chenwenwei
 * @time 2018.12.27
 */
@Repository
public class LoginDaoImpl<T> implements LoginDao {
    //注入jdcb驱动
    @Autowired
    @Qualifier("primaryJdbc")
    JdbcTemplate primaryJdbcTemplate;
    @Autowired
    @Qualifier("secondJdbc")
    JdbcTemplate secondJdbcTemplate;

    //查询所有用户(测试)
    @Override
    public List<Map<String, Object>> selAllUser() {
        return secondJdbcTemplate.queryForList("select * from sys_user");
    }


    //系统用户登陆验证
    @Override
    public Object systemLoginCheck(JSONObject jsonParam) {
        return primaryJdbcTemplate.queryForObject(
        "select * from sys_user where userName=? and password=?",
            new Object[]{jsonParam.getString("loginname"),jsonParam.getString("psw")},
            new BeanPropertyRowMapper<>(User.class)
        );
    }
}
