package com.hero.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.hero.dao.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 菜单访问数据库层
 * @author chenwenwei
 * @time 2019.02.01
 */
@Repository
public class MenuDaoImpl implements MenuDAO {
    @Autowired
    @Qualifier("primaryJdbc")
    JdbcTemplate primaryJdbcTemplate;

    //查询所有菜单列表
    @Override
    public List<Map<String, Object>> selAllMenuListMap() {
        return primaryJdbcTemplate.queryForList("select * from sys_menu order by rank ASC");
    }

    //修改菜单排序
    @Override
    public int updateMenuRank(JSONObject jsonParam) {
        return primaryJdbcTemplate.update("update sys_menu set rank=? where id =?",jsonParam.getString("rank"),jsonParam.getString("id"));
    }
}
