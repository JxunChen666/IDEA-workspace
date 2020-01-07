package com.fangjian.zhenbao.business.system.controller;

import com.fangjian.zhenbao.base.bind.annotation.RecordLog;
import com.fangjian.zhenbao.business.system.entity.*;
import com.fangjian.zhenbao.business.system.service.AuthorityService;
import com.fangjian.zhenbao.business.system.service.MailService;
import com.fangjian.zhenbao.business.system.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/system/authority")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MailService ms;

    //private static Logger logger = LoggerFactory.getLogger(AuthorityController.class);

    /************************************ 用户管理 *******************************************************/
    /**
     * 查看用户管理页面
     */
    @RecordLog(remark = "用户管理")
    @RequiresPermissions("system:authority:user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model) {
        /**菜单*/
        List<Menu> menus = menuService.findMenu("/system");
        model.addAttribute("menus", menus);
        /** 基础页面 */
        BasePage basePage = new BasePage("system", "authority", "user", "系统管理", "用户管理");
        model.addAttribute("basePage", basePage);

        /** table模块 */
        BaseTable baseTable =
            new BaseTable("用户管理", "user_table", "用户名,姓名,电子邮箱,电话,紧急电话,添加时间,所属角色,操作");
        model.addAttribute("baseTable", baseTable);

        /** roles模块*/
        Map<String, String> roles = authorityService.user_role();
        model.addAttribute("roles", roles);

        return "system/authority/user";
    }

    /**
     * 获取所有用户
     */
    @RequiresPermissions("system:authority:user")
    @RequestMapping(value = "/findallusers", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> findallusers() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<List<Object>> aaData = authorityService.findAllUsers();
        result.put("aaData", aaData);
        return result;
    }

    /**
     * 获取所有角色
     */
    @RequiresPermissions("system:authority:user")
    @RequestMapping(value = "/findallrolemap", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> findallrolemap() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, String> roles = authorityService.user_role();
        result.put("roles", roles);
        return result;
    }

    /**
     * 添加用户
     *
     * @param user 要添加的用户信息
     * @return
     */
    @RequiresPermissions("system:authority:user")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addUser(User user) {

        Map<String, Object> result = new HashMap<String, Object>();
        if (null != authorityService.findUserByUsername(user.getUsername())) {
            result.put("message", "用户已经存在请更换用户名!");
            return result;
        }
        String pd = user.getPassword();
        authorityService.createUser(user);
        result.put("message", "添加成功!");
        if (StringUtils.isBlank(user.getId().toString())) {
            result.put("message", "添加失败,请稍后再试!");
        }
        String[] toEmail = {"yfsun@yfsun.cn", user.getEmail()};
        ms.sendTextMail(toEmail, "用户添加成功", "用户名:" + user.getUsername() + "    密码:" + pd);

        return result;
    }

    /**
     * 编辑用户会话框框中的内容
     *
     * @return
     */
    @RequiresPermissions("system:authority:user")
    @RequestMapping(value = "/editUserForm/{id}", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> editUserForm(@PathVariable("id") long id) {
        //声明返回结果的容器
        Map<String, Object> result = new HashMap<String, Object>();
        User user = authorityService.findUserByID(id);
        result.put("user", user);

        Map<String, String> roles = authorityService.user_role();
        List<Long> list = user.getRoleIds();
        Map<String, String> userroles = new HashMap<String, String>();
        for (long roleid : list) {
            String key = roleid + "";
            String value = roles.get(key);
            userroles.put(key, value);
        }
        result.put("userroles", userroles);
        return result;
    }

    /**
     * 编辑用户信息
     *
     * @param user    用户信息
     * @return
     */
    @RequiresPermissions("system:authority:user")
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> editUser(User user) {
        //声明返回结果的容器
        Map<String, Object> result = new HashMap<String, Object>();

        //更新用户信息并根据更新情况将结果放入容器并返回
        try {
            authorityService.updateUser(user);
            result.put("flag", true);
            result.put("message", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", false);
            result.put("message", "保存失败，请稍后再试！");
        }
        return result;
    }

    /**
     * 删除用户
     *
     * @param id 要删除用户的ID
     * @return
     */
    @RequiresPermissions("system:authority:user")
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> deleteUser(@PathVariable("id") long id) {
        //声明返回结果的容器
        Map<String, Object> result = new HashMap<String, Object>();

        //删除用户并根据情况将结果放入容器并返回
        try {
            authorityService.deleteUser(id);
            result.put("flag", true);
            result.put("message", "删除用户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", false);
            result.put("message", "删除用户失败，请稍后再试！");
        }
        return result;
    }

    /**
     * ********************************* 角色管理 ******************************************************
     */
    @RequiresPermissions("system:authority:role")
    @RecordLog(remark = "角色管理")
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String role(Model model) {
        /**菜单*/
        List<Menu> menus = menuService.findMenu("/system");
        model.addAttribute("menus", menus);
        /** 基础页面 */
        BasePage basePage = new BasePage("system", "authority", "role", "系统管理", "角色管理");
        model.addAttribute("basePage", basePage);

        /** table模块 */
        BaseTable baseTable =
            new BaseTable("角色管理", "role_table", "角色名,角色描述,操作");
        model.addAttribute("baseTable", baseTable);

        /** roles模块*/
        Map<String, String> roles = authorityService.user_role();
        model.addAttribute("roles", roles);
        return "system/authority/role";
    }

    /**
     * 获取所有角色
     */
    @RequiresPermissions("system:authority:role")
    @RequestMapping(value = "/findallroles", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> findallroles() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<List<Object>> aaData = authorityService.findAllRoles();
        result.put("aaData", aaData);
        return result;
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @RequiresPermissions("system:user:role")
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addRole(String role, String description,
        String resource_ids) {

        Map<String, Object> result = new HashMap<String, Object>();
        if (null != authorityService.findRoleByName(role)) {
            result.put("message", "角色已经存在请更换用户名!");
            return result;
        }
        Role newrole = new Role();
        newrole.setRole(role);
        newrole.setDescription(description);
        newrole.setResourceIdsStr(resource_ids);

        authorityService.createRole(newrole);
        result.put("message", "添加成功!");
        if (StringUtils.isBlank(newrole.getId().toString())) {
            result.put("message", "添加失败,请稍后再试!");
        }
        return result;
    }

    /**
     * 编辑角色会话框框中的内容
     *
     * @return
     */
    @RequiresPermissions("system:authority:role")
    @RequestMapping(value = "/editRoleForm/{id}", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> editRoleForm(@PathVariable("id") long id) {
        //声明返回结果的容器
        Map<String, Object> result = new HashMap<String, Object>();
        Role role = authorityService.findRoleByID(id);
        result.put("role", role);
        return result;
    }

    /**
     * 编辑用户角色
     *
     * @param role    用户角色
     * @param description 用户角色描述
     * @return
     */
    @RequiresPermissions("system:authority:role")
    @RequestMapping(value = "/editRole", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> editRole(String role, String description,
        String resource_ids) {
        //声明返回结果的容器
        Map<String, Object> result = new HashMap<String, Object>();
        Role newrole = new Role();
        newrole.setRole(role);
        newrole.setDescription(description);
        newrole.setResourceIdsStr(resource_ids);
        //更新用户信息并根据更新情况将结果放入容器并返回
        try {
            authorityService.updateRole(newrole);
            result.put("message", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", false);
            result.put("message", "保存失败，请稍后再试！");
        }
        return result;
    }


    /**
     * 删除角色
     *
     * @param id 要删除角色
     * @return
     */
    @RequiresPermissions("system:authority:role")
    @RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> deleteRole(@PathVariable("id") long id) {
        //声明返回结果的容器
        Map<String, Object> result = new HashMap<String, Object>();

        //删除用户并根据情况将结果放入容器并返回
        try {
            authorityService.deleteRole(id);
            result.put("flag", true);
            result.put("message", "删除用户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("flag", false);
            result.put("message", "删除用户失败，请稍后再试！");
        }
        return result;
    }

    /**
     * ********************************* 资源管理 ******************************************************
     */
    @RequiresPermissions("system:authority:resource")
    @RecordLog(remark = "资源管理")
    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    public String resource(Model model) {
        /**菜单*/
        List<Menu> menus = menuService.findMenu("/system");
        model.addAttribute("menus", menus);
        /** 基础页面 */
        BasePage basePage = new BasePage("system", "authority", "resource", "系统管理", "资源管理");
        model.addAttribute("basePage", basePage);

        return "system/authority/resource";
    }

    /**
     * 获取所有资源
     */
    @RequiresPermissions("system:authority:resource")
    @RequestMapping(value = "/getresource", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getresource() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resourceList",
            authorityService.getAllResource()); // authorityService.getAllResource()
        return result;
    }

    /**
     * 获取资源节点数据
     */
    @RequiresPermissions("system:authority:resource")
    @RequestMapping(value = "/appendChild", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> showAppendChildForm(long parentId) {
        Map<String, Object> result = new HashMap<String, Object>();

        Resource parent = authorityService.findOneResource(parentId);
        result.put("parent", parent);
        return result;
    }

    /**
     * 添加资源节点
     */
    @RequiresPermissions("system:authority:resource")
    @RequestMapping(value = "/appendChild", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> appendChild(Resource resource) {
        Map<String, Object> result = new HashMap<String, Object>();
        authorityService.createResource(resource);
        return result;
    }

    /**
     * 删除资源节点
     */
    @RequiresPermissions("system:authority:resource")
    @RequestMapping(value = "/delChild", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> delChild(long id) {
        Map<String, Object> result = new HashMap<String, Object>();

        authorityService.delResource(id);
        result.put("message", "删除成功!");
        return result;
    }

    /**
     * 获取编辑资源节点数据
     */
    @RequiresPermissions("system:authority:resource")
    @RequestMapping(value = "/editChild", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getChildForm(long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        Resource child = authorityService.findOneResource(id);
        result.put("child", child);
        return result;
    }

    /**
     * 编辑资源节点
     */
    @RequiresPermissions("system:authority:resource")
    @RequestMapping(value = "/editChild", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> editChild(Resource resource) {
        Map<String, Object> result = new HashMap<String, Object>();
        authorityService.updateResource(resource);
        result.put("message", "删除成功!");
        return result;
    }

    /**
     * 查看系统日志页面
     */
    @RecordLog(remark = "查看系统日志")
    @RequiresPermissions("system:authority:syslog")
    @RequestMapping(value = "/syslog", method = RequestMethod.GET)
    public String syslog(Model model) {
        /**菜单*/
        List<Menu> menus = menuService.findMenu("/system");
        model.addAttribute("menus", menus);
        /** 基础页面 */
        BasePage basePage = new BasePage("system", "authority", "syslog", "系统管理", "系统日志");
        model.addAttribute("basePage", basePage);

        /** table模块 */
        BaseTable baseTable =
            new BaseTable("系统日志", "syslog_table", "用户账号,IP地址,访问时间,访问路径,访问标识");
        model.addAttribute("baseTable", baseTable);

        return "system/authority/syslog";
    }
    /**
     * 获系统日志数据
     */
    @RequiresPermissions("system:authority:syslog")
    @RequestMapping(value = "/findsyslog", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> findSysLog(String date) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<List<Object>> aaData = authorityService.findSysLogByDate(date);
        result.put("aaData", aaData);
        return result;
    }




}

