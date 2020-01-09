package com.eb.test.controller.xu.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eb.test.controller.xu.index.GoIndexCon;
import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyProductCategory;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.wei.ServiceDaoWei;
import com.eb.test.servicesDao.xu.BuyCarDao.MyCarDao;
import com.eb.test.servicesDao.xu.indexDao.GoIndexDao;
import com.eb.test.servicesDao.xu.indexDao.IndexbelowDao;
import com.eb.test.servicesDao.xu.productDao.ServiceProductDao;
import com.eb.test.utilmodel.UserBuyCar;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConGoProductList {
	@Autowired
	ServiceProductDao serviceProductDao;
	
	@Autowired
	GoIndexDao goIndexDao;
	
	
	@Autowired
	ServiceDaoWei serviceDaoWei;
	
	

	@Autowired
	IndexbelowDao indexbelowDao;
	
	
	@Autowired
	private MyCarDao myCarDao;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger( GoIndexCon.class);
	
	@RequestMapping("/seletPdByLevel")
	public String  selectProductByLevel(HttpSession session, Model model, @RequestParam(value="l1",defaultValue="-1")Integer l1, @RequestParam(value="l2",defaultValue="-1")Integer l2, @RequestParam(value="l3",defaultValue="-1")Integer l3 ) {
		logger.info(l1+"  "+l2+" "+l3);
		
		List<EasybuyProduct> products=serviceProductDao.selectProductBuyLevel(l1, l2, l3);
		model.addAttribute("products",products); 
		for(EasybuyProduct p:products) {
			logger.info(" 所查商品 ： "+p.toString());
	
		}
		
		 List<EasybuyProductCategory> list1=indexbelowDao.selectl1();
		 model.addAttribute("l1",list1);
		
		
		 //获取三级菜单
		 List<EasybuyProductCategory> epc=goIndexDao.selectProductCategory();

		 for(EasybuyProductCategory e:epc) {
			 logger.info("菜单内容:   "+e.toString());
		 }
		 model.addAttribute("epc", epc);
		 
			//初始化我的购物车
			EasybuyUser myuser= (EasybuyUser)session.getAttribute("ebu");
			
			if( myuser!=null) {
				int mu=myuser.getId();
				logger.info("User===================  "+myuser.toString());
				List<UserBuyCar> mycar=myCarDao.slectMyCar(mu);
				
				for(UserBuyCar c:mycar) {
					logger.info("mycar "+c.toString());
				}
				Integer Countprice=serviceDaoWei.getBuycarMoney(mu);
				model.addAttribute("Countprice",Countprice);
				model.addAttribute("mycar",mycar);
			}
		
		return "Product/ProductList";
	}
}
