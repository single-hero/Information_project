package com.hero.service;

import com.alibaba.fastjson.JSONObject;
import com.hero.dao.impl.UserDaoImpl;
import com.hero.po.User;
import com.hero.service.impl.UserServiceImpl;
import com.hero.util.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 业务逻辑实现-用户
 * @author chenwenwei
 * @time 2018.05.05
 */

@Service
public class UserService implements UserServiceImpl{
    //开启日志
    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDaoImpl userDAOImpl;


    /**
     * 查询User表所有数据
     * @return
     */
    @Override
    public ResultMsg SelectUser(){
        //异常处理
        try {
            //操作处理
            List<User>list=userDAOImpl.SelectUser();
            //判断list为空或者list容器没有内容
            if(list==null ||list.isEmpty()){
                return new ResultMsg(ResultMsg.Code.Error,"没有相关数据");
            }
            return new ResultMsg(ResultMsg.Code.Success, JSONObject.parse(JSONObject.toJSONString(list)),"成功");
        }catch (Exception e){
            logger.error("异常:"+e.toString());
            return new ResultMsg(ResultMsg.Code.Error,e.getMessage());
        }
    }


    /**
     * 向user表添加数据
     * @param user
     * @return
     */
    @Override
    public ResultMsg InsertUser(User user){
        try{
            // 参数处理
//            User user = JSONObject.toJavaObject(jsonObject, User.class);// 将建json对象转换为class对象
            user.setAddtime(new Date());
            user.setUptime(new Date());

            //操作处理
            int add=userDAOImpl.InsertUser(user);
            if(add<=0){
                return new ResultMsg(ResultMsg.Code.Error,"添加失败");
            }
            JSONObject result=new JSONObject();
            result.put("id",add);
            return new ResultMsg(ResultMsg.Code.Success,result,"添加成功");
        }catch (Exception e){
            logger.error("异常:"+e.toString());
            return new ResultMsg(ResultMsg.Code.Error,e.getMessage());
        }

    }

}
