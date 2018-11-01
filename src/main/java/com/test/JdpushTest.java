package com.test;

import com.hero.util.JdpushUtil;
import com.sun.glass.ui.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JdpushTest {
    @Value(value = "${jg_masterSecret}")
    private String masterSecret;//必填，每个应用都对应一个masterSecret
    @Value(value = "${jg_appKey}")
    private String appKey;


    @Test
    public void getKey(){
//        System.out.println("appKey:"+appKey);
//        System.out.println("masterSecret:"+masterSecret);
        JdpushUtil.testSendPush(appKey,masterSecret);
    }

}
