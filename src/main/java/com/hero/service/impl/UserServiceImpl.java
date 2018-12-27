package com.hero.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hero.dao.UserDAO;
import com.hero.po.User;
import com.hero.service.UserService;
import com.hero.systemBase.ResultMsg;
import com.hero.systemBase.SystemMessageContents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 业务逻辑实现-用户impl(存放实现类型)
 * @author chenwenwei
 * @time 2018.05.05
 */

@Service
public class UserServiceImpl implements UserService {
    //开启日志
    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDAO userDao;


    /**
     * 查询User表所有数据
     * @return
     */
    @Override
    public ResultMsg SelectUser(){
        //异常处理
        try {
            //操作处理
            List<User>list=userDao.SelectUser();
            //判断list为空或者list容器没有内容
            if(list==null ||list.isEmpty()){
                return new ResultMsg(ResultMsg.Msg.Error,"没有相关数据");
            }
            return new ResultMsg(ResultMsg.Msg.Success, SystemMessageContents.SuccessCode.MESSAGE_SUCCESS_CODE+"",JSONObject.parse(JSONObject.toJSONString(list)));
        }catch (Exception e){
            logger.error("异常:"+e.toString());
            return new ResultMsg(ResultMsg.Msg.Error,SystemMessageContents.ErrorCode.MESSAGE_SERVER_RESPONSE_NULL+"");
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
            int add=userDao.InsertUser(user);
            if(add<=0){
                return new ResultMsg(ResultMsg.Msg.Error,SystemMessageContents.ErrorCode.MESSAGE_COMMON_CODE+"","添加失败");
            }
            JSONObject result=new JSONObject();
            result.put("id",add);
            return new ResultMsg(ResultMsg.Msg.Success,SystemMessageContents.SuccessCode.MESSAGE_SUCCESS_CODE+"","添加成功");
        }catch (Exception e){
            logger.error("异常:"+e.toString());
            return new ResultMsg(ResultMsg.Msg.Error,SystemMessageContents.ErrorCode.MESSAGE_COMMON_CODE+"");
        }

    }

}
