package com.eb.test.controller.cheng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eb.test.model.EasybuyOrder;
import com.eb.test.servicesDao.cheng.Member_OrderDao;

/**
 * 
 * @author ChenYan
 * 处理Order订单JSON数据
 */


@Controller
public class Member_OrderRestController {
     
	@Autowired(required=false)
	private Member_OrderDao myOrder;
	
	
	
	 



	
	 
}
