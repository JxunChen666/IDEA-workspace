package com.eb.test.controller.xu.buycar;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eb.test.controller.xu.index.GoIndexCon;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.wei.ServiceDaoWei;
import com.eb.test.servicesDao.xu.BuyCarDao.MyCarDao;
import com.eb.test.utilmodel.UserBuyCar;

@Controller
public class BuyCarCon {
		@Autowired
		private MyCarDao myCarDao;
		
		@Autowired
		ServiceDaoWei serviceDaoWei;
		
		private static final Logger logger = LoggerFactory.getLogger( GoIndexCon.class);
		
		@RequestMapping("/selectMycar")
		public String getMycar(Model model,HttpSession  session) {
			EasybuyUser myuser= (EasybuyUser)session.getAttribute("ebu");
			
			if( myuser!=null) {
			 Integer userid=myuser.getId();
			//获取购物车
			List<UserBuyCar> mycar=myCarDao.slectMyCar(userid);
			
			for(UserBuyCar c:mycar) {
				logger.info("mycar异步  "+c.toString());
			}
			
			
			//获取总金额
			Integer Countprice=serviceDaoWei.getBuycarMoney(userid);
			model.addAttribute("Countprice",Countprice);
			
			model.addAttribute("mycar",mycar);
			logger.info("userid  "+userid);
			
			}
			
		
			//	return "/com/MyModel::thbuycar";
			return "BuyCarPackage/Product::thbuycar";
		}
}
