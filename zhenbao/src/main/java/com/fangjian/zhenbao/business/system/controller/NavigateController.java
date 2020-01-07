package com.fangjian.zhenbao.business.system.controller;

import com.fangjian.zhenbao.base.bind.annotation.CurrentUser;
import com.fangjian.zhenbao.base.bind.annotation.RecordLog;
import com.fangjian.zhenbao.business.system.entity.User;
import com.fangjian.zhenbao.business.system.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * ClassName: NavigateController <br/>
 * Description: 导航块路由 <br/>
 * date: 2014年5月12日 下午4:08:58 <br/>
 *
 * @author zyyang3
 * @since JDK 1.6
 */
@Controller
public class NavigateController {
    @Autowired
    private AuthorityService authorityService;


    /************************************ 系统管理平台 *******************************************************/
    /**
     * 系统管理平台路由
     */

    /**
     * getSystemUrl:系统管理. <br/>
     */
    @RequestMapping(value = "/system", method = RequestMethod.GET)
    @RecordLog(remark = "登陆账号管理平台")
    public String getSystemUrl(@CurrentUser User user) {

        String url = authorityService.findNavigateUrlByUserName(user.getUsername(), "/system");
        if (url.startsWith("/")) {
            url = url.substring(1, url.length());
        }
        return "redirect:" + url;
    }



    @RequestMapping(value = "/news", method = RequestMethod.GET)
    @RecordLog(remark = "资讯管理平台")
    public String getNewsUrl(@CurrentUser User user) {

        String url = authorityService.findNavigateUrlByUserName(user.getUsername(), "/news");
        if (url.startsWith("/")) {
            url = url.substring(1, url.length());
        }
        return "redirect:" + url;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @RecordLog(remark = "用户管理平台")
    public String getUsersUrl(@CurrentUser User user) {

        String url = authorityService.findNavigateUrlByUserName(user.getUsername(), "/user");
        if (url.startsWith("/")) {
            url = url.substring(1, url.length());
        }
        return "redirect:" + url;
    }

    @RequestMapping(value = "/huabo", method = RequestMethod.GET)
    @RecordLog(remark = "环保管理平台")
    public String getHuaboUrl(@CurrentUser User user) {

        String url = authorityService.findNavigateUrlByUserName(user.getUsername(), "/huabo");
        if (url.startsWith("/")) {
            url = url.substring(1, url.length());
        }
        return "redirect:" + url;
    }
}
