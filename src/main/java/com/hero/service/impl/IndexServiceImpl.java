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
            MenuPO listNode=new MenuPO();
            listNode.setId(item.getId());
            listNode.setMenuName(item.getMenuName());
            listNode.setParentId(item.getParentId());
            listNode.setParentName(item.getParentName());
            listNode.setUrl(item.getUrl());
            if(item.getId()!=0){
            classMenuNode(listNode);
            menuListNode.add(listNode);
            }
        }
//        System.out.println("meunListNode=====>>"+ JSON.toJSONString(menuListNode));
        return menuListNode;
    }

    //子节点
    private void classMenuNode(MenuPO menuPO){
        //获取子菜单
        List<MenuPO> menuList=indexDAO.selParentNode(menuPO.getId());
        List<MenuPO> menuListNode=new ArrayList<>();
        for (MenuPO item:menuList) {
            MenuPO listNode=new MenuPO();
            listNode.setId(item.getId());
            listNode.setMenuName(item.getMenuName());
            listNode.setParentId(item.getParentId());
            listNode.setParentName(item.getParentName());
            listNode.setUrl(item.getUrl());
            //将赋值好的MenuPO的对象加入到list集合
            menuListNode.add(listNode);
            //meunListNode 集合赋值给List<menuPO>集合
            menuPO.setMenuNode(menuListNode);
            //开始递归
            if(menuPO.getId()!=0){
                classMenuNode(listNode);
            }

        }

    }
}
