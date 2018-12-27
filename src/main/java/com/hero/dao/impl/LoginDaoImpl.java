package com.hero.dao.impl;

import com.hero.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class LoginDaoImpl implements LoginDao {
    //注入jdcb驱动
    @Autowired
    @Qualifier("secondJdbc")
    JdbcTemplate secondJdbcTemplate;

    //查询所有用户(测试)
    @Override
    public List<Map<String, Object>> selAllUser() {
        return secondJdbcTemplate.queryForList("select * from hx_user");
    }
}
