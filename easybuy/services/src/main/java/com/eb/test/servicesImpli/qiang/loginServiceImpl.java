package com.eb.test.servicesImpli.qiang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.MapperDao.EasybuyUserMapper;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.qiang.ILoginService;

@Service
public class loginServiceImpl implements ILoginService{

	@Autowired
	private EasybuyUserMapper eum;
	
	//登录————判断用户名密码是否正确
	@Override
	public EasybuyUser loginSelect(String loginName, String password) {
		return eum.loginSelect(loginName, password);
	}

	//判断用户名是否存在
	public boolean SelectloginName(String loginName) {
		int num = eum.SelectloginName(loginName);
		if(num>0) {
			return true;
		}else {
			return false;
		}
	}
}
