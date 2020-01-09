package com.eb.test.model;

public class Params {
  
	private int pageNo=1; //页码
	
	private int pageSize=3; //每页查询数目

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
