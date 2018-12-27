package com.hero.systemBase;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回数据格式
 * @author chenwenwei
 * @time 2018.05.10
 */

public class ResultMsg {

    //枚举
    public enum Msg{
        Success,Error
    }

    //状态信息
    Msg state;
    //结果集
    Object data;
    //状态码
    String code;


    //成功返回信息
    public ResultMsg(Msg state,String code,Object data) {
        super();
        this.state = state;
        this.code = code;
        this.data = data;
    }
    //失败返回信息
    public ResultMsg(Msg state,String code) {
        super();
        this.state = state;
        this.code = code;
//        this.result = new Object();
    }


    //getter and setter


    public Msg getState() {
        return state;
    }

    public void setState(Msg state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return data;
    }

    public void setResult(Object result) {
        this.data = result;
    }


    @Override
    public String toString(){
        JSONObject json=new JSONObject();
        json.put("state",state);
        json.put("code",code);
        json.put("data",data);
        return json.toString();
    }
}
