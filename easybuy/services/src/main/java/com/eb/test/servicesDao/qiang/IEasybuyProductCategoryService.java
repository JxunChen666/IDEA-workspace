package com.eb.test.servicesDao.qiang;

import java.util.List;

import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyProductCategory;

import io.lettuce.core.dynamic.annotation.Param;

public interface IEasybuyProductCategoryService {
	
	List<EasybuyProductCategory> selectProductBuyLevelPID( Integer parentid);
	
	List<EasybuyProductCategory> selectProductBuyLevel(Integer type);
	
	List<EasybuyProductCategory> selectXiaLaKuang(int typeval);
}
