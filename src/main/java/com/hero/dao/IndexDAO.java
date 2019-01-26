package com.hero.dao;


import com.hero.po.MenuPO;

import java.util.List;

/**
 * 首页访问数据库接口层
 * @author chenwenwei
 * @time 2019.01.26
 */
public interface IndexDAO {

    //查询所有父级菜单
    List<MenuPO> selParent();

    //查询所有子菜单
    List<MenuPO> selParentNode(Integer id);
}
