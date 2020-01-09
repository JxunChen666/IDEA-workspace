package com.eb.test.servicesDao.qiang;

import com.eb.test.model.EasybuyUser;

public interface IRegistService {
	boolean insertSelective(EasybuyUser easybuyuser);
	
	boolean SelectloginName(String loginName);
}
