package com.eb.test.servicesImpli.qiang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.MapperDao.EasybuyUserMapper;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.qiang.IRegistService;

@Service
public class RegistServiceImpl implements IRegistService{

	@Autowired
	private EasybuyUserMapper eum;
	
	//注册功能
	@Override
	public boolean insertSelective(EasybuyUser easybuyuser) {
		int num = eum.insertSelective(easybuyuser);
		if(num>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean SelectloginName(String loginName) {
		int num = eum.SelectloginName(loginName);
		if(num>0) {
			return true;
		}else {
			return false;
		}
	}
}
