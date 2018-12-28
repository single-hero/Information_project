package com.hero.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hero.dao.LoginDao;
import com.hero.service.LoginService;
import com.hero.systemBase.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 登陆service层impl(存放实现类型)
 * @author chenwenwei
 * @time 2018.12.27
 */
@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;

    @Value("${KEY}")
    private String key;

    //多数据源测试
    @Override
//    @TargetDataSource(name="ds1")
    public ResultMsg selAllUser() {
        return new ResultMsg(ResultMsg.Msg.Success,"100",loginDao.selAllUser());
    }


    //系统用户登陆验证
    @Override
    public ResultMsg responseParam(JSONObject jsonParam) {
        String responseParam="";
        try {
            System.out.println(JSON.toJSONString(loginDao.systemLoginCheck(jsonParam)));
//            responseParam= Base64EncodUtil.encode(new AESUtil().Encrypt(jsonParam.toJSONString(),key));
//            System.out.println(new AESUtil().Encrypt(jsonParam.toJSONString(),key));
//            System.out.println(loginService.selAllUser());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(ResultMsg.Msg.Error,"500");
        }
        return new ResultMsg(ResultMsg.Msg.Success,"200",responseParam);
    }


}
