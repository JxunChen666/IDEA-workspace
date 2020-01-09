package com.eb.test.controller.xu.Icon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.FileOutputStream;  
import java.text.SimpleDateFormat;  
import java.util.Base64;  
import java.util.Base64.Decoder;  
import java.util.Date;  
  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.bind.annotation.ResponseBody;

import com.eb.test.model.EasybuyUser;
import com.eb.test.servicesDao.xu.IconDao.UserIconServcieDao;
import com.eb.test.utilmodel.UserIcon;
@Controller
public class IconController {
	
	@Autowired
	UserIconServcieDao uis;
	
	
	
	
	@RequestMapping("/goIcon")
	public String goIcon(HttpServletRequest request) {
		 HttpSession session=request.getSession();
		 EasybuyUser ebu=(EasybuyUser)session.getAttribute("ebu");
       
		 //用户头像处理
		 Integer uid=ebu.getId();
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
     
		return "MyIcon/UserIcon";
	}
	
	
	
	
    /**  
     * 注释的代码可以忽略  
     * @throws  
     */  
    @RequestMapping(value="/demo/upload.do",method = RequestMethod.POST)  
    @ResponseBody  
    public String cropper(@RequestParam("file") String file,  
            HttpServletRequest request) throws Exception {  
          
    	   Decoder decoder = Base64.getDecoder();  
           // 去掉base64编码的头部 如："data:image/jpeg;base64," 如果不去，转换的图片不可以查看  
           file = file.substring(23);  
                   //解码  
           byte[] imgByte = decoder.decode(file);  
     
           
           
           
           File path=new File(ResourceUtils.getURL("classpath:").getPath());
           if(!path.exists()){
           path=new File("");
           }
           //如果上传目录为/static/images/upload/,则可以如下获取
           String filename=getFileName();
           File upload=new File(path.getAbsolutePath(),"static/myimg/"+filename);
           
        
   
       
           upload.getParentFile().mkdirs();
                           
             
           
           

           
           try {  
        	   
        	   //判断旧头像是否是默认头像，如果不是则删除头像
               //获取用用户信息
               
               HttpSession session=request.getSession();
               EasybuyUser ebu=(EasybuyUser)session.getAttribute("ebu");
            
               
              
               
               //头像检查
               Integer uid=ebu.getId();
               UserIcon uicold=uis.selectUicByUid(uid);
               if(uicold!=null) {
            	   System.out.println("uicold"+uicold.toString());
            	   String oldfileName=uicold.getFileName();
            	   System.out.println(oldfileName);
            	//   System.out.println("bbbbbb");
            	   if(oldfileName!="default.jpg") {
            		   
            		   	//不是系统默认头像，执行删除
            		   File imgold= new File(path.getAbsolutePath(),"static/myimg/"+oldfileName);
         			 
	         		   if(imgold.exists()) {
		         			  
	         			   		imgold.delete();
		         		//	   	System.out.println("cccccc");
		         			   	System.out.println("旧头像删除成功！删除图片名称为"+oldfileName);
	         			   	
	            		   }
	            	   }
              	
               }
               
        	   
        	   
        	   
		               FileOutputStream out = new FileOutputStream(upload); // 输出文件路径  
		               out.write(imgByte);  
		               out.close();  
		               
		               System.out.println("图片上传成功");
		               
               
		               
		       
		        
		               
		               
		        
		               
		               //将对应信息保存到数据库
		               
		               //将新头像信息保存到session中
		               UserIcon uic=new UserIcon();
		               uic.setFileName(filename);
		               uic.setUid(uid);
		               
		               Integer i=uis.InsertOrUpd(uic);
		               
		               if(i>0) {
		            	   System.out.println("成功保存头像");
		               }
               
               
	
               
           } catch (Exception e) {  
               e.printStackTrace();  
           }  
             
           return "success";  
     
           /*String url = request.getScheme() + "://" + request.getServerName()  
                   + ":" + request.getServerPort() + "/picture/" + fileName;  
           return url; */  
            
          
    
          
 
  
        /*String url = request.getScheme() + "://" + request.getServerName()  
                + ":" + request.getServerPort() + "/picture/" + fileName;  
        return url; */  
    }  
  
    /**  
     * 创建文件名称 内容：时间戳+随机数  
     *   
     * @param @return  
     * @throws  
     */  
    private String getFileName() {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");  
        String timeStr = sdf.format(new Date());  
        String str = RandomStringUtils.random(5,  
                "abcdefghijklmnopqrstuvwxyz1234567890");  
        String name = timeStr + str + ".jpg";  
        return name;  
    }  
  
}
