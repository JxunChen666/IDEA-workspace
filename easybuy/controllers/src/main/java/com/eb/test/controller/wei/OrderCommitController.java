package com.eb.test.controller.wei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.eb.test.controller.wei.alipay.AliBean;
import com.eb.test.controller.wei.alipay.PayService;
import com.eb.test.model.EasybuyBuycar;
import com.eb.test.model.EasybuyOrder;
import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.wei.ServiceDaoWei;

/**
 * 
 * @author weizhen 12/9
 *
 */
@Controller
public class OrderCommitController {//订单页面
	
	@Autowired
	private ServiceDaoWei ser;
	
	@RequestMapping("buycar")
	public String buycar(Model mod,HttpSession session) {
		//Integer id = 15;//模拟id为15
		EasybuyUser ebu = (EasybuyUser) session.getAttribute("ebu");//获取session 的值
		Integer id = ebu.getId();
		List<EasybuyBuycar> lcar = ser.getUserBuycar(id,null);//第二参数为商品id
		
		if(lcar.size()>0) {//用户购物车有商品
			List<EasybuyProduct> ls = new ArrayList<EasybuyProduct>();
			EasybuyProduct ebb = null;
			
			for(EasybuyBuycar eb:lcar) {
				ebb=getGoods(eb.getGoods());//循环购物车表获得每条的商品详细信息；
				ls.add(ebb);
			}
			mod.addAttribute("buycar",lcar);
			mod.addAttribute("goods",ls);
			mod.addAttribute("buycarmoney",ser.getBuycarMoney(id));//总价：int
			}else {//用户购物车没有商品
			System.out.println("没有商品");
		}
		return "BuyCarPackage/BuyCar";
		
	}
	//根据商品id查商品
	public EasybuyProduct getGoods(Integer id) {
		List<EasybuyProduct> ls = ser.getEasybuyProduct(id);
		if(ls.size()>0) {
			return ls.get(0);
		}
		return null;
	}
	
	@RequestMapping("buycar2")//确认订单
	public String buy(Model mod,HttpSession session) {
		//Integer id = 15;//模拟id为15
		EasybuyUser ebu = (EasybuyUser) session.getAttribute("ebu");//获取session 的值
		Integer id = ebu.getId();
		List<EasybuyBuycar> lcar = ser.getUserBuycar(id,null);//第二参数为商品id
		
		if(lcar.size()>0) {//用户购物车有商品
			List<EasybuyProduct> ls = new ArrayList<EasybuyProduct>();
			EasybuyProduct ebb = null;
			
			for(EasybuyBuycar eb:lcar) {
				ebb=getGoods(eb.getGoods());//循环购物车表获得每条的商品详细信息；
				ls.add(ebb);
			}
			
			mod.addAttribute("buycar",lcar);
			mod.addAttribute("goods",ls);
			mod.addAttribute("buycarmoney",ser.getBuycarMoney(id));//总价：int
			}else {//用户购物车没有商品
			
		}
		return "BuyCarPackage/BuyCar_Two";
	}
	
	//订单页面点击+-改变购物车数量
	@ResponseBody
	@RequestMapping("updatebuycar")
	public String updateBuycar(Model mod,EasybuyBuycar ebb) {
		//购物车信息
		System.out.println("weizhen查找用户的购物车");
		boolean flag = false;
			System.out.println(ebb.getId()+"\\"+ebb.getUsers()+"\\"+ebb.getGoods()+"\\"+ebb.getCoun());
			flag = ser.buyCarUpdate(ebb);
			if(flag) {
				System.out.println("修改购物车数量成功");
				return "{\"flag\":\"true\"}";
			}else {
				System.out.println("修改购物车数量失败");
				return "{\"flag\":\"false\"}";
			}
	}
	//删除购物车
		@ResponseBody
		@RequestMapping("deletebuycar")
		public String delBuycar(Model mod,@RequestParam(value="id")String id) {
			//购物车信息
			System.out.println("weizhen删除购物车");
			System.out.println("购物车表id为"+id);
			boolean flag = ser.buyCarDelete(Integer.parseInt(id));
				//flag = ser.buyCarUpdate();
				if(flag) {
					System.out.println("删除购物车数量成功");
					return "{\"flag\":\"true\"}";
				}else {
					System.out.println("删除购物车数量失败");
					return "{\"flag\":\"false\"}";
				}
		}
		
		
		@Resource
		private PayService payService;//调用支付服务
		
