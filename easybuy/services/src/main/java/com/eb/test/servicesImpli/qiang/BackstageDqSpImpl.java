package com.eb.test.servicesImpli.qiang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.dqutilmodel.easybuydqsp;
import com.eb.test.servicesDao.qiang.IBackstageDqSpService;
import com.eb.test.utilMapperDao.UserBuyDqSpMapper;

@Service
public class BackstageDqSpImpl implements IBackstageDqSpService{

	@Autowired
	private UserBuyDqSpMapper ubdsm;
	
	@Override
	public List<easybuydqsp> selectAlldqsp() {
		return ubdsm.selectAlldqsp();
	}
	
	
	
}
