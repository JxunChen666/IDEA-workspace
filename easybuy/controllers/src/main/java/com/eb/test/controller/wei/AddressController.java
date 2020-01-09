package com.eb.test.controller.wei;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.eb.test.model.EasybuyAddress;
import com.eb.test.servicesDao.wei.ServiceDaoWei;

//收货地址
@Controller
public class AddressController {
	

	@Autowired
	private ServiceDaoWei ser;
		//用户地址select绑定
		@ResponseBody
		@RequestMapping("addresslist")
		public String addressList(Model mod,@RequestParam(value="id")Integer id) {
			//根据id查address
			List<EasybuyAddress> laddress = ser.selectUserDefaultAddressbyId(id);
			if(laddress.size()>0) {//有默认地址
				System.out.println("有默认地址");
				 String jsonString = JSON.toJSONString(laddress.get(0));
				 System.out.println(jsonString);
				 return jsonString;
			}else {//没默认地址
				System.out.println("没有默认地址");
				return"{\"info\":\"没有默认地址 请先去新增地址\"}";
			}
		}
}
