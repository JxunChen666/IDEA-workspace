package com.eb.test.controller.xu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eb.test.model.TestMd;

import com.eb.test.servicesDao.TestServices;

public class TestXu {
	@Autowired
	TestServices servicesMain;
	
	
	@RequestMapping("/aaa")
	public String requestMethodName(Model model) {
		System.out.println("aaaaa");
		TestMd user=servicesMain.Hellow();
		model.addAttribute("user",user);
		return "index";
	}
}
