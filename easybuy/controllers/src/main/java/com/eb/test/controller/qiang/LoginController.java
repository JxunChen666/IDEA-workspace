package com.eb.test.controller.qiang;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.qiang.ILoginService;

@Controller
public class LoginController {
	
	@Autowired
	private ILoginService ils;
	
	@RequestMapping(value="/Loginhtml.html")
	public String Loginhtml() {
		return "login.html";
	}
	
	@RequestMapping(value="/loginSelect.html")
	public String loginController(
			String loginName,
			String password,
			HttpServletRequest request,
			HttpSession session) {
		
		boolean isnot = ils.SelectloginName(loginName);
		if(isnot == true) {
			request.setAttribute("namenot", "");
			EasybuyUser ebu = ils.loginSelect(loginName, password);
			
			if(ebu != null) {
				request.setAttribute("error", "");
				session.setAttribute("ebu", ebu);
				System.out.println("ebu"+ebu.toString());
				return "redirect:/index";
			}else {
				request.setAttribute("error", "密码错误！");
				return "/login.html";
			}
		}else {
			request.setAttribute("namenot", "用户名不存在！");
			return "login.html";
		}
	}
	
	@RequestMapping(value="/EasybuyUserServlet.html")
	public void EasybuyUserServlet(
			String name,
			HttpServletResponse response) throws IOException {
		boolean isnot = ils.SelectloginName(name);
		PrintWriter out = response.getWriter();
		
		if(isnot==true){
			out.println(1);
		}else {
			out.println(0);
		}
		
		out.flush();
		out.close();
		
	}
	
	
	
}
