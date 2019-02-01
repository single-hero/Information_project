package com.hero.dao.impl;

import com.hero.dao.IndexDAO;
import com.hero.po.MenuPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 首页访问数据库实现层
 * @author chenwenwei
 * @time 2019.01.26
 */
@Repository
public class IndexDaoImpl implements IndexDAO {
    //注入jdcb驱动
    @Autowired
    @Qualifier("primaryJdbc")
    JdbcTemplate primaryJdbcTemplate;


    //查询所有父级菜单
    @Override
    public List<MenuPO> selParent() {
        List<MenuPO>list=primaryJdbcTemplate.query("select * from sys_menu where parentId='0' ",new BeanPropertyRowMapper(MenuPO.class));
        return list;
    }


    //查询所有子菜单
    @Override
    public List<MenuPO> selParentNode(Integer id) {
        List<MenuPO>list=primaryJdbcTemplate.query("select * from sys_menu where parentId=?",new Object[]{id},new BeanPropertyRowMapper<>(MenuPO.class));
        return list;
    }


}
