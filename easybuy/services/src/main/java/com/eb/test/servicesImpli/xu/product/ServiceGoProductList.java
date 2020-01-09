package com.eb.test.servicesImpli.xu.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.MapperDao.EasybuyProductMapper;
import com.eb.test.model.EasybuyProduct;
import com.eb.test.servicesDao.xu.productDao.ServiceProductDao;
@Service
public class ServiceGoProductList  implements ServiceProductDao{
	@Autowired
	EasybuyProductMapper 	easybuyProductMapper;
	
	//	根据级别查询商品
	@Override
	public List<EasybuyProduct> selectProductBuyLevel(Integer l1, Integer l2, Integer l3) {
		// TODO Auto-generated method stub
		List<EasybuyProduct> products=easybuyProductMapper.selectProductBuyLevel(l1, l2, l3);
		
		return  products;
	}

}
