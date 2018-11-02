package com.hero.util;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public final class UserClient {

    public final static List UserAgent(HttpServletRequest request){
        //客户端访问设备抓取
        String userAgentEquipment=request.getHeader("user-agent");
        //返回客户端类型
        String userClients="";
        List<String> list=new ArrayList<>();

        //客户端访问设备抓取(第三方应用)
        UserAgent userAgent=UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        //浏览器
        Browser browser=userAgent.getBrowser();
        //操作系统类型
        OperatingSystem os =userAgent.getOperatingSystem();


        //移动端
        if(userAgentEquipment.contains("Android") || userAgentEquipment.contains("Linux")){
            userClients="Android客户端";
            list.add(userClients);
        }
        if(userAgentEquipment.contains("iPhone")){
            userClients="iPhone客户端";
            list.add(userClients);
        }
        if(userAgentEquipment.contains("iPad")){
            userClients="iPad客户端";
            list.add(userClients);
        }

        //第三方应用
        if(userAgentEquipment.contains("MicroMessenger")){
            userClients="微信";
            list.add(userClients);
        }
        if(userAgentEquipment.contains("Alipay")){
            userClients="支付宝";
            list.add(userClients);
        }
        if(userAgentEquipment.contains("Weibo")){
            userClients="微博";
            list.add(userClients);
        }
        if(userAgentEquipment.contains("DingTalk")){
            userClients="钉钉";
            list.add(userClients);
        }
        if(userAgentEquipment.contains("QQ")){
            userClients="QQ";
            list.add(userClients);
        }


        //浏览器
        if(userAgentEquipment.contains("MSIE") && userAgentEquipment.contains("Trident") && !userAgentEquipment.contains("WOW64")){
            userClients="IE浏览器("+browser+"内核)";
            list.add(userClients);
        }
        if(userAgentEquipment.contains("Firefox")){
            userClients="火狐浏览器";
            list.add(userClients);
        }
        if(browser.toString().equals("CHROME") && !userAgentEquipment.contains("QQBrowser")){
            userClients="谷歌浏览器";
            list.add(userClients);
        }
        if(userAgentEquipment.contains("QQBrowser")){
            if(userAgentEquipment.contains("compatible")){
                userClients="QQ浏览器兼容模式("+browser+"内核)";
                list.remove(0);
                list.add(userClients);
            }else {
                userClients="QQ浏览器极速模式";
                list.remove(0);
                list.add(userClients);
            }
        }
        if(browser.toString().equals("CHROME42")){
            userClients="360浏览器极速模式";
            list.add(userClients);
        }
        if(userAgentEquipment.contains("compatible") && userAgentEquipment.contains("MSIE") && !userAgentEquipment.contains("QQBrowser")){
            if(userAgentEquipment.contains("SLCC2")){
                userClients="360浏览器兼容模式";
                list.add(userClients);
            }
            else if(userAgentEquipment.contains("WOW64")){
                userClients="360浏览器("+browser+"模式)";
                list.add(userClients);
            }
        }

        if(userAgentEquipment.contains("Safari") && !userAgentEquipment.contains("Chrome")){
            userClients="Safari浏览器";
            list.add(userClients);
        }

        //接口测试软件
        if(userAgentEquipment.contains("Postman")){
            userClients="Postman";
            list.add(userClients);
        }
        if(userAgentEquipment.contains("Apache-HttpClient")){
            userClients="Apache-HttpClient";
            list.add(userClients);
        }
        list.add(os.toString()+"操作系统");
        return list;
    }
}
