package com.fangjian.zhenbao.business.system.entity;

/**
 * 管理用户表实体类
 * @author tangLiang
 * @date 2016-05-19
 */
public class TcUser {

	/** 主键ID*/
	private String id;
	/** 登录名*/
	private String userName;
	/** 密码*/
	private String password;
	/** 姓名*/
	private String name;
	/** email地址*/
	private String email;
	/** 电话号码*/
	private String phone;
	/** 角色id*/
	private String roleId;
	/** 状态 1—>可用，0->禁用*/
	private Integer status;
	/** 城市编码， "00"表示总部管理员*/
	private String cityCode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	@Override
	public String toString() {
		return "TcUser [id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", roleId=" + roleId + ", status=" + status + ", cityCode=" + cityCode
				+ "]";
	}
		
}
