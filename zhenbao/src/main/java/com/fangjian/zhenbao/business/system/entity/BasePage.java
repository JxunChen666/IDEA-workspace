package com.fangjian.zhenbao.business.system.entity;

/**
 * @author zyyang3
 * @version 1.0
 * @date 2014-03-07
 * @description 模板页面基础参数设置
 */

public class BasePage {
    /**
     * 登陆模块
     */
    private String block;

    /**
     * 侧边栏标题
     */
    private String title;

    /**
     * 侧边栏目录
     */
    private String menu;

    /**
     * 当前位置标题
     */
    private String currentTitle;

    /**
     * 当前位置目录
     */
    private String currentMenu;

    /**
     * 是否选择环境（自动化发布定制字段）
     */
    private String selectDeploy;
    /**
     * 选择语义测试环境定制，选择环境nluTest/tvTest
     */
    private String selectNluDeploy;

    /**
     * 消息
     */
    private String message;

    public BasePage() {

    }

    public BasePage(String block, String title, String menu, String currentTitle,
        String currentMenu) {
        this.block = block;
        this.title = title;
        this.menu = menu;
        this.currentTitle = currentTitle;
        this.currentMenu = currentMenu;
    }

    public BasePage(String block, String title, String menu, String currentTitle,
        String currentMenu, String message) {
        this.block = block;
        this.title = title;
        this.menu = menu;
        this.currentTitle = currentTitle;
        this.currentMenu = currentMenu;
        this.message = message;
    }



    /**
     * @return the block
     */
    public String getBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
    public void setBlock(String block) {
        this.block = block;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the menu
     */
    public String getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(String menu) {
        this.menu = menu;
    }

    /**
     * @return the currentTitle
     */
    public String getCurrentTitle() {
        return currentTitle;
    }

    /**
     * @param currentTitle the currentTitle to set
     */
    public void setCurrentTitle(String currentTitle) {
        this.currentTitle = currentTitle;
    }

    /**
     * @return the currentMenu
     */
    public String getCurrentMenu() {
        return currentMenu;
    }

    /**
     * @param currentMenu the currentMenu to set
     */
    public void setCurrentMenu(String currentMenu) {
        this.currentMenu = currentMenu;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public String getSelectDeploy() {
        return selectDeploy;
    }

    public void setSelectDeploy(String selectDeploy) {
        this.selectDeploy = selectDeploy;
    }

    public String getSelectNluDeploy() {
        return selectNluDeploy;
    }

    public void setSelectNluDeploy(String selectNluDeploy) {
        this.selectNluDeploy = selectNluDeploy;
    }
}
