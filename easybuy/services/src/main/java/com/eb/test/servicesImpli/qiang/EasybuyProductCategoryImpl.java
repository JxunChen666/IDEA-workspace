package com.eb.test.servicesImpli.qiang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.MapperDao.EasybuyProductCategoryMapper;
import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyProductCategory;
import com.eb.test.servicesDao.qiang.IEasybuyProductCategoryService;

@Service
public class EasybuyProductCategoryImpl implements IEasybuyProductCategoryService{
	
	@Autowired
	private EasybuyProductCategoryMapper epcm;
	
	@Override
	public List<EasybuyProductCategory> selectXiaLaKuang(int typeval) {
		
		return epcm.selectXiaLaKuang(typeval);
	}

	@Override
	public List<EasybuyProductCategory> selectProductBuyLevel(Integer type) {
		List<EasybuyProductCategory> ls=epcm.selectProductBuyLevel(type);
		return ls;
	}

	@Override
	public List<EasybuyProductCategory> selectProductBuyLevelPID(Integer parentid) {
		List<EasybuyProductCategory> ls=epcm.selectProductBuyLevelID(parentid);
		return ls;
	}
}