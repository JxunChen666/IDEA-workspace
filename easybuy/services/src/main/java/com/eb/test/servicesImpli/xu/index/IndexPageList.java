package com.eb.test.servicesImpli.xu.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.MapperDao.EasybuyProductMapper;
import com.eb.test.model.EasybuyProduct;
import com.eb.test.servicesDao.xu.indexDao.IndexPageListDao;

@Service
public class IndexPageList implements IndexPageListDao {
	
	//用于菜单下的动态栏
	@Autowired
	EasybuyProductMapper easybuyProductMapper;
	
	@Override
	public List<EasybuyProduct> pageProduct() {
		List<EasybuyProduct> products=easybuyProductMapper.selectAll();
		
		return products;
	}
	
}
