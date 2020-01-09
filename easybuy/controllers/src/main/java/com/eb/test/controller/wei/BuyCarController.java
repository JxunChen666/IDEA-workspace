package com.eb.test.controller.wei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.eb.test.model.EasybuyBuycar;
import com.eb.test.model.EasybuyCollect;
import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyProductCategory;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.wei.ServiceDaoWei;
import com.eb.test.servicesDao.xu.BuyCarDao.MyCarDao;
import com.eb.test.servicesDao.xu.indexDao.GoIndexDao;
import com.eb.test.servicesDao.xu.indexDao.IndexbelowDao;
import com.eb.test.utilmodel.UserBuyCar;
import com.eb.test.utilmodel.UserIcon;

/**
 * 
 * @author weizhen 12/06
 *
 */
@Controller
public class BuyCarController {
	
	@Autowired
	GoIndexDao goIndexDao;
	
	
	@Autowired
	IndexbelowDao indexbelowDao;
	
	@Autowired
	private MyCarDao myCarDao;
	
	@Autowired
	private ServiceDaoWei ser;//ServiceDao层
	
	//根据商品id查询商品详细信息
	@RequestMapping("/product")
	//public String goodsDetail(Model mod, @RequestParam(value="goodsId")Integer id) {
	public String goodsDetail(Model mod,HttpSession session,@RequestParam(value="productid")Integer id) {
		
		System.out.println("weizhen根据商品id查询商品详细信息");
		//uid
		EasybuyUser ebu = (EasybuyUser) session.getAttribute("ebu");
		Integer uid = ebu.getId();
		System.out.println("uid============>>>>>>>>"+uid);
		//查询详细信息不需要list
		EasybuyProduct ep =getGoods(id);
		//查询所有类别
		List<EasybuyProductCategory> ls = ser.getGoodsCategory();
		mod.addAttribute("productdetail",ep);
		mod.addAttribute("category",ls);
		
		//查询该用户收藏表是否有该商品 如果有 页面显示已关注 再点取消关注
		List<EasybuyCollect> lc = ser.selectCollect(uid,id);
		if(lc.size()>0) {
			mod.addAttribute("collect",lc.get(0).getId());
		}else {
			mod.addAttribute("collect","-1");
		}
		
		
		 //获取三级菜单
		 List<EasybuyProductCategory> epc=goIndexDao.selectProductCategory();

		 for(EasybuyProductCategory e:epc) {
			System.out.println("菜单内容:   "+e.toString());
		 }
		 mod.addAttribute("epc", epc);
		
		
		
		
		EasybuyUser myuser= (EasybuyUser)session.getAttribute("ebu");
		
		if( myuser!=null) {
		
			 
			
			//初始化我的购物车
			int mu=myuser.getId();
			System.out.println("User===================  "+myuser.toString());
			List<UserBuyCar> mycar=myCarDao.slectMyCar(mu);
			
			for(UserBuyCar c:mycar) {
				System.out.println("mycar "+c.toString());
			}
			Integer Countprice=ser.getBuycarMoney(mu);
			mod.addAttribute("Countprice",Countprice);
			mod.addAttribute("mycar",mycar);
	
		
		


		}
		
		//一级菜单
		 List<EasybuyProductCategory> list1=indexbelowDao.selectl1();
		 mod.addAttribute("l1",list1);

		
		
		
		
		return "BuyCarPackage/Product";//商品详情页
	}
	
	
	//添加到购物车
	@ResponseBody
	@RequestMapping("addbuycar")
	public String addBuycar(Model mod,EasybuyBuycar ebb) {
		//用户id 商品id 数量
		//如果传来的商品id在原列表能检索则不新增消息，将原先的那条更改数量
		//用户id 商品id写死
		//购物车信息
		System.out.println("weizhen查找用户的购物车");
		
		List<EasybuyBuycar> lcar = ser.getUserBuycar(ebb.getUsers(),ebb.getGoods());//第二参数为商品id
		boolean flag = false;
		if(lcar.size()>0) {//本次添加信息的商品存在于该用户购物车中 则不要走新增 走修改
			ebb.setId(lcar.get(0).getId());//设置id
			
			ebb.setCoun(ebb.getCoun()+lcar.get(0).getCoun());//当前的数量值加原先数据库的值
			
			System.out.println(ebb.getId()+"\\"+ebb.getUsers()+"\\"+ebb.getGoods()+"\\"+ebb.getCoun());
			
			flag = ser.buyCarUpdate(ebb);
			
		}else {//新增一条
			flag = ser.buyCarInsert(ebb);
		}
		
		List<EasybuyBuycar> lc = ser.getUserBuycar(ebb.getUsers(),null);//第二参数为商品id
		//再次查询该用户的购物车 将 商品种数 商品总个数 总金额传出
		HashMap<String, Object> mp = new HashMap<String, Object>();
		
		if(flag) {
			mp.put("flag", "true");
		}else {
			mp.put("flag", "false");
		}
		
		mp.put("buycarsize", lc.size());//种数
		mp.put("buycarcount",ser.getBuycarCount(ebb.getUsers()));//总个数
		mp.put("buycarmoney", ser.getBuycarMoney(ebb.getUsers()));//总价

		String jsonString = JSON.toJSONString(mp);
		return jsonString;
	}
	
	//根据id查询单个商品
	public EasybuyProduct getGoods(Integer id) {
		List<EasybuyProduct> ls = ser.getEasybuyProduct(id);
		if(ls.size()>0) {
			return ls.get(0);
		}
		return null;
	}
}
