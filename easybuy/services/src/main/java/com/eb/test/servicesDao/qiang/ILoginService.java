package com.eb.test.servicesDao.qiang;

import com.eb.test.model.EasybuyUser;

public interface ILoginService {
	
	boolean SelectloginName(String loginName);
	EasybuyUser loginSelect(String loginName,String password);
}
