/**
 * Project Name:kcloud
 * File Name:Data.java
 * Package Name:com.iflytek.kcloud.web.entity.system
 * Date:2014年6月23日上午10:17:05
 * Copyright (c) 2014, zyyang3@iflytek.com All Rights Reserved.
 *
 */

package com.fangjian.zhenbao.business.system.entity;

/**
 * ClassName:Data <br/>
 * Description: highchart具体数据项. <br/>
 * Date:     2014年6月23日 上午10:17:05 <br/>
 *
 * @author zyyang3
 * @version 1.0
 * @see
 * @since JDK 1.6
 */
public class Data {

    private String name;
    private Object y;

    /**
     * name.
     *
     * @return the name
     * @since JDK 1.6
     */
    public String getName() {
        return name;
    }

    /**
     * name.
     *
     * @param name the name to set
     * @since JDK 1.6
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * y.
     *
     * @return the y
     * @since JDK 1.6
     */
    public Object getY() {
        return y;
    }

    /**
     * y.
     *
     * @param y the y to set
     * @since JDK 1.6
     */
    public void setY(Object y) {
        this.y = y;
    }

}

