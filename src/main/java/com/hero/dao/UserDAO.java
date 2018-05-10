package com.hero.dao;

import com.hero.dao.impl.UserDaoImpl;
import com.hero.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * 数据访问实现-用户
 * @author hero
 * @time 2018.05.09
 */

@Repository
public class UserDAO implements UserDaoImpl {

    //注入jdcb驱动
    @Autowired
    JdbcTemplate jdbcTemplate;


    //向数据库查询所有信息
    @Override
    public List<User> SelectUser(){
        List<User>list=jdbcTemplate.query("select * from userbo",new BeanPropertyRowMapper(User.class));
        return list;
    }

    //向数据库添加信息
    @Override
    public Integer InsertUser(User user){
        int result=jdbcTemplate.update("insert into userbo(state,account,passwword,addtime,uptime)value(?,?,?,?,?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,user.getState());
                preparedStatement.setString(2,user.getAccount());
                preparedStatement.setString(3,user.getPassword());
                preparedStatement.setDate(4, (Date) user.getAddtime());
                preparedStatement.setDate(5, (Date) user.getUptime());
            }
        });
        return result;
    }
}
