package com.hero.controller;

import com.alibaba.fastjson.JSONObject;
import com.hero.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台菜单管理Controller层
 * @author chenwenwei
 * @time 2019.02.01
 */
@Controller
@RequestMapping(value = "/SysMenu")
public class MenuController {

    @Autowired
    MenuService menuService;

    //菜单列表
    @GetMapping(value = "/list")
    public ModelAndView menuList(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/Menu/MenuList");
        mv.addObject("List",menuService.selAllMenuListMapService());
        return mv;
    }


    //菜单排序修改
    @PutMapping(value = "/updateRank")
    public @ResponseBody Object updateRank(HttpServletRequest request){
        return menuService.updateRank((JSONObject) request.getAttribute("jsonParam"));
    }
}
