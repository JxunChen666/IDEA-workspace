package com.eb.test.servicesImpli.xu.UserIcon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.servicesDao.xu.IconDao.UserIconServcieDao;
import com.eb.test.utilMapperDao.UserIconMapper;
import com.eb.test.utilmodel.UserIcon;

@Service
public class UserIconImpl  implements UserIconServcieDao{
	
	@Autowired
	UserIconMapper  userIconMapper ;
	
	@Override
	public UserIcon selectUicByUid(Integer uid) {
		UserIcon uic=userIconMapper.selecUicontById(uid);
	//	System.out.println("usericon:"+uic.toString());
		return uic;
	}

	@Override
	public int InsertOrUpd(UserIcon userIcon) {
		int uid=userIconMapper.InsetOrUpd(userIcon);
	//	System.out.println("uid  "+uid);
		return uid;
	}

}
