package com.eb.test.servicesImpli.xu.MyBuyCar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.servicesDao.xu.BuyCarDao.MyCarDao;
import com.eb.test.utilMapperDao.UserBuyCarMapper;
import com.eb.test.utilmodel.UserBuyCar;
@Service
public class MyCar implements MyCarDao{
	@Autowired
	private UserBuyCarMapper userBuyCarMapper;
	
	@Override
	public List<UserBuyCar> slectMyCar(Integer users) {
		 List<UserBuyCar> mycar=userBuyCarMapper.slectMyCar(users);
		return mycar;
	}
	
}
