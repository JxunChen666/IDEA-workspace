package com.fangjian.zhenbao.business.city.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ChuJing
 *
 * @date 2015年12月31日
 */
public class City {
	 @JsonProperty("_id")
	 private String id;
	 private String name;
	 private String cityCode;
	 private long seqence;
	 private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public long getSeqence() {
		return seqence;
	}
	public void setSeqence(long seqence) {
		this.seqence = seqence;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", cityCode=" + cityCode
				+ ", seqence=" + seqence + ", status=" + status + "]";
	}
	 

}
