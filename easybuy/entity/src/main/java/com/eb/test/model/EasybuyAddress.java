package com.eb.test.model;

import java.io.Serializable;

/**
 * 
 * @author weizhen
 *
 */
//收货地址表
public class EasybuyAddress implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//id not null
	private Integer userid;//userid not null
	private String remark;//备注
	private String name;//用户名称 not null
	private String email;//邮箱 not null
	private String addressdetail;//详细地址 not null
	private Integer code;//邮编
	private String mobile;//手机 not null
	private String phone;//电话
	private String build;//建筑标志
	private String basttime;//最佳配送时间
	private Integer isdefault;//是否为默认地址 0 1
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressdetail() {
		return addressdetail;
	}
	public void setAddressdetail(String addressdetail) {
		this.addressdetail = addressdetail;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBuild() {
		return build;
	}
	public void setBuild(String build) {
		this.build = build;
	}
	public String getBasttime() {
		return basttime;
	}
	public void setBasttime(String basttime) {
		this.basttime = basttime;
	}
	public Integer getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
	}
	public EasybuyAddress(Integer id, Integer userid, String remark, String name, String email, String addressdetail,
			Integer code, String mobile, String phone, String build, String basttime, Integer isdefault) {
		super();
		this.id = id;
		this.userid = userid;
		this.remark = remark;
		this.name = name;
		this.email = email;
		this.addressdetail = addressdetail;
		this.code = code;
		this.mobile = mobile;
		this.phone = phone;
		this.build = build;
		this.basttime = basttime;
		this.isdefault = isdefault;
	}
	public EasybuyAddress() {
		super();
	}
	
	
}
