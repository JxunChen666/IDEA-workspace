package com.eb.test.controller.xu.index;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.xu.BuyCarDao.MyCarDao;
import com.eb.test.servicesDao.xu.indexDao.IndexPageListDao;
import com.eb.test.utilmodel.UserBuyCar;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class IndexPageListCon {
	@Autowired
	IndexPageListDao indexPageListDao;

	
	
	 private static final Logger logger = LoggerFactory.getLogger( GoIndexCon.class);
	
	@RequestMapping("/selectPageProduct")
	public String PageProduct(Model model,@RequestParam(defaultValue="1",value="pageNum") Integer pageNum) {
		PageHelper.startPage(pageNum,4);
		List<EasybuyProduct> products=indexPageListDao.pageProduct();
		PageInfo pagepds=new PageInfo(products);
		for(EasybuyProduct p:(List<EasybuyProduct>)pagepds.getList()) {
			logger.info("page "+p.toString());
		}
		
		model.addAttribute("pagepds",pagepds);
		


		
		
		logger.info("pageNum=    "+pageNum);
		return "IndexPackage/Index::indexul";
	}
	
	
	
}
