package com.hero.service.impl;

import com.hero.dao.IndexDAO;
import com.hero.po.MenuPO;
import com.hero.service.IndexService;
import com.hero.systemBase.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 后台系统首页service层
 * @author chenwenwei
 * @time 2019.01.26
 */
@Service
public class IndexServiceImpl extends BaseConfig implements IndexService{
    @Autowired
    IndexDAO indexDAO;

    //菜单树形结构(List)
    @Override
    public Object responseMenuList(){
        logger.info("进入树形结构List");
        List<MenuPO>menuListNode=null;
        //获取父级节点
        List<MenuPO> menuList=indexDAO.selParent();
        menuListNode=new ArrayList<>();
        for (MenuPO item:menuList) {
            MenuPO menuPO=new MenuPO();
            menuPO.setId(item.getId());
            menuPO.setMenuName(item.getMenuName());
            menuPO.setParentId(item.getParentId());
            menuPO.setParentName(item.getParentName());
            menuPO.setUrl(item.getUrl());
            classMenuNode(menuPO);
            menuListNode.add(menuPO);
        }
        return menuListNode;
    }

    //子节点
    private void classMenuNode(MenuPO menuPO){
        //获取子菜单
        List<MenuPO> menuList=indexDAO.selParentNode(menuPO.getId());
        List<MenuPO> menuListNode=new ArrayList<>();
        for (MenuPO item:menuList) {
            MenuPO menuPO1=new MenuPO();
            menuPO1.setId(item.getId());
            menuPO1.setMenuName(item.getMenuName());
            menuPO1.setParentId(item.getParentId());
            menuPO1.setParentName(item.getParentName());
            menuPO1.setUrl(item.getUrl());
            menuListNode.add(menuPO1);
            menuPO.setMenuNode(menuListNode);
            //开始递归
            classMenuNode(menuPO1);
        }

    }
}
