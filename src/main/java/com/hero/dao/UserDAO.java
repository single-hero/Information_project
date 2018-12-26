package com.hero.dao;

import com.hero.dao.impl.UserDaoImpl;
import com.hero.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据访问实现-用户
 * @author chenwenwei
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
        int result=jdbcTemplate.update("insert into userbo(state,account,password,addtime,uptime)value(?,?,?,?,?)",user.getState(),user.getAccount(),user.getPassword(),user.getAddtime(),user.getUptime());
        return result;
    }


/*    @Override
    public List<Map<String, Object>> getByParentpagDao(JSONObject paramJson) {
//        System.out.println("dao层"+paramJson);
        return jdbcTemplate.queryForList("SELECT account,name FROM partner_user WHERE parent_pag='" + paramJson.getString("parent_pag") + "' and  state='"+paramJson.getString("state")+"'");
    }


    @Override
    public String getMaxId() {
        return jdbcTemplate.queryForObject("SELECT IFNULL(MAX(id),0)+1 FROM partner_user",String.class);
    }

    @Override
    public int updateState(String account, Integer state) {
        return jdbcTemplate.update("UPDATE partner_user SET state = ? WHERE account = ?",state,account);
    }*/
}
