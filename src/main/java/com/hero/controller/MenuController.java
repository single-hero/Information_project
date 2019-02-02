package com.hero.controller;

import com.hero.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
