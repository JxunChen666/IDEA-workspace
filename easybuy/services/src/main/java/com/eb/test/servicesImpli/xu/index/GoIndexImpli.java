package com.eb.test.servicesImpli.xu.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.MapperDao.EasybuyProductCategoryMapper;
import com.eb.test.model.EasybuyProductCategory;
import com.eb.test.servicesDao.xu.indexDao.GoIndexDao;

@Service
public class GoIndexImpli implements GoIndexDao {
	
	@Autowired
	EasybuyProductCategoryMapper easybuyProductCategory;
	
	//查询一级二级 三级菜单
	@Override
	public List<EasybuyProductCategory> selectProductCategory() {
		List<EasybuyProductCategory> epc=easybuyProductCategory.selectAll();
		
		return  epc;
	}

}