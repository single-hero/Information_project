package com.hero.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hero.dao.MenuDAO;
import com.hero.service.MenuService;
import com.hero.systemBase.BaseConfig;
import com.hero.systemBase.ResultMsg;
import com.hero.systemBase.SystemMessageContents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 菜单业务逻辑层
 * @author chenwenwei
 * @time 2019.02.02
 */
@Service
public class MenuServiceImpl extends BaseConfig implements MenuService {

    @Autowired
    MenuDAO menuDAO;

    //查询所有菜单列(HttpStatus.SC_OK,原生状态码类库)
    @Override
    public ResultMsg selAllMenuListMapService() {
        try{
            List<Map<String,Object>> list=menuDAO.selAllMenuListMap();
            if(list.size()>0){
                //获取数据成功返回状态100
                return new ResultMsg(ResultMsg.Msg.Success,SystemMessageContents.SuccessCode.MESSAGE_SUCCESS_CODE+"",JSONArray.toJSON(list));
            }
            //获取数据成功但没有数据,返回204
            return new ResultMsg(ResultMsg.Msg.Success,SystemMessageContents.ErrorCode.MESSAGE_COMMON_DATA_NULL_ERROR+"");
        }catch (Exception e){
            e.printStackTrace();
            //系统异常(201)
            return new ResultMsg(ResultMsg.Msg.Error, SystemMessageContents.ErrorCode.MESSAGE_COMMON_CODE+"");
        }
    }


    //根据id修改菜单排序
    @Override
    public ResultMsg updateRank(JSONObject jsonParam) {
        try {
            Integer result=menuDAO.updateMenuRank(jsonParam);
            if(result>0){
                //修改数据成功返回状态100
                return new ResultMsg(ResultMsg.Msg.Success,SystemMessageContents.SuccessCode.MESSAGE_SUCCESS_CODE+"");
            }
            //修改数据失败返回205
            return new ResultMsg(ResultMsg.Msg.Error,SystemMessageContents.ErrorCode.MESSAGE_COMMON_DATA_ERROR+"");
        }catch (Exception e){
            e.printStackTrace();
            //系统异常(201)
            return new ResultMsg(ResultMsg.Msg.Error, SystemMessageContents.ErrorCode.MESSAGE_COMMON_CODE+"");
        }
    }


}
