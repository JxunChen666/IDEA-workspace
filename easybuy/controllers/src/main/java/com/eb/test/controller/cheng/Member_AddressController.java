package com.eb.test.controller.cheng;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.eb.test.model.EasybuyAddress;
import com.eb.test.model.Params;
import com.eb.test.servicesImpli.cheng.Member_AddressDaoImpl;
import com.github.pagehelper.PageInfo;



/**
 * 
 * @author ChenYan
 * 收货地址Controller
 */



@Controller
public class Member_AddressController {
    
	@Autowired
	private Member_AddressDaoImpl madi;
	
	/*
	 * 当前用户所有收货地址
	 */
	@RequestMapping("ShippingAddress")
	public String Member_Address(Params params,@RequestParam Integer userid,Model model) {
		Map<String, Object> map=new HashMap<String, Object>();
		PageInfo<EasybuyAddress> pageInfo=madi.finds(params, userid);
		List<EasybuyAddress> ebaddress=pageInfo.getList();	
		
		model.addAttribute("ebaddress",ebaddress);
		model.addAttribute("userid",userid);		
		model.addAttribute("pageInfo", pageInfo);
	    
		
	     return "ShippingAddress/Member_Address";
	}
	
	
	 //增删改通用局部刷新
	@RequestMapping("generalRefreshAddress")
	public String modalAddressAll(Params params,@RequestParam Integer userid,Model model) {
		
		//查询所有
		PageInfo<EasybuyAddress> pageinfo=madi.finds(params, userid);
		List<EasybuyAddress> ebaddress=pageinfo.getList();	
		model.addAttribute("ebaddress",ebaddress);
		
        return "ShippingAddress/Member_Address::address";
	}

	
	
	
	/*
	 * 设置当前用户默认收货地址
	 */
	@ResponseBody
	@PostMapping("defaultAddress")
	public Map<String, Object> setDefault(@RequestParam Integer userid,
			                 @RequestParam Integer id,
			                 @RequestParam(value="da",required=false,defaultValue="0") Integer da,Model model) {
		Map<String, Object> map=new HashMap<String, Object>();
		//把前台数据存入对象
		EasybuyAddress ea=new EasybuyAddress();
		ea.setUserid(userid);
		ea.setId(id);
		ea.setIsdefault(da);
		//全部设置为0 
		madi.updateisDefault_0(ea);
		
		//设置为1  默认地址		
		boolean isUpDe=madi.updateisDefault(ea);
				
        map.put("isUpDe", isUpDe);
		
        return map;
	}
	
	
	
	
	
	//修改加载Modal
	@RequestMapping("upAddress")
	public String modalAddressOne(@RequestParam Integer id,Model model) {
		
		//局部刷新
		EasybuyAddress oneaddress=madi.selectByIdAddress(id);
		model.addAttribute("oneaddress",oneaddress);
		
        return "Modal/modal::upaddress";
	}
	
	//新增加载Modal
	 @RequestMapping("insertAddress")
	 public String addModalRess(@RequestParam Integer userid,Model model) {
		
		//局部刷新
	    model.addAttribute("userid",userid);
		 
	    return "Modal/modal::addAddress";
    }
	  
		
		
	//修改收货地址信息
	@ResponseBody
	@RequestMapping("updateAddress")
	private Map<String, Object> updateAddress(EasybuyAddress eba) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		boolean isUp=madi.updateByIdAddress(eba);
		map.put("isUp", isUp);
		
        return map;
	}
	
	/*
	 * 删除用户指定地址
	 */
	@ResponseBody
	@PostMapping("delAddress")
	public Map<String, Object> delMyAddress(@RequestParam Integer id,Model model) {
		 Map<String, Object> map=new HashMap<String, Object>();
		 boolean isDel=madi.delAddress(id);		 
		 map.put("isDel", isDel);	
		 
        return map;
	}
	
	//新增地址
	@ResponseBody
	@RequestMapping("addMyAddress")
	public Map<String, Object> addMyAddress(EasybuyAddress eba){
		Map<String, Object> map=new HashMap<String, Object>();
		boolean isAdd=madi.insertAddress(eba);
		map.put("isAdd", isAdd);
		
		return map;
	}

}
