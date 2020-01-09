package com.eb.test.controller.xu.index;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyProductCategory;
import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.wei.ServiceDaoWei;
import com.eb.test.servicesDao.xu.BuyCarDao.MyCarDao;
import com.eb.test.servicesDao.xu.IconDao.UserIconServcieDao;
import com.eb.test.servicesDao.xu.indexDao.GoIndexDao;
import com.eb.test.servicesDao.xu.indexDao.IndexPageListDao;
import com.eb.test.servicesDao.xu.indexDao.IndexbelowDao;
import com.eb.test.servicesImpli.xu.MyBuyCar.MyCar;
import com.eb.test.utilmodel.UserBuyCar;
import com.eb.test.utilmodel.UserIcon;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@Controller
public class GoIndexCon {
	@Autowired
	GoIndexDao goIndexDao;
	
	@Autowired
	private MyCarDao myCarDao;
	
	@Autowired
	IndexPageListDao indexPageListDao;
	
	@Autowired
	IndexbelowDao indexbelowDao;
	
	@Autowired
	ServiceDaoWei serviceDaoWei;
	
	
	@Autowired
	UserIconServcieDao uis;
	
	
	 //获取一级菜单
	 List<EasybuyProductCategory> l1=null;
	 
	 
	 //SSLoginsuccess Security 登录成功跳转
	 
	 @RequestMapping("/SSLoginsuccess")
	 public String SSLoginsuccess(HttpServletRequest request) {
		 return "redirect:/showUsername";
	 }

	
		
	 //登陆失败跳转
	 @RequestMapping("/loginfail")

	 public String loginfailure(HttpServletRequest request) {
		 return "Security/loginfailure";
	 }
	 
		
		
		//查看Session User 方法
		@RequestMapping("/showUsername")
	    public String showUsername(HttpServletRequest request) {
	    
			
			//获得session对象
	        HttpSession session = request.getSession();
	        //取出session域中所有属性名
	        Enumeration attributeNames = session.getAttributeNames();
	        while (attributeNames.hasMoreElements()) {
	            System.out.println(attributeNames.nextElement());
	        }
	        //SPRING_SECURITY_CONTEXT
	        Object spring_security_context = session.getAttribute("SPRING_SECURITY_CONTEXT");
	        System.out.println(spring_security_context);
	        SecurityContext securityContext = (SecurityContext) spring_security_context;
	        //获得认证信息
	        Authentication authentication = securityContext.getAuthentication();
	        //获得用户详情
	        Object principal = authentication.getPrincipal();
	        User user = (User) principal;
	        String username = user.getUsername();
	 
	        
	   //     session.setAttribute("username", username);
	 
	        
	        
	        
	        System.out.println("aaaaaaaaaaaaaaaaaa");
	        
	        
	        //截取 拼成的 id|name
	        String[] myname=username.split("\\|");

	        Integer ebuid=Integer.parseInt(myname[0]) ;
	        String ebuname=myname[1];
	        System.out.println("aaaaa"+ebuname+" aaaa"+ebuid);
	        System.out.println("");
	        EasybuyUser ebu=new EasybuyUser();
	    
	        ebu.setId(ebuid);
	        ebu.setUsername(ebuname);
	        ebu.setLoginname(ebuname);
	        
	        
	        
	        session.setAttribute("ebu", ebu);
	        System.out.println("SSEBU"+ebu.toString());
	        
	       
	        //第二种方法
	        //获取上下栈
	       /* SecurityContext context = SecurityContextHolder.getContext();
	        Authentication authentication1 = context.getAuthentication();
	        User user1 = (User) authentication1.getPrincipal();
	        String username1 = user1.getUsername();*/
	      
	        
	        return "redirect:/index";
	    }

	 
	 
	 
	 //跳转到SSlogin
	 @GetMapping("/userlogin")
	 public String goSSLogin() {
		 return "Security/SSLogin";
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	private static final Logger logger = LoggerFactory.getLogger( GoIndexCon.class);
	 
	 
	 //加载主页数据
	 @RequestMapping({"/index", "/"})
	 public String GotoIndex(Model model,HttpSession session) {
		 //获取三级菜单
		 List<EasybuyProductCategory> epc=goIndexDao.selectProductCategory();

		 for(EasybuyProductCategory e:epc) {
			 logger.info("菜单内容:   "+e.toString());
		 }
		 model.addAttribute("epc", epc);
		 
		 //加载随便看看商品列表
		 PageHelper.startPage(1,4);
		 List<EasybuyProduct> products=indexPageListDao.pageProduct();
		 PageInfo pagepds=new PageInfo(products);
		 for(EasybuyProduct p:(List<EasybuyProduct>)pagepds.getList()) {
				logger.info("page "+p.toString());
			}
		model.addAttribute("pagepds",pagepds);
	 
	
		EasybuyUser myuser= (EasybuyUser)session.getAttribute("ebu");
		
		if( myuser!=null) {
		
			
			//初始化我的购物车
			int mu=myuser.getId();
			logger.info("User===================  "+myuser.toString());
			List<UserBuyCar> mycar=myCarDao.slectMyCar(mu);
			
			for(UserBuyCar c:mycar) {
				logger.info("mycar "+c.toString());
			}
			Integer Countprice=serviceDaoWei.getBuycarMoney(mu);
			model.addAttribute("Countprice",Countprice);
			model.addAttribute("mycar",mycar);
	
		
		

			 //用户头像处理
			 Integer uid=myuser.getId();
	         System.out.println("UI  "+uid);
	         UserIcon uic=uis.selectUicByUid(uid);
	         if(uic==null) {
	        	 uic=new UserIcon();
	        	 //设置用户默认头像
	        	 uic.setFileName("default.jpg");
	        	
	         }
	         uic.setUid(uid);
	         
	         System.out.println("uic"+uic.toString());
	         session.setAttribute("uic",  uic);
		}
		

		
		//获取主页下半部分的集合
		
		 
		 //获取对应一级菜单的每组六条商品信息
		 List<EasybuyProduct> productBelow=selectBelowpd();

			for(EasybuyProduct pl:productBelow) {
				logger.info("pbelow "+pl.getCategorylevel1());
			}
			

		 model.addAttribute("productBelow",productBelow);

		 model.addAttribute("l1",l1);
		

		
		
		 return "IndexPackage/Index";
	 }

	 
	 //获取对应一级菜单的每组六条商品信息
	 private List<EasybuyProduct> selectBelowpd(){
		
		 l1=indexbelowDao.selectl1();
		 List<EasybuyProduct> proudct=indexbelowDao.selectAllProduct();
		 List<EasybuyProduct> pdbelow=new ArrayList<EasybuyProduct>();
		 
		 int level1=0;
		
		 //计数器 获取六条

		 //循环一级菜单
		 for(int i=0;i<l1.size();i++) {
			 level1=l1.get(i).getId();
			 //循环对应一级菜单的商品
			 logger.info("");
			 logger.info("");
			 logger.info("l1 "+level1);
			 int count=1;
				 for(EasybuyProduct p:proudct) {
					 //每组只获取六条
					 	if(count==6) {
					 		continue;
					 	}
					 	
						if(p.getCategorylevel1()==level1) {
							logger.info("pppp "+p.getCategorylevel1());
							pdbelow.add(p);
							
							count++;
						
						}
					 }
		
		 }
		 
		 
		
			
				
		 return pdbelow;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}
