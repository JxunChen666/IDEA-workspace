package com.fangjian.zhenbao.business.huabo.controller;

import com.fangjian.zhenbao.base.PageBean;
import com.fangjian.zhenbao.base.bind.annotation.CurrentUser;
import com.fangjian.zhenbao.base.utils.DateUtils;
import com.fangjian.zhenbao.business.huabo.service.HuaboUserService;
import com.fangjian.zhenbao.business.system.entity.BasePage;
import com.fangjian.zhenbao.business.system.entity.Menu;
import com.fangjian.zhenbao.business.system.entity.User;
import com.fangjian.zhenbao.business.system.service.MenuService;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 环保项目用户管理
 * @date 2019-03-07 11:42
 */
@Controller
@RequestMapping("huabo/role")
public class HuaboUserController {
    private static final Logger logger = LogManager.getLogger(HuaboUserController.class);

    @Autowired
    private HuaboUserService huaboUserService;
    @Autowired
    private MenuService menuService;

    //环保检测员角色ID
    private static final String HUABO_TSETOR_ROLE_ID = "8,";

    /**
     * 跳到用户管理首页
     *
     * @param model
     * @return
     */
    @RequiresPermissions("huabo:role:testor")
    @RequestMapping(value = "/testor", method = RequestMethod.GET)
    public String testor(Model model) {
        /** 菜单 */
        List<Menu> menus = menuService.findMenu("/huabo");
        model.addAttribute("menus", menus);
        /** 基础页面 */
        BasePage basePage = new BasePage("huabo", "role", "testor", "账号管理", "检测员管理");
        model.addAttribute("basePage", basePage);

        return "huabo/role/testor";
    }

    /**
     * 获取环保用户列表
     *
     * @param user
     * @param page
     * @param u
     * @return
     */
    @RequiresPermissions("huabo:role:testor")
    @RequestMapping(value = "/getUserByCondition", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getUserByCondition(@CurrentUser User user, PageBean page, User u) {
        Map<String, Object> resultMap = new HashMap<>();
        u.setCityCode(user.getCityCode());
        u.setRoleIdsStr(HUABO_TSETOR_ROLE_ID);
        u.setOrganizationId(user.getOrganizationId());
        try {
            resultMap = huaboUserService.getUserByCondition(page, u);
            resultMap.put("flag", true);
        } catch (Exception e) {
            resultMap.put("flag", false);
            resultMap.put("msg", "获取环保用户列表异常!");
            logger.error("获取环保用户列表异常" + ExceptionUtils.getFullStackTrace(e));
        }
        return resultMap;
    }

    /**
     * 跳到编辑检测员信息的界面
     *
     * @param id
     * @param model
     * @return
     */
    @RequiresPermissions("huabo:role:testor")
    @RequestMapping(value = "/toEditHuaboUser", method = RequestMethod.GET)
    public String toEditHuaboUser(Integer id, Model model) {
        if (null != id) {
            User user = huaboUserService.selectByPrimaryKey(id);
            model.addAttribute("u", user);
        }
        return "huabo/role/testorEdit";
    }

    /**
     * 保存用户信息
     *
     * @param u
     * @param user
     * @return
     */
    @RequiresPermissions("huabo:role:testor")
    @RequestMapping(value = "/saveHuaboUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveHuaboUser(User u, @CurrentUser User user) {
        System.out.println("进入========》》》》》》》saveHuaboUser");
        Map<String, Object> resultMap = new HashMap<>();
        Long id = u.getId();
        try {
            if (null == id) {
                //查询有没有已经存在的用户名
                User existUser = huaboUserService.getUserByUserName(u.getUsername());
                if (null == existUser) {
                    u.setCityCode(user.getCityCode());//区分哪家检测站
                    u.setOrganizationId(user.getOrganizationId());//区分哪家数据customer
                    u.setTime(DateUtils.formatDateTime(new Date()));
                    huaboUserService.insertUser(u);
                    resultMap.put("flag", true);
                    resultMap.put("msg", "添加检测员成功");
                } else {
                    resultMap.put("flag", false);
                    resultMap.put("msg", "用户名已经存在");
                }
            } else {
                huaboUserService.updateUser(u);
                resultMap.put("flag", true);
                resultMap.put("msg", "修改检测员成功");
            }
        } catch (Exception e) {
            resultMap.put("flag", false);
            resultMap.put("msg", "保存检测员信息异常");
            logger.error("保存检测员信息异常" + ExceptionUtils.getFullStackTrace(e));
        }
        return resultMap;
    }

    /**
     * 重置密码界面
     *
     * @param id
     * @param model
     * @return
     */
    //@RequiresPermissions({"huabo:role:testor","huabo:role:county"})
    @RequestMapping(value = "/toResetPassword", method = RequestMethod.GET)
    public String toResetPassword(Integer id, Model model) {
        if (null != id) {
            User user = huaboUserService.selectByPrimaryKey(id);
            model.addAttribute("u", user);
        }
        return "huabo/role/testorResetPassword";
    }


    /**
     * 重置密码
     *
     * @param user
     * @return
     */
    //@RequiresPermissions({"huabo:role:testor","huabo:role:county"})
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> resetPassword(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            int r = huaboUserService.resetPassword(user);
            if (r == 1) {
                resultMap.put("flag", true);
                resultMap.put("msg", "重置密码成功!");
            } else {
                resultMap.put("flag", false);
                resultMap.put("msg", "重置密码失败!");
            }
        } catch (Exception e) {
            resultMap.put("flag", false);
            resultMap.put("msg", "重置密码异常!");
            logger.error("重置密码异常" + ExceptionUtils.getFullStackTrace(e));
        }
        return resultMap;
    }

}