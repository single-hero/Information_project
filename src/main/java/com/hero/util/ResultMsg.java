package com.hero.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回数据格式
 * @author hero
 * @time 2018.05.010
 */

public class ResultMsg {

    //枚举
    public enum Code{
        Success,Error
    }

    //状态码
    Code state;
    //结果集
    Object result;
    //内容信息
    String msg;

    //成功返回信息
    public ResultMsg(Code state, Object result, String msg) {
        super();
        this.state = state;
        this.result = result;
        this.msg = msg;
    }
    //失败返回信息
    public ResultMsg(Code state, String msg) {
        super();
        this.state = state;
        this.result = new Object();
        this.msg = msg;
    }

    //getter and setter
    public Code getState() {
        return state;
    }

    public void setState(Code state) {
        this.state = state;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    @Override
    public String toString(){

        JSONObject json=new JSONObject();
        json.put("state",state);
        json.put("result",result);
        json.put("msg",msg);
        return json.toString();
    }
}
