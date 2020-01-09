package com.eb.test.controller.qiang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyProductCategory;
import com.eb.test.servicesDao.qiang.IEasybuyProductCategoryService;
import com.eb.test.servicesDao.qiang.IEasybuyProductService;
import com.eb.test.servicesDao.xu.productDao.ServiceProductDao;
import com.eb.test.servicesImpli.qiang.EasybuyProductCategoryImpl;

@Controller
public class EasybuyProductController {
	
	@Autowired
	private IEasybuyProductService ieps;
	

	
	@Autowired
	EasybuyProductCategoryImpl ebpi;
	
	@RequestMapping(value="insertProductdq")
	public String insertProductdq(
			EasybuyProduct ep) {
		boolean flag = ieps.insertSelective(ep);
		if(flag == true) {
			System.out.println("新增成功");
		}
		
		return "redirect:/selectAllDqsSP";
	}
	
	//下拉框初始值的service
	@Autowired
	private IEasybuyProductCategoryService iepcs;
	
	@RequestMapping(value="/insertproductdq")
	public String insertproductdq(Model model) {
		
		int flag1=0;
		int flag2=0;
		
		
	//	System.out.println("ccccc");
		
		List<EasybuyProductCategory> la1=ebpi.selectProductBuyLevel(1);
		
		//limbda
		la1.forEach(l->System.out.println("1evel1aaa"+l.toString()));
		
		model.addAttribute("listlname1",la1);
		
		model.addAttribute("flag1",flag1);
		model.addAttribute("flag2",flag2);
		
	//一二三级分类下拉框的值
	//	List<EasybuyProductCategory> listlname1 = iepcs.selectXiaLaKuang(1);
		List<EasybuyProductCategory> listlname2 = iepcs.selectXiaLaKuang(2);
		List<EasybuyProductCategory> listlname3 = iepcs.selectXiaLaKuang(3);
		
	//	model.addAttribute("listlname1",listlname1);
	//	model.addAttribute("listlname2",listlname2);
	//	model.addAttribute("listlname3",listlname3);
		
		return "Backstage/Member_insertProduct";
	}
	
	
	@RequestMapping(value="/changeflag2")
	public String chage1(Model model,@RequestParam("flag1") Integer flag1) {
		System.out.println("flag1="+flag1);
		int flag2=0;
		
		List<EasybuyProductCategory> la1=ebpi.selectProductBuyLevel(1);
		
		//limbda
		la1.forEach(l->System.out.println("1evel1aaa"+l.toString()));
		
		model.addAttribute("listlname1",la1);
		List<EasybuyProductCategory> la2=ebpi.selectProductBuyLevelPID(flag1);
		
		la2.forEach(l2->System.out.println("1evel2aaa"+l2.toString()));
		System.out.println("aaaa");
		
		model.addAttribute("listlname2",la2);
		model.addAttribute("flag1",flag1);
		model.addAttribute("flag2",flag2);
		
		return "Backstage/Member_insertProduct::trchange2";
	}
	
	
	@RequestMapping(value="/changeflag3")
	public String chage2(Model model,@RequestParam("flag2") Integer flag2) {
		System.out.println("flag2="+flag2);
	
		
		
		List<EasybuyProductCategory> la3=ebpi.selectProductBuyLevelPID(flag2);
		
		
		la3.forEach(l3->System.out.println("1evel3aaa"+l3.toString()));
		model.addAttribute("listlname3",la3);
		model.addAttribute("flag2",flag2);
		
		return "Backstage/Member_insertProduct::trchange3";
	}
}
