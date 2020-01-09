package com.eb.test.servicesDao.xu.indexDao;

import java.util.List;

import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyProductCategory;

public interface IndexbelowDao {
	//查询一级菜单
	public List<EasybuyProductCategory> selectl1();
	
	//查询所有商品
	public List<EasybuyProduct> selectAllProduct();
	
}
