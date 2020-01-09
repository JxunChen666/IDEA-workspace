package com.eb.test.controller.qiang;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.qiang.IRegistService;

@Controller
public class RegistController {
	
	@Autowired
	private IRegistService irs;
	
	@RequestMapping(value="/Registhtml.html")
	public String Registhtml() {
		return "Regist.html";
	}
	
	@RequestMapping(value="/Immediateregistration.html")
	public String Immediateregistration(
		EasybuyUser easybuyuser,
		HttpServletRequest request,
		HttpServletResponse response,
		String textyanzhengma) throws IOException {
		
		//转换大写
		//String yanzm = textyanzhengma.toUpperCase();
		
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		
		
		//默认注册普通账户
		easybuyuser.setType(0);
		boolean isok = irs.insertSelective(easybuyuser);
		if(isok==true) {
			return "redirect:/userlogin";
		}else {
			return "Regist.html";
		}
	}
	
	@ResponseBody
	@RequestMapping("yanzmc")
	public Map<String, Object> yanzmc(
			String yzm,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String code = (String)session.getAttribute("code");
		
		boolean isok = false;
		
		if(yzm.equals(code) == true){
			isok=false;
		}else {
			isok=true;
		}
		map.put("isok", isok);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("userNameIsNot")
	public Map<String, Object> userNameIsNot(
			String loginname) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//查找输入的用户名是否存在，存在为true，反之为false
		boolean isnot = irs.SelectloginName(loginname);
		
		map.put("isnot", isnot);
		return map;
	}
	
	
	
	/**
     * 局部刷新，注意返回值
     * @param model
     * @return
     */
    /*@RequestMapping("/local")
    public String localRefresh(
    		String loginname,
    		Model model) {
    	
    	boolean isnot = irs.SelectloginName(loginname);
    	
    	if(isnot){
    		List<Map<String,String>> lists = new ArrayList<>();
            Map<String,String> map = new HashMap<>();
            map.put("yonghum", "用户名重复！");
            lists.add(map);
            model.addAttribute("books", lists);
            // "test"是test.html的名，
            // "table_refresh"是test.html中需要刷新的部分标志,
            // 在标签里加入：th:fragment="table_refresh"
            
		}
    	
    	return "/Regist::table_refresh";
    }*/
}
