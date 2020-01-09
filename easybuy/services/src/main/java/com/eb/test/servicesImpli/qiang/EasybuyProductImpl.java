package com.eb.test.servicesImpli.qiang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.MapperDao.EasybuyProductMapper;
import com.eb.test.model.EasybuyProduct;
import com.eb.test.servicesDao.qiang.IEasybuyProductService;

@Service
public class EasybuyProductImpl implements IEasybuyProductService{

	@Autowired
	private EasybuyProductMapper epm;
	
	@Override
	public boolean insertSelective(EasybuyProduct ep) {
		int num = epm.insertSelective(ep);
		if (num>0) {
			return true;
		}else {
			return false;
		}
	}
	
}
