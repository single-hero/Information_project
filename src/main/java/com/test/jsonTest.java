package com.test;

import com.alibaba.fastjson.JSON;
import com.hero.po.User;
import com.sun.glass.ui.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class jsonTest {

    @Test
    public void beanToJson(){
        User u1=new User();
        u1.setAccount("myTest");
        u1.setPassword("myPassword");
        String s1= JSON.toJSONString(u1);
        System.out.println(s1);
    }

    @Test
    public void listToJson(){
        List<User>list=new ArrayList<>();
        User u1=new User();
        u1.setAccount("myTest1");
        u1.setPassword("myPassword1");
        User u2=new User();
        u2.setAccount("myTest2");
        u2.setPassword("myPassword2");

        list.add(u1);
        list.add(u2);
        String s1= JSON.toJSONString(list);
        System.out.println(s1);
    }

    @Test
    public void mapToJson(){
        Map<String,Object>map=new HashMap<>();
        List<User> list=new ArrayList<>();

        User u1=new User();
        u1.setAccount("myTest1");
        u1.setPassword("myPassword1");
        User u2=new User();
        u2.setAccount("myTest2");
        u2.setPassword("myPassword2");

        list.add(u1);
        list.add(u2);

        map.put("list",list);
        map.put("total",list.size());
        String sm=JSON.toJSONString(map);
        System.out.println(sm);
    }
}
