package com.hero.service;

import com.alibaba.fastjson.JSONObject;
import com.hero.systemBase.ResultMsg;

/**
 * 菜单service层
 * @author chenwenwei
 * @time 2019.02.02
 */
public interface MenuService {

    //查询所有菜单列
    ResultMsg selAllMenuListMapService();


    //根据id修改菜单排序
    ResultMsg updateRank(JSONObject jsonParam);
}
