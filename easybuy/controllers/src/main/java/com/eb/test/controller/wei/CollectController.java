package com.eb.test.controller.wei;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eb.test.MapperDao.EasybuyOrderMapper;
import com.eb.test.model.EasybuyBuycar;
import com.eb.test.model.EasybuyCollect;
import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.wei.ServiceDaoWei;

/**
 * 
 * @author wz 19 12 16
 *
 */
@Controller
public class CollectController {
	
	
	@Autowired
	private ServiceDaoWei ser;

	//我的收藏
	@RequestMapping("membercollect")
	public String mycollect(Model mod,HttpSession session) {
		EasybuyUser ebu = (EasybuyUser) session.getAttribute("ebu");
		Integer uid = ebu.getId();
		List<EasybuyCollect> lc = ser.selectCollect(uid, null);//我的收藏有商品
		
		
		List<EasybuyProduct> ls = new ArrayList<EasybuyProduct>();
		EasybuyProduct ebb = null;
		for(EasybuyCollect eb:lc) {
			ebb=getGoods(eb.getProductid());//循环购物车表获得每条的商品详细信息；
			ls.add(ebb);
		}
		mod.addAttribute("lc",lc);//收藏
		mod.addAttribute("ls",ls);//商品
		System.out.println(ls.size());
		mod.addAttribute("count",lc.size());
		return "BuyCarPackage/Member_Collect.html";
	}
	//根据商品id查商品
	public EasybuyProduct getGoods(Integer id) {
		List<EasybuyProduct> ls = ser.getEasybuyProduct(id);
		if(ls.size()>0) {
			return ls.get(0);
		}
		return null;
	}
	
	//点击关注
	@ResponseBody
	@RequestMapping("collectinsert")
	public String  collectadd(Model mod,EasybuyCollect ec) {
		System.out.println(ec.getId());
		if(ser.collectAdd(ec)) {
			System.out.println("收藏商品成功");
			return"{\"info\":\"true\"}";
		}else {
			System.out.println("收藏商品失败");
			return"{\"info\":\"false\"}";
		}
	}
	
	//取消关注
	@ResponseBody
	@RequestMapping("collectdelete")
	public String  collectadd(Model mod,@RequestParam(value="id")String id) {
		Integer cid = Integer.parseInt(id);
		if(ser.deleteCollect(cid)) {
			System.out.println("取消收藏商品成功");
			return"{\"info\":\"true\"}";
		}else {
			System.out.println("取消收藏商品失败");
			return"{\"info\":\"false\"}";
		}
	}
	
	//删除关注 根据uid 和pid
	@ResponseBody
	@RequestMapping("deletecollect")
	public String  delcollect(Model mod,@RequestParam(value="id")String id,@RequestParam(value="pid")String pid) {
		//Integer cid = Integer.parseInt(id);
		Integer uid = Integer.parseInt(id);
		Integer prid = Integer.parseInt(pid);
		System.out.println(id+"--"+pid);
		if(ser.deleteCollectbyupid(uid, prid)) {
			System.out.println("删除收藏成功");
			return"{\"info\":\"true\"}";
		}else {
			System.out.println("删除收藏失败");
			return"{\"info\":\"false\"}";
		}
	}
}
