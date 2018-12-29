package com.hero.systemBase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hero.util.AESUtil;
import com.hero.util.Base64EncodUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * 公共父类
 * @author chenwenwei
 * @time 2018.10.18
 */
public class BaseConfig implements Serializable {
    @Value("${KEY}")
    private String key;
    //开启日志
    protected Logger logger= LoggerFactory.getLogger(this.getClass());
    /**
     * 得到PageData
     */
    public PageData getPageData(){
        return new PageData(this.getRequest());
    }

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        return request;
    }

    /**
     * 加密返回数据
     */
    public String getResponseParam(ResultMsg message){
        try {
            return Base64EncodUtil.encode(new AESUtil().Encrypt(message.toString(),key));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *得到的po类转成可视JSON
     */
    public JSONObject changeJSON(Object object){
        String json= JSON.toJSONString(object);
        return JSONObject.parseObject(json);
    }

}
