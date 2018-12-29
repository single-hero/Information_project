package com.hero.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hero.dao.LoginDao;
import com.hero.service.LoginService;
import com.hero.systemBase.BaseConfig;
import com.hero.systemBase.ResultMsg;
import com.hero.systemBase.SystemMessageContents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登陆service层impl(存放实现类型)
 * @author chenwenwei
 * @time 2018.12.27
 */
@Service("LoginServiceImpl")
public class LoginServiceImpl extends BaseConfig implements LoginService{
    @Autowired
    LoginDao loginDao;

    //多数据源测试
    @Override
//    @TargetDataSource(name="ds1")
    public ResultMsg selAllUser() {
        return new ResultMsg(ResultMsg.Msg.Success,"100",loginDao.selAllUser());
    }


    //系统用户登陆验证
    @Override
    public ResultMsg systemLoginCheckService(JSONObject jsonParam) {
        try {
            JSONObject param=this.changeJSON(loginDao.systemLoginCheckDao(jsonParam));
            if (param!=null){
                //校验成功
                return new ResultMsg(ResultMsg.Msg.Success, SystemMessageContents.SuccessCode.MESSAGE_SUCCESS_CODE+"");
            }
            else{
                //用户不存在
                return new ResultMsg(ResultMsg.Msg.Error,SystemMessageContents.ErrorCode.MESSAGE_USERS_NOT_EXTIS_ERROR+"");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(ResultMsg.Msg.Error,SystemMessageContents.ErrorCode.MESSAGE_COMMON_CODE+"");
        }
    }
}
