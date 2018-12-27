package com.hero.dao;

import java.util.List;
import java.util.Map;

/**
 * 登陆dao层
 * @author chenwenwei
 * @time 2018.12.27
 */
public interface LoginDao {

    //查询所有用户(测试)
    List<Map<String ,Object>> selAllUser();
}
