/**
 * Project Name:kcloud File Name:Series.java Package Name:com.iflytek.kcloud.web.entity.system
 * Date:2014年6月22日下午11:47:06 Copyright (c) 2014, zyyang3@iflytek.com All Rights Reserved.
 *
 */

package com.fangjian.zhenbao.business.system.entity;

import java.util.List;

/**
 * ClassName:Series <br/>
 * Description: HighChart序列化数据. <br/>
 * Date: 2014年6月22日 下午11:47:06 <br/>
 *
 * @author zyyang3
 * @version 1.0
 * @see
 * @since JDK 1.6
 */
public class Series {

    private String name;
    private List<Data> data;
    private Boolean visible;

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
     * data.
     *
     * @return the data
     * @since JDK 1.6
     */
    public List<Data> getData() {
        return data;
    }

    /**
     * data.
     *
     * @param data the data to set
     * @since JDK 1.6
     */
    public void setData(List<Data> data) {
        this.data = data;
    }

    /**
     * visible.
     *
     * @return the visible
     * @since JDK 1.6
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     * visible.
     *
     * @param visible the visible to set
     * @since JDK 1.6
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

}
