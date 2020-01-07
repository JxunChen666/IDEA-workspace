/**
 * Project Name:kcloud File Name:Menu.java Package Name:com.iflytek.kcloud.web.entity
 * Date:2014年5月12日下午4:29:48 Copyright (c) 2014, zyyang3@iflytek.com All Rights Reserved.
 *
 */

package com.fangjian.zhenbao.business.system.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:Menu <br/>
 * Description: 页面菜单类. <br/>
 * Date: 2014年5月12日 下午4:29:48 <br/>
 *
 * @author zyyang3
 * @version 1.0
 * @since JDK 1.6
 */
public class Menu {
    private String title_menu;
    private List<String> parent_menu = new ArrayList<String>(); // 父菜单:1.名称、2.关键字、 3.图标
    private Map<String, String[]> child_menu = new HashMap<String, String[]>();// 子菜单名称 & 1.URL、2.关键字、3.菜单权限

    /**
     * title_menu.
     *
     * @return the title_menu
     * @since JDK 1.6
     */
    public String getTitle_menu() {
        return title_menu;
    }

    /**
     * title_menu.
     *
     * @param title_menu the title_menu to set
     * @since JDK 1.6
     */
    public void setTitle_menu(String title_menu) {
        this.title_menu = title_menu;
    }

    /**
     * parent_menu.
     *
     * @return the parent_menu
     * @since JDK 1.6
     */
    public List<String> getParent_menu() {
        return parent_menu;
    }

    /**
     * parent_menu.
     *
     * @param parent_menu the parent_menu to set
     * @since JDK 1.6
     */
    public void setParent_menu(List<String> parent_menu) {
        this.parent_menu = parent_menu;
    }

    /**
     * child_menu.
     *
     * @return the child_menu
     * @since JDK 1.6
     */
    public Map<String, String[]> getChild_menu() {
        return child_menu;
    }

    /**
     * child_menu.
     *
     * @param child_menu the child_menu to set
     * @since JDK 1.6
     */
    public void setChild_menu(Map<String, String[]> child_menu) {
        this.child_menu = child_menu;
    }

	@Override
	public String toString() {
		return "Menu [title_menu=" + title_menu + ", parent_menu="
				+ parent_menu.toString() + ", child_menu=" + child_menu.toString() + "]";
	}
    
}
