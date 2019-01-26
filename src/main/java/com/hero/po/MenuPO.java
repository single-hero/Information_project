package com.hero.po;


import com.alibaba.fastjson.annotation.JSONField;
import com.hero.systemBase.DatabaseTableName;

import java.util.Date;
import java.util.List;

/**
 * 后台系统菜单Po类
 * @author chenwenwei
 * @time 2019.01.26
 */
@DatabaseTableName("sys_menu")
public class MenuPO {

    private Integer id; //id
    private String menuName;    //菜单名称
    private Integer parentId;   //父级id
    private String parentName;  //父级菜单
    private String url;         //链接地址
    // 添加时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    // 修改时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date upTime;

    private List<MenuPO> menuNode;  //子菜单集

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuPO> getMenuNode() {
        return menuNode;
    }

    public void setMenuNode(List<MenuPO> menuNode) {
        this.menuNode = menuNode;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }
}
