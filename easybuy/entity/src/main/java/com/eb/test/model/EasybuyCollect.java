package com.eb.test.model;

import java.io.Serializable;

public class EasybuyCollect implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer userid;

    private Integer productid;

    private Integer productnum;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getProductnum() {
        return productnum;
    }

    public void setProductnum(Integer productnum) {
        this.productnum = productnum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "EasybuyCollect [id=" + id + ", userid=" + userid + ", productid=" + productid + ", productnum="
				+ productnum + ", type=" + type + "]";
	}
    
    
}