package com.hero.service;

import com.alibaba.fastjson.JSONObject;
import com.hero.dao.impl.UserDaoImpl;
import com.hero.po.User;
import com.hero.service.impl.UserServiceImpl;
import com.hero.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 业务逻辑实现-用户
 * @author hero
 * @time 2018.05.05
 */

@Service
public class UserService implements UserServiceImpl{

    @Autowired
    UserDaoImpl userDAOImpl;


    //User查询表所有数据
    @Override
    public ResultMsg SelectUser(){
        try {
            //操作处理
            List<User>list=userDAOImpl.SelectUser();
            if(list==null ||list.isEmpty()){
                return new ResultMsg(ResultMsg.Code.Error,"没有相关数据");
            }
            return new ResultMsg(ResultMsg.Code.Success, JSONObject.parse(JSONObject.toJSONString(list)),"成功");
        }catch (Exception e){
            return new ResultMsg(ResultMsg.Code.Error,e.getMessage());
        }
    }
}
