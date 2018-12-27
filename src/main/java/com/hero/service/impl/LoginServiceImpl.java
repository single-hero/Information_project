package com.hero.service.impl;

import com.hero.dao.LoginDao;
import com.hero.service.LoginService;
import com.hero.systemBase.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
//    @TargetDataSource(name="ds1")
    public ResultMsg selAllUser() {
        return new ResultMsg(ResultMsg.Msg.Success,"100",loginDao.selAllUser());
    }
}
