package com.hero.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回数据格式
 * @author chenwenwei
 * @time 2018.05.10
 */

public class ResultMsg {

    //枚举
    public enum Code{
        Success,Error
    }

    //状态
    Code state;
    //状态码
    String stateCode;
    //结果集
    Object result;
    //内容信息
    String msg;


    //成功返回信息
    public ResultMsg(Code state,String stateCode ,String msg,Object result) {
        super();
        this.state = state;
        this.stateCode=stateCode;
        this.msg = msg;
        this.result = result;
    }
    //失败返回信息
    public ResultMsg(Code state,String stateCode, String msg) {
        super();
        this.state = state;
        this.stateCode=stateCode;
        this.msg = msg;
        this.result = new Object();
    }


    //getter and setter
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
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
        json.put("stateCode",stateCode);
        json.put("msg",msg);
        json.put("result",result);
        return json.toString();
    }
}
