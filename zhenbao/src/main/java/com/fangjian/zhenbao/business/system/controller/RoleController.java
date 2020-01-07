package com.fangjian.zhenbao.business.system.controller;

import com.fangjian.zhenbao.base.PageBean;
import com.fangjian.zhenbao.base.bind.annotation.CurrentUser;
import com.fangjian.zhenbao.base.bind.annotation.RecordLog;
import com.fangjian.zhenbao.base.utils.AjaxUtils;
import com.fangjian.zhenbao.business.system.entity.*;
import com.fangjian.zhenbao.business.system.service.MenuService;
import com.fangjian.zhenbao.business.system.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChuJing
 *
 * @date 2016年1月8日
 */
@Controller
@RequestMapping("/system/user")
public class RoleController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleService roleService;
	//private static final Logger LOG = LoggerFactory.getLogger(RoleController.class);
	private static Logger logger = LogManager.getLogger(RoleController.class.getName());

	@RecordLog(remark = "角色管理")
	@RequiresPermissions("system:authority:user")
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public String userList(Model model) {
		/** 菜单 */
		List<Menu> menus = menuService.findMenu("/system");
		model.addAttribute("menus", menus);
		/** 基础页面 */
		BasePage basePage = new BasePage("system", "authority", "role", "系统管理","角色管理");
		model.addAttribute("basePage", basePage);

		/** roles模块 */
		/*
		 * Map<String, String> roles = roleService.user_role();
		 * model.addAttribute("roles", roles);
		 */
		return "system/role/roleList";
	}

	@RequestMapping(value = "/findAllRoles.ajax")
	public @ResponseBody Map<String, Object> findAllUsers(PageBean page,
			Role roleObj) {
		// 用来存储返回结果的Map datatables固定格式
		Map<String, Object> resultMap = roleService.getAllRoles(page, roleObj);
		return resultMap;
	}
	/**
	 * 
	 * <p>
	 * @author ChuJing,2016年1月8日
	 * @param model
	 * @param id
	 * @return
	 */
	@RecordLog(remark = "添加角色")
	@RequiresPermissions("system:authority:user")
	@RequestMapping(value = "/addRole", method = RequestMethod.GET)
	public String addUser(Model model,String id){
		List<Resource> resourceList = roleService.getAllResource();
		List<Long> list = new ArrayList<Long>();
		if(StringUtils.isNotEmpty(id)){
			Role roleBean=roleService.getRoleById(Long.parseLong(id));
			model.addAttribute("roleBean", roleBean);
			list = roleBean.getResourceIds();
		}
		for(Resource r : resourceList){
			if(list.contains(r.getId())){
				r.setCheckedFlag("1");//选中标识
			}
		}
		model.addAttribute("resources", resourceList);
		return "system/role/roleLayer";
	}
	/**
	 * 
	 * <p>
	 * @author ChuJing,2016年1月8日
	 * @param roleObj
	 * @return
	 */
	@RecordLog(remark = "保存角色")
	@RequiresPermissions("system:authority:user")
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> saveRole(Role roleObj,@CurrentUser User user){
		Map<String,Object> resultMap=new HashMap<String, Object>();
		String userName = user.getUsername();//用户名
		String name = user.getName();//真实姓名
		try {
			if(roleObj.getId()!=null){
		        roleObj.setUpdateUser(userName+"("+name+")");
				int result = roleService.updateRole(roleObj);
				if (result > 0) {
					resultMap=AjaxUtils.buildSuccessJsonAjaxMsg("更新角色成功！");
				} else {
					resultMap=AjaxUtils.buildFailedJsonAjaxMsg("更新角色失败！");
				}	
			}else{
				Role existRole=roleService.getRoleById(roleObj.getId());
				if(existRole!=null){
					resultMap=AjaxUtils.buildFailedJsonAjaxMsg("角色名称已存在！");
					return resultMap;
				}else{
					roleObj.setCreateUser(userName+"("+name+")");
					roleService.addRole(roleObj);
					resultMap=AjaxUtils.buildSuccessJsonAjaxMsg("添加角色成功！");
					
				}
			}
		} catch (Exception e) {
			resultMap=AjaxUtils.buildFailedJsonAjaxMsg("添加角色失败！");
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return resultMap;
	}
	/**
	 * 
	 * <p>
	 * @author ChuJing,2016年1月8日
	 * @param id
	 * @return
	 */
	@RecordLog(remark = "保存角色")
	@RequiresPermissions("system:authority:user")
	@RequestMapping(value = "/deleteRole.ajax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteRole(String id){
		Map<String,Object> resultMap=new HashMap<String, Object>();
		try {
			if(StringUtils.isNotEmpty(id)){
				roleService.deleteRole(Long.parseLong(id));
				resultMap=AjaxUtils.buildSuccessJsonAjaxMsg("删除角色成功！");
			}
		} catch (NumberFormatException e) {
			resultMap=AjaxUtils.buildFailedJsonAjaxMsg("删除角色失败！");
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return resultMap;
	}

}
