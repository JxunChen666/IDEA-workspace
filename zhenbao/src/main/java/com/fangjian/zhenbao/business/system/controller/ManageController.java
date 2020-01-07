package com.fangjian.zhenbao.business.system.controller;

import com.fangjian.zhenbao.base.PageBean;
import com.fangjian.zhenbao.base.bind.annotation.CurrentUser;
import com.fangjian.zhenbao.base.bind.annotation.RecordLog;
import com.fangjian.zhenbao.business.huabo.controller.HuaboUserController;
import com.fangjian.zhenbao.business.huabo.entity.District;
import com.fangjian.zhenbao.business.huabo.entity.Question;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import com.fangjian.zhenbao.business.system.entity.BasePage;
import com.fangjian.zhenbao.business.system.entity.Menu;
import com.fangjian.zhenbao.business.system.entity.User;
import com.fangjian.zhenbao.business.system.service.ManageService;
import com.fangjian.zhenbao.business.system.service.MenuService;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 账号管理
 * Created by ChenYan on 2020/1/2.
 */


@Controller
@RequestMapping("/system/manage")
public class ManageController {

    private static final Logger logger = LogManager.getLogger(HuaboUserController.class);

    @Autowired
    private SystemBaseDao systemBaseDao;

    @Autowired
    private ManageService manageService;

    @Autowired
    private MenuService menuService;



       /********************************* 账 号 管 理 ***********************************/

    /**
     * 查看省份管理页面
     */
    @RecordLog(remark = "账号管理")
    @RequiresPermissions("system:manage:alias")
    @RequestMapping(value = "/alias", method = RequestMethod.GET)
    public String alias(Model model) {
        /** 菜单 */
        List<Menu> menus = menuService.findMenu("/system");
        model.addAttribute("menus", menus);
        /** 基础页面 */
        BasePage basePage = new BasePage("system", "manage", "alias", "账号管理", "省份简称");
        model.addAttribute("basePage", basePage);

        return "system/manage/alias";
    }

    /**
     * 获取省份列表+模糊查询+分页
     * @param page
     * @return
     */
    @RequiresPermissions("system:manage:alias")
    @RequestMapping(value = "/getDistrictList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDistrictList(PageBean page,District district) {
        Map<String, Object> resultMap = new HashMap<>();

        try {
            resultMap = manageService.findDistrictPage(page,district);
            logger.info("districtService======>>>>>"+resultMap);
            resultMap.put("flag", true);
        } catch (Exception e) {
            resultMap.put("flag", false);
            resultMap.put("msg", "获取省份列表异常!");
            logger.error("获取省份列表异常" + ExceptionUtils.getFullStackTrace(e));
        }
        return resultMap;
    }


    /**
     * 跳到编辑省份信息的界面
     *
     * @param id
     * @param model
     * @return
     */
    @RequiresPermissions("system:manage:alias")
    @RequestMapping(value = "/toEditDistrict", method = RequestMethod.GET)
    public String toEditHuaboUser(Integer id, Model model) {
        if (null != id) {
            District district = manageService.findDistrictById(id);
            model.addAttribute("dis", district);
        }
        return "system/manage/aliasEdit";
    }


    /**
     * 保存省份信息
     *
     * @param district
     * @return map
     */
    @RequiresPermissions("system:manage:alias")
    @RequestMapping(value = "/saveDistrict", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveDistrict(District district) {
        logger.info("修改省份==========>>>>>>>"+ district.getDisId());
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();

        Integer id = district.getDisId();
        String disName = district.getDisName();
        if (StringUtils.isNotEmpty(disName)) {
            params.put("disName", disName);
        }
        String disSimpleName = district.getDisSimpleName();
        if (StringUtils.isNotEmpty(disSimpleName)) {
            params.put("disSimpleName", disSimpleName);
        }

        //查询有没有已经存在的省份信息
        List<District> exisDisName = manageService.findDisName(params);
        District exisDistrict=new District();
        for(District dis : exisDisName) {
            System.out.println("省份信息========》》》》》》》" + dis.getDisName());
            exisDistrict=dis;
        }

        try {
            if (id==null) {
                    if (exisDistrict.getDisName()==null&&exisDistrict.getDisSimpleName()==null){
                            manageService.insertDistrict(district);
                            resultMap.put("flag", true);
                            resultMap.put("msg", "添加省份成功");
                    } else {
                        resultMap.put("flag", false);
                        resultMap.put("msg", "该省份信息已经存在,拒绝添加");
                    }

            } else {
                if (exisDistrict.getDisName()==null&&exisDistrict.getDisSimpleName()==null) {
                        manageService.updateDistrict(district);
                        resultMap.put("flag", true);
                        resultMap.put("msg", "修改省份成功");
                }else {
                    resultMap.put("flag", false);
                    resultMap.put("msg", "该省份信息已经存在,拒绝修改");
                }
            }
        } catch (Exception e) {
            resultMap.put("flag", false);
            resultMap.put("msg", "保存省份信息异常");
            logger.error("保存省份信息异常" + ExceptionUtils.getFullStackTrace(e));
        }
        return resultMap;
    }

    /**
     * 删除省份
     * @param id
     * @return
     */
    @RequiresPermissions("system:manage:alias")
    @RequestMapping(value = "/delDistrict", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delDistrict(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        System.out.println("删除省份=======》》》》》"+id);
        try {
            manageService.deleteDistrict(id);
            resultMap.put("flag", true);
        } catch (Exception e) {
            resultMap.put("flag", false);
            resultMap.put("msg", "删除省份异常!");
            logger.error("删除省份异常" + ExceptionUtils.getFullStackTrace(e));
        }
        return resultMap;
    }




        /********************************* 反 馈 管 理 ***********************************/

    /**
     * 查看反馈管理页面
     */
    @RecordLog(remark = "账号管理")
    @RequiresPermissions("system:manage:feedback")
    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String user(Model model) {
        /** 菜单 */
        List<Menu> menus = menuService.findMenu("/system");
        model.addAttribute("menus", menus);
        /** 基础页面 */
        BasePage basePage = new BasePage("system", "manage", "feedback", "账号管理", "反馈管理");
        model.addAttribute("basePage", basePage);

        return "system/manage/feedback";
    }




    /**
     * 获取反馈列表+模糊查询+分页
     * @param page
     * @param question
     * @return
     */
    @RequiresPermissions("system:manage:feedback")
    @RequestMapping(value = "/getQuestionList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDistrictList(@CurrentUser User user,PageBean page, Question question,User u) {
        Map<String, Object> resultMap = new HashMap<>();
        u.setOrganizationId(user.getOrganizationId());
        try {
            resultMap = manageService.findQuestionPage(page,question,u);
            logger.info("manageService======>>>>>"+resultMap);
            resultMap.put("flag", true);
        } catch (Exception e) {
            resultMap.put("flag", false);
            resultMap.put("msg", "获取反馈列表异常!");
            logger.error("获取反馈列表异常" + ExceptionUtils.getFullStackTrace(e));
        }
        return resultMap;
    }
}
