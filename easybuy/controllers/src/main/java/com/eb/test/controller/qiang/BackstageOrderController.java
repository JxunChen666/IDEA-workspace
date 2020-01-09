package com.eb.test.controller.qiang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eb.test.model.EasybuyOrder;
import com.eb.test.servicesDao.qiang.IBackstageOrderService;

@Controller
public class BackstageOrderController {
	
	/*订单后台*/
	
	@Autowired
	private IBackstageOrderService ibos;
	
	@RequestMapping(value = "/selectAllOrder")
	public String selectAllOrder(
			Model model) {
		List<EasybuyOrder> Order=ibos.selectAllOrder();
		
		model.addAttribute("Order",Order);
		
		return "Backstage/Member_Backstage_order";
	}
	
	@RequestMapping(value = "/dingdanqueren")
	public String dingdanqueren(
			Integer id,
			Integer rowdq) {
		System.out.println(id);
		System.out.println(rowdq);
		
		boolean flag = ibos.updateOrderdq(id, rowdq);
		if(flag == true) {
			System.out.println("修改成功");
		}
		return "redirect:/selectAllOrder";
	}
}
