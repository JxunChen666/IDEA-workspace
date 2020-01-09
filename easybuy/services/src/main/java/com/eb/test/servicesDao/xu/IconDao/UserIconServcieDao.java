package com.eb.test.servicesDao.xu.IconDao;

import com.eb.test.utilmodel.UserIcon;

public interface UserIconServcieDao {
	
	public UserIcon selectUicByUid(Integer uid);
	
	
	public int InsertOrUpd(UserIcon  userIcon);
}
