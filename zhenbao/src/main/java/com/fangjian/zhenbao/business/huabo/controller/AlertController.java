package com.fangjian.zhenbao.business.huabo.controller;

import com.fangjian.zhenbao.base.PageBean;
import com.fangjian.zhenbao.base.bind.annotation.CurrentUser;
import com.fangjian.zhenbao.business.huabo.entity.CarOffModel;
import com.fangjian.zhenbao.business.huabo.service.*;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 告警控制层
 * @date 2019-06-28 16:33
 */
@Controller
@RequestMapping("huabo/monitor")
public class AlertController {
    private static Logger logger = LogManager.getLogger(AlertController.class);

    @Autowired
    private MenuService menuService;
    @Autowired
    private AlertService alertService;

    /**
     * 跳到长期不在线车辆监控首页
     *
     * @param model
     * @return
     */
    @RequiresPermissions("huabo:monitor:off")
    @RequestMapping(value = "/off", method = RequestMethod.GET)
    public String index(Model model) {
        /** 菜单 */
        List<Menu> menus = menuService.findMenu("/huabo");
        model.addAttribute("menus", menus);
        /** 基础页面 */
        BasePage basePage = new BasePage("huabo", "monitor", "off", "数据监控", "长期不在线车辆");
        model.addAttribute("basePage", basePage);

        long now = System.currentTimeMillis() / 1000;
        List<CarOffModel> offTimeList = new ArrayList<>();
        offTimeList.add(new CarOffModel(now - 259200, "3天以上"));
        offTimeList.add(new CarOffModel(now - 604800, "7天以上"));
        offTimeList.add(new CarOffModel(now - 1296000, "15天以上"));
        offTimeList.add(new CarOffModel(now - 2592000, "1个月以上"));
        offTimeList.add(new CarOffModel(now - 5184000, "2个月以上"));
        offTimeList.add(new CarOffModel(now - 7776000, "3个月以上"));

        model.addAttribute("offTimeList", offTimeList);

        return "huabo/monitor/off";
    }

    /**
     * 获取长期不在线车辆
     *
     * @param page
     * @param carOffModel
     * @param user
     * @return
     */
    @RequiresPermissions("huabo:monitor:off")
    @RequestMapping(value = "/getCarOffList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCarOffList(PageBean page, CarOffModel carOffModel, @CurrentUser User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            result = alertService.getCarOffList(page, carOffModel, user);
        } catch (Exception e) {
            logger.error("获取长期不在线车辆异常" + ExceptionUtils.getFullStackTrace(e));
        }
        return result;
    }

}
