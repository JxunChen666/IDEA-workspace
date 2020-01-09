package com.eb.test.servicesDao.xu.productDao;

import java.util.List;

import com.eb.test.model.EasybuyProduct;

public interface ServiceProductDao {
	
	//xu 根据菜单查询对应级别商品
	List<EasybuyProduct> selectProductBuyLevel(Integer la,Integer lb,Integer lc);
}