		public EasybuyOrder eo;//全局变量 共享资源到alipay的controller中进行新增
		public String kuaidiname;//快递名称
		@ResponseBody
		@RequestMapping("buycar3")//走到支付宝
		public String commit(Model mod,@RequestParam(value="tjuid",required=false)String uid,
				@RequestParam(value="tjuname",required=false)String uname,
				@RequestParam(value="tjad",required=false)String ad,
				@RequestParam(value="tjprice",required=false)String price,
				@RequestParam(value="tjkdname",required=false)String kdname) throws AlipayApiException, ParseException {
			//把字段写到这里 到支付宝跳转到controller.即支付成功 的时候在取出
			//System.out.println(money+"--"+address);
			System.out.println("00000000000"+uid+uname+ad+price+kdname);
			kuaidiname = kdname;//快递名称赋值
			eo = new EasybuyOrder();
			//登录名id
			eo.setUserid(Integer.parseInt(uid));
			eo.setLoginname(uname);
			//地址
			eo.setUseraddress(ad);
			//当前时间
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(date);
			date = sdf.parse(time);
			eo.setCreatetime(date);
			//价格
			eo.setCost(Float.parseFloat(price));
			//System.out.println("***********"+total_amount);
			eo.setStatus(2);//状态类型
			eo.setType(1);
			eo.setSerialnumber(this.random());
			System.out.println(eo.getSerialnumber());
			AliBean ab = new AliBean();
			//ab.setBody(body);//商品描述 可空
			ab.setOut_trade_no(eo.getSerialnumber());//商户订单号
			ab.setTotal_amount(new StringBuffer().append(eo.getCost()));//付款金额 SringBuffer
			ab.setSubject("商品支付");//订单名称 必填

			return payService.aliPay(ab);
		}
		
		//支付成功 订单新增 购物车删除
		@RequestMapping("paysuccess")
		public String paysccuess(Model mod) {
			System.out.println("paysuccess");
			System.out.println(kuaidiname);
			System.out.println(eo.getUserid()+"-"+eo.getLoginname()+"-"+eo.getUseraddress()+"-"+eo.getSerialnumber()+"-"+eo.getCost()+"-"+eo.getCreatetime()+kuaidiname);
			//订单对象的值
			//新增订单 清空购物车
			if(ser.OrderInsert(eo)) {
				System.out.println("新增订单成功");
				//成功后删除购物车
				if(ser.BuycarDeleteByUsers(eo.getUserid())) {
					System.out.println("清空购物车成功");
				}else {

					System.out.println("清空购物车失败");
				}
				
				mod.addAttribute("ordernum",eo.getSerialnumber());//订单号
				mod.addAttribute("kd",kuaidiname);//快递
				mod.addAttribute("price",eo.getCost());//价格
			}else {
				System.out.println("新增订单失败");
			}
			return "BuyCarPackage/BuyCar_Three";
		}
		
		//生成不重复随机数
		public String random() {
			int a = (int)(Math.random()*10);
			int b = (int)(Math.random()*10);
			int c = (int)(Math.random()*10);
			int d = (int)(Math.random()*10);
			int e = (int)(Math.random()*10);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMddHHmssSS");
			String time = sdf.format(new Date());
			
			System.out.println(a+""+b+""+c+""+d+""+e+""+time);
	        String num = a+""+b+""+c+""+d+""+e+""+time;
	        //当前时分秒毫秒加上uid加三位随机数
			return num;
		}
}
