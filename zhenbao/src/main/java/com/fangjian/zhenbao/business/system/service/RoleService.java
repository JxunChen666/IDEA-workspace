package com.fangjian.zhenbao.business.system.service;

import com.fangjian.zhenbao.base.PageBean;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import com.fangjian.zhenbao.business.system.dao.UserDao;
import com.fangjian.zhenbao.business.system.entity.Resource;
import com.fangjian.zhenbao.business.system.entity.Role;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 */
@Service
public class RoleService {
	@Autowired
	private SystemBaseDao systemBaseDao;
	@Autowired
	private UserDao userDao;
	/**
	 * 获取角色和id映射关系表
	 */
	public Map<String, String> userMapRole() {
		Map<String, String> map = new HashMap<String, String>();
		List<Role> roles = systemBaseDao.getList("AuthorityMapper.findAllRoles");
		for (Role role : roles) {
			map.put(role.getId().toString(), role.getRole());
		}
		return map;
	}

	public List<Role> getAllRolesList(){
		return systemBaseDao.getList("AuthorityMapper.findAllRoles");
	}

	public List<Resource> getAllResource() {
        return systemBaseDao.getList("AuthorityMapper.findAllResource");
    }

	public int addRole(Role role){
		return userDao.addRole(role);
	}

	public Role getRoleByName(String name){
		return userDao.getRoleByName(name);
	}

    @CacheEvict(value = "permissions", allEntries = true, beforeInvocation = true)
	public int updateRole(Role role){
		return userDao.updateRole(role);
	}

	public Role getRoleById(Long id){
		return userDao.getRoleById(id);
	}
	public int deleteRole(Long id){
		return userDao.deleteRole(id);
	}

	public Map<String,Object> getAllRoles(PageBean page,Role roleObj){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("available", 1);
		params.put("start", page.getStart());
		params.put("pageSize", page.getPageSize());
		if(StringUtils.isNotEmpty(roleObj.getDescription())){
			params.put("description", roleObj.getDescription());
		}
		List<Role> roles=userDao.getAllRoles(params);
		long counts=userDao.getRoleCount(params);
		List<List<Object>> aaData = new ArrayList<List<Object>>();
		for(Role roleTemp:roles){
			List<Object> tempList= builder(roleTemp);
			aaData.add(tempList);
		}
		resultMap.put("aaData", aaData);
		resultMap.put("iTotalRecords", counts);
		resultMap.put("iTotalDisplayRecords", counts);
		return resultMap;
	}
	
	 private List<Object> builder(Role roleObj){
		 List<Object> list = new ArrayList<Object>();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 list.add(roleObj.getRole());
		 list.add(roleObj.getDescription());
		 list.add(roleObj.getCreateUser());
		 if(roleObj.getCreateTime() != null){
			 list.add(df.format(roleObj.getCreateTime()));
		 }else{
			 list.add(null);
		 }
		 list.add(roleObj.getUpdateUser());
		 if(roleObj.getUpdateTime() != null){
			 list.add(df.format(roleObj.getUpdateTime()));
		 }else{
			 list.add(null);
		 }
		 list.add(roleObj.getId());
		 return list;
	 }
}
