package com.eb.test.controller.qiang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eb.test.dqutilmodel.easybuydqsp;
import com.eb.test.model.EasybuyProductCategory;
import com.eb.test.servicesDao.qiang.IBackstageDqSpService;
import com.eb.test.servicesDao.qiang.IEasybuyProductCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class BackstageController {
	
	@Autowired
	private IBackstageDqSpService ibdss;
	
	@RequestMapping(value="selectAllDqsSP")
	public String MemberBackstage(
			Model model,
			@RequestParam(value = "pageNum",defaultValue ="1") Integer pageNum,
			@RequestParam(value = "pageSize",defaultValue ="5") Integer pageSize) {
		
		PageHelper.startPage(pageNum,pageSize);
		
		List<easybuydqsp> listeds = ibdss.selectAlldqsp();

		PageInfo<easybuydqsp> pageInfo=new PageInfo<>(listeds);
		
		model.addAttribute("listeds",listeds);
		
		model.addAttribute("pageInfo",pageInfo);
		return "Backstage/Member_Backstage";
	}
}
