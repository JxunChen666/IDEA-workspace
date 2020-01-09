package com.eb.test.controller.cheng;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eb.test.model.EasybuyOrder;
import com.eb.test.servicesDao.cheng.Member_OrderDao;

/**
 *
 * @author ChenYan
 *   订单Controller
 */


@Controller
public class Member_OrderController {
    
	@Autowired(required=false)
	private Member_OrderDao myOrder;
	
	
	/*
	 * 查询订单
	 */
	@RequestMapping(value = "MyOrder")
	public String myOrder(@RequestParam Integer userid,
			              Model model) {
	
		List<EasybuyOrder> Order=myOrder.selectMyOrder(userid);
		
		model.addAttribute("Order",Order);
		
		return "Order/Member_Order";
	}
	
	
	 /*
	  * 取消订单
	  */
	 @PostMapping(value = "/upOrderStatus")
	 private String updateMyOrderStatus(@RequestParam Integer orderId,
						                @RequestParam Integer status,
						                @RequestParam Integer userId,Model model) {

		 //调用业务删除方法 返回布尔类型
		 EasybuyOrder eo=new EasybuyOrder();
		 eo.setId(orderId);
		 eo.setStatus(status);		 
		 boolean notUp=myOrder.updateOrderStatus(eo);
		 
		 //调用业务查询方法 返回一个集合  实现ajax局部刷新订单
		 List<EasybuyOrder> list=myOrder.selectMyOrder(userId);		
		 model.addAttribute("Order", list);	
		 
		return "Order/Member_Order::myOrder";
	         
	}
	
	 
	/*
	 * 删除订单
	 */
	 
	@PostMapping(value = "/delMyOrder")
	 private String delMyOrder(@RequestParam Integer orderId, 
			                   @RequestParam Integer userId,Model model) {
		 //Map<String, Object> result = new HashMap<String, Object>();
		
		 //调用业务删除方法 返回布尔类型
		 boolean notDel=myOrder.delOrder(orderId);
		 
		 //调用业务查询方法 返回一个集合  实现ajax局部刷新订单
		 List<EasybuyOrder> list=myOrder.selectMyOrder(userId);		
		 model.addAttribute("Order", list);	
		 
		return "Order/Member_Order::myOrder";

	         
	}
	 
	
	@RequestMapping("Webmsg")
	public String modal() {
		return "Customer/webchat";
	}
}
