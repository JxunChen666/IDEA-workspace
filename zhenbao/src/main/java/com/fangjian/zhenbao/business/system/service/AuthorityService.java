package com.fangjian.zhenbao.business.system.service;


import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import com.fangjian.zhenbao.business.system.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class AuthorityService {

    @Autowired
    private SystemBaseDao systemBaseDao;
    // private static Logger logger = Logger.getLogger("AuthorityService.class");

    @Autowired
    private PasswordHelper passwordHelper;


    @Autowired
    private ManageService ManageService;
    /**
     * ************************************* 资源管理 *******************************************************
     */
    public List<Resource> getAllResource() {

        return systemBaseDao.getList("AuthorityMapper.findAllResource");
    }

    public Resource findOneResource(long parentId) {
        return systemBaseDao.get("AuthorityMapper.findOneResource", parentId);
    }

    public List<Resource> findOneResources(Long[] parentIds) {
        return systemBaseDao.getList("AuthorityMapper.findOneResources", parentIds);
    }

    public void createResource(Resource resource) {

        systemBaseDao.save("AuthorityMapper.createResource", resource);
    }

    /**
     * delResource:删除资源. <br/>
     */
    public void delResource(long id) {

        systemBaseDao.delete("AuthorityMapper.delResource", id);
        systemBaseDao.delete("AuthorityMapper.delChildResource", id);

    }

    public void updateResource(Resource resource) {

        systemBaseDao.update("AuthorityMapper.updateResource", resource);

    }

    /**************************************** 用户管理 ********************************************************/
    /**
     * 获取角色和id映射关系表
     */
    public Map<String, String> user_role() {
        Map<String, String> map = new HashMap<String, String>();
        List<Role> roles = systemBaseDao.getList("AuthorityMapper.findAllRoles");
        for (Role role : roles) {
            map.put(role.getId().toString(), role.getDescription());
        }
        return map;
    }

    /**
     * 获取所有用户table
     */
    public List<List<Object>> findAllUsers() {
        Map<String, String> map = user_role();
        List<List<Object>> aaData = new ArrayList<List<Object>>();
        List<User> users = systemBaseDao.getList("AuthorityMapper.findAllUsers");
        for (User user : users) {
            List<Object> list = new ArrayList<Object>();
            list.add(user.getUsername());
            list.add(user.getName());
            list.add(user.getEmail());
            list.add(user.getPhone());
            list.add(user.getEmergency_phone());
            list.add(user.getTime());
            String roleids = user.getRoleIdsStr();
            String rolenames = "";
            if (roleids.length() > 1) {
                roleids=roleids.substring(0, roleids.length() - 1);
            }
            String[] strs = roleids.split(",");
            for (String idstr : strs) {
                if (map.containsKey(idstr)) {
                    rolenames = rolenames + map.get(idstr) + ",";
                }
            }
            if (rolenames.length() > 1) {
                rolenames = rolenames.substring(0, rolenames.length() - 1);
            }
            list.add(rolenames);
            String result = "";
            // 编辑按钮
            result +=
                "<i class='icon-pencil bigger-130 blue user_edit_icon' id='" + user.getId()
                    + "'></i>&nbsp&nbsp";
            // 删除按钮
            result +=
                "<i class='icon-trash bigger-130 red user_del_icon' id='" + user.getId()
                    + "'></i>";

            list.add(result);
            aaData.add(list);
        }

        return aaData;
    }

    /**
     * 添加用户
     */
    public void createUser(User user) {
        // 加密密码
        passwordHelper.encryptPassword(user);
        systemBaseDao.save("AuthorityMapper.addUser", user);

    }

    /**
     * 通过用户名查找用户
     */
    public User findUserByUsername(String username) {
        try {
			return systemBaseDao.get("AuthorityMapper.findUserByUsername", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

    /**
     * 通过id查找用户
     */
    public User findUserByID(long id) {

        return systemBaseDao.get("AuthorityMapper.findUserByID", id);
    }

    /**
     * 删除用户
     */
    public void deleteUser(long id) {

        systemBaseDao.update("AuthorityMapper.deleteUser", id);

    }

    /**
     * 更新用户  key = "#user.username"     在需要清除缓存的方法上加上@CacheEvict
     */
    @CacheEvict(value = "permissions", key="#{user.username}", allEntries = true, beforeInvocation = true)
    public void updateUser(User user) {
        systemBaseDao.update("AuthorityMapper.updateUser", user);

    }

    /**
     * ************************************* 角色管理 *******************************************************
     */

    public List<List<Object>> findAllRoles() {
        List<List<Object>> aaData = new ArrayList<List<Object>>();
        List<Role> roles = systemBaseDao.getList("AuthorityMapper.findAllRoles");

        for (Role role : roles) {
            List<Object> list = new ArrayList<Object>();
            list.add(role.getRole());
            list.add(role.getDescription());
            String result = "";
            // 编辑按钮
            result +=
                "<i class='icon-pencil bigger-130 blue role_edit_icon' id='" + role.getId()
                    + "'></i>&nbsp&nbsp";
            // 删除按钮
            result +=
                "<i class='icon-trash bigger-130 red role_del_icon' id='" + role.getId()
                    + "'></i>";
            list.add(result);
            aaData.add(list);
        }
        return aaData;
    }

    /**
     * 添加角色
     */
    public void createRole(Role role) {
        systemBaseDao.save("AuthorityMapper.addRole", role);
    }

    /**
     * 通过角色名查找角色
     */
    public Role findRoleByName(String rolename) {

        return systemBaseDao.get("AuthorityMapper.findRoleByName", rolename);
    }

    /**
     * 通过id查找角色
     */
    public Role findRoleByID(long id) {

        return systemBaseDao.get("AuthorityMapper.findRoleByID", id);
    }

    /**
     * 通过long[] id查找角色
     */
    public List<Role> findRoleByIDs(Long[] roleIds) {

        return systemBaseDao.getList("AuthorityMapper.findRoleByIDs", roleIds);
    }

    /**
     * @CacheEvict 参数
     value	缓存的名称，在 spring 配置文件中定义，必须指定至少一个 例如：@CachEvict(value=”mycache”) 或者@CachEvict(value={”cache1”,”cache2”}
     key	缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合 例如：@CachEvict(value=”testcache”,key=”#userName”
     condition	缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才清空缓存 例如：@CachEvict(value=”testcache”,condition=”#userName.length()>2”)
     allEntries	是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存 例如：@CachEvict(value=”testcache”,allEntries=true)
     beforeInvocation	是否在方法执行前就清空，缺省为 false，如果指定为 true，则在方法还没有执行的时候就清空缓存，缺省情况下，如果方法执行抛出异常，则不会清空缓存  例如：
     @CachEvict(value=”testcache”，beforeInvocation=true)
     */

    /**
     * 删除角色     在需要清除缓存的方法上加上@CacheEvict
     */
    @CacheEvict(value = "permissions", allEntries = true, beforeInvocation = true)
    public void deleteRole(long id) {

        systemBaseDao.update("AuthorityMapper.deleteRole", id);

    }

    /**
     * 更新角色     在需要清除缓存的方法上加上@CacheEvict
     */
    @CacheEvict(value = "permissions", allEntries = true, beforeInvocation = true)
    public void updateRole(Role role) {
        systemBaseDao.update("AuthorityMapper.updateRole", role);

    }

    /**
     * 根据用户名查找其角色
     *
     * @param username
     *
     * @return
     */
    public Set<String> findRoles(String username) {
        User user = findUserByUsername(username);
        if (user == null) {
            return Collections.emptySet();
        }
        return findRoles(user.getRoleIds().toArray(new Long[0]));//该方法用了泛型,返回集合中所有元素的数组；返回数组的运行时类型与指定数组的运行时类型相同
        //数组不能强制转换.java中的强制类型转换只是针对单个对象的，想要偷懒将整个数组转换成另外一种类型的数组是不行的
        //不带参数的toArray方法，是构造的一个Object数组，然后进行数据拷贝，此时进行转型就会产生ClassCastException
        //带参数的toArray方法，则是根据参数数组的类型，构造了一个对应类型的，长度跟ArrayList的size一致的空数组，虽然方法本身还是以 Object数组的形式返回结果，
        //不过由于构造数组使用的ComponentType跟需要转型的ComponentType一致，就不会产生转型异常。
    }

    //可变数组参数。用...的话，传参数时可传可不传，传的话，可以是一个个并列地传，也可以直接是一个数组。
    //java中类型后面加三个点是java1.5之后出现的新的内容，使用在函数的形参上，相当于一个数组，调用函数时传递多少了实际参数，都可以存储到这个形参上，需要注意的是，使用这个形参必须放在最后一位形参位置上
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();

        List<Role> getRoles = findRoleByIDs(roleIds);

        if (getRoles != null) {
            for (Role role : getRoles) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    /**
     * 根据用户名查找其权限
     * 在service的实现类上加上 @Cacheable
     *
     *  value  	缓存的名称，在 spring 配置文件中定义，必须指定至少一个 例如：@Cacheable(value=”mycache”) 或者@Cacheable(value={”cache1”,”cache2”}
        key  	缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合 例如：@Cacheable(value=”testcache”,key=”#userName”)
        condition	缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存 例如：@Cacheable(value=”testcache”,condition=”#userName.length()>2”)
     * @return
     */
    @Cacheable(value = "permissions", key = "#username")
    public Set<String> findPermissions(String username) {
        User user = findUserByUsername(username);
        if (user == null) {
            return Collections.emptySet();
        }
        return findPermissions(user.getRoleIds().toArray(new Long[0]));
    }

    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();

        List<Role> getRoles = findRoleByIDs(roleIds);

        if (getRoles != null) {
            for (Role role : getRoles) {
                resourceIds.addAll(role.getResourceIds());
            }
        }
        return findPermissions(resourceIds);
    }

    public Set<String> findPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<String>();

        List<Resource> getResources = findOneResources(resourceIds.toArray(new Long[0]));

        if (getResources != null) {
            for (Resource resource : getResources) {
                if (resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                    permissions.add(resource.getPermission());
                }
            }
        }
        return permissions;
    }


    /**
     * findNavigateUrlByUserName:根据用户名查找用户导航页面连接. <br/>
     *
     * @param username 用户名
     *
     * @return
     * @author zyyang3
     * @since JDK 1.6
     */
    public String findNavigateUrlByUserName(String username, String url) {
        User user = findUserByUsername(username);
        if (user == null) {
            return "";
        }
        List<Role> getRoles = findRoleByIDs(user.getRoleIds().toArray(new Long[0]));
        Set<Long> resourceIds = new HashSet<Long>();
        if (getRoles != null) {
            for (Role role : getRoles) {
                resourceIds.addAll(role.getResourceIds());
            }
        }
        List<Resource> getResources = findOneResources(resourceIds.toArray(new Long[0]));

        if (getResources != null) {
            for (Resource resource : getResources) {
                if (resource != null && !StringUtils.isEmpty(resource.getUrl())
                    && resource.getUrl().startsWith(url)
                    && !StringUtils.isEmpty(resource.getPermission())
                    && !resource.getPermission().contains("*")) {
                    return resource.getUrl();
                }
            }
        }
        return "";
    }


    /**
     * 根据url查找资源
     *
     * @param permissionurls
     *
     * @return
     */
    public List<Resource> findResourceByUrl(String[] permissionurls) {
        return systemBaseDao.getList("AuthorityMapper.findResourceByUrl", permissionurls);
    }

    /**
     * 根据父节点id查找子资源
     *
     * @param parent_id 父节点id
     *
     * @return
     */
    public List<Resource> findResourceByParentId(Long parent_id) {
        return systemBaseDao.getList("AuthorityMapper.findResourceByParentId", parent_id);
    }


    /**
     * 系统日志记录
     */
    public void createLog(SysLog syslog) {
        systemBaseDao.save("AuthorityMapper.createSysLog", syslog);
    }

    /**
     * 根据日期获取系统日志
     */
    public List<List<Object>> findSysLogByDate(String date) {
        List<List<Object>> list = new ArrayList<List<Object>>();
        List<SysLog> syslogs = systemBaseDao.getList("AuthorityMapper.findSysLogByDate", date);
        for (SysLog syslog : syslogs) {
            List<Object> tmp = new ArrayList<Object>();
            tmp.add(syslog.getUsername());
            tmp.add(syslog.getIp());
            tmp.add(syslog.getTime());
            tmp.add(syslog.getMethodname());
            tmp.add(syslog.getRemark());
            list.add(tmp);
        }
        return list;
    }

    /**
     * 获取用户
     * @return
     * @author tangLiang
     * @date 2016-04-22
     */
    public List<User> findUsers() {
    	List<User> users = systemBaseDao.getList("AuthorityMapper.findAllUsers");
    	return users;
    }



}
