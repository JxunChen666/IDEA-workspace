package com.eb.test.utilmodel;

import java.io.Serializable;

public class UserIcon  implements Serializable {
	
	
	private int  uid;
	private String fileName;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "UserIcon [uid=" + uid + ", fileName=" + fileName + "]";
	}

	

}
