/**
 * Project Name:kcloud File Name:SysLog.java Package Name:com.iflytek.kcloud.web.entity.system
 * Date:2014年7月6日上午10:52:05 Copyright (c) 2014, zyyang3@iflytek.com All Rights Reserved.
 *
 */

package com.fangjian.zhenbao.business.system.entity;

/**
 * ClassName:SysLog <br/>
 * Description: 记录用户操作系统的日志. <br/>
 * Date: 2014年7月6日 上午10:52:05 <br/>
 *
 * @author zyyang3
 * @version 1.0
 * @since JDK 1.6
 */
public class SysLog {

    private String username;
    private String ip;
    private String methodname;
    private String remark;
    private String stat_date;
    private String time;


    /**
     * username.
     *
     * @return the username
     * @since JDK 1.6
     */
    public String getUsername() {
        return username;
    }

    /**
     * username.
     *
     * @param username the username to set
     * @since JDK 1.6
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * ip.
     *
     * @return the ip
     * @since JDK 1.6
     */
    public String getIp() {
        return ip;
    }

    /**
     * ip.
     *
     * @param ip the ip to set
     * @since JDK 1.6
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * methodname.
     *
     * @return the methodname
     * @since JDK 1.6
     */
    public String getMethodname() {
        return methodname;
    }

    /**
     * methodname.
     *
     * @param methodname the methodname to set
     * @since JDK 1.6
     */
    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    /**
     * remark.
     *
     * @return the remark
     * @since JDK 1.6
     */
    public String getRemark() {
        return remark;
    }

    /**
     * remark.
     *
     * @param remark the remark to set
     * @since JDK 1.6
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * stat_date.
     *
     * @return the stat_date
     * @since JDK 1.6
     */
    public String getStat_date() {
        return stat_date;
    }

    /**
     * stat_date.
     *
     * @param stat_date the stat_date to set
     * @since JDK 1.6
     */
    public void setStat_date(String stat_date) {
        this.stat_date = stat_date;
    }

    /**
     * time.
     *
     * @return the time
     * @since JDK 1.6
     */
    public String getTime() {
        return time;
    }

    /**
     * time.
     *
     * @param time the time to set
     * @since JDK 1.6
     */
    public void setTime(String time) {
        this.time = time;
    }

	@Override
	public String toString() {
		return "SysLog [username=" + username + ", ip=" + ip + ", methodname="
				+ methodname + ", remark=" + remark + ", stat_date="
				+ stat_date + ", time=" + time + "]";
	}
    
}
