package com.fangjian.zhenbao.business.system.entity;

/**
 * Created by zyyang3 on 14-8-22.
 */
public class Product {

    private String cid; //产品cid
    private String appid;   //产品appid
    private String description; //产品描述
    private int use; //是否已经使用


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUse() {
        return use;
    }

    public void setUse(int use) {
        this.use = use;
    }
}
