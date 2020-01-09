package com.eb.test.model;

import java.io.Serializable;

public class EasybuyUser implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String username;

    private String loginname;

    private String password;

    private Integer sex;

    private Long identitycode;

    private String email;

    private String mobile;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getIdentitycode() {
        return identitycode;
    }

    public void setIdentitycode(Long identitycode) {
        this.identitycode = identitycode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "EasybuyUser [id=" + id + ", username=" + username + ", loginname=" + loginname + ", password="
				+ password + ", sex=" + sex + ", identitycode=" + identitycode + ", email=" + email + ", mobile="
				+ mobile + ", type=" + type + "]";
	}
    
    
}