package com.hero.dao;

import java.util.List;
import java.util.Map;

/**
 * 菜单访问数据库接口层
 * @author chenwenwei
 * @time 2019.02.01
 */
public interface MenuDAO{

    //查询所有菜单列表
    List<Map<String,Object>> selAllMenuListMap();
}
