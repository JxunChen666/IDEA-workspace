package com.eb.test.servicesImpli.xu.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.MapperDao.EasybuyProductCategoryMapper;
import com.eb.test.MapperDao.EasybuyProductMapper;
import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyProductCategory;
import com.eb.test.servicesDao.xu.indexDao.IndexbelowDao;

@Service
public class Indexbelowimpli  implements IndexbelowDao{
	@Autowired
	EasybuyProductMapper easybuyProductMapper;
	
	@Autowired
	EasybuyProductCategoryMapper easybuyProductCategoryMapper;
	
	//查询一级菜单
	@Override
	public List<EasybuyProductCategory> selectl1() {
		List<EasybuyProductCategory>  pcl1=easybuyProductCategoryMapper.selectl1();
		return  pcl1;
	}
	
	
	//查询所有商品
	@Override
	public List<EasybuyProduct> selectAllProduct() {
		List<EasybuyProduct> product=easybuyProductMapper.selectAll();
		return product;
	}
	
}
