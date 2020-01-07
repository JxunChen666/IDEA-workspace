package com.fangjian.zhenbao.business.huabo.service;

import com.fangjian.zhenbao.base.PageBean;
import com.fangjian.zhenbao.business.huabo.dao.HuaboUserDao;
import com.fangjian.zhenbao.business.system.dao.UserDao;
import com.fangjian.zhenbao.business.system.entity.User;
import com.fangjian.zhenbao.business.system.service.PasswordHelper;
import com.fangjian.zhenbao.business.system.service.RoleService;
import com.fangjian.zhenbao.business.user.entity.ServiceStation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * @author FangJian
 * @description: 环保项目用户管理
 * @date 2019-03-07 10:48
 */
@Service
public class HuaboUserService {
    @Autowired
    private HuaboUserDao huaboUserDao;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordHelper passwordHelper;

    //环保检测员角色ID
    private static final String HUABO_TSETOR_ROLE_ID = "8,";
    //环保检测I站账号角色ID
    private static final String HUABO_I_STATION_USER_ROLE_ID = "7,";
    //环保维修M站账号角色ID
    private static final String HUABO_M_STATION_USER_ROLE_ID = "9,";
    //环保综合站账号角色ID
    private static final String HUABO_A_STATION_USER_ROLE_ID = "10,";

    /**
     * 根据条件查询用户列表(不分角色获取用户统一的方法)
     *
     * @param page
     * @param user
     * @return
     */
    public Map<String, Object> getUserByCondition(PageBean page, User user) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        params.put("cityCode", user.getCityCode());//根据当前检测站的账号去查找是属于那个检测站id

        if (null != user.getType()) {
            switch (user.getType()) {//服务站类型
                case 0:
                    params.put("roleIds", HUABO_A_STATION_USER_ROLE_ID);
                    break;
                case 1:
                    params.put("roleIds", HUABO_I_STATION_USER_ROLE_ID);
                    break;
                case 2:
                    params.put("roleIds", HUABO_M_STATION_USER_ROLE_ID);
                    break;
            }
        } else {
            params.put("roleIds", user.getRoleIdsStr());
        }

        params.put("customer", user.getOrganizationId());
        params.put("start", page.getStart());
        params.put("pageSize", page.getPageSize());
        params.put("sort", page.getSortCol());
        params.put("order", ("desc".equals(page.getSortWay()) ? Sort.Direction.DESC : Sort.Direction.ASC));

        String name = user.getName();
        if (StringUtils.isNotEmpty(name)) {
            params.put("name", name);
        }
        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)) {
            params.put("phone", phone);
        }
        List<User> users = huaboUserDao.getUserByCondition(params);
        long count = huaboUserDao.getCountByCondition(params);

        List<List<Object>> aaData = new ArrayList<>();
        Map<String, String> roleMap = roleService.userMapRole();
        for (User u : users) {
            List<Object> userList = new ArrayList<>();
            builder(u, userList, roleMap);
            aaData.add(userList);
        }

        resultMap.put("aaData", aaData);
        resultMap.put("iTotalRecords", count);
        resultMap.put("iTotalDisplayRecords", count);
        return resultMap;
    }

    //构建table列表
    private void builder(User user, List<Object> userList, Map<String, String> map) {
        userList.add(user.getUsername());
        userList.add("<font style='color:#EE3B3B;'>" + user.getName() + "</font>");
        userList.add(user.getPhone());
        userList.add(user.getEmail());
        userList.add(user.getEmergency_phone());

        String roleIds = user.getRoleIdsStr();

        String roleNames = "";
        if (roleIds.length() > 1) {
            roleIds = roleIds.substring(0, roleIds.length() - 1);
        }
        String[] splits = roleIds.split(",");
        for (String s : splits) {
            if (map.containsKey(s)) {
                roleNames = roleNames + map.get(s) + ",";
            }
        }
        if (roleNames.length() > 1) {
            roleNames = roleNames.substring(0, roleNames.length() - 1);
        }
        userList.add(roleNames);
        userList.add(!user.getLocked() ? "<span class=\"label label-sm label-success\">正常</span>" : "<span class=\"label label-sm label-danger\">锁定</span>");
        userList.add(user.getTime().substring(0, 19));

        long id = user.getId();
        String result = "";
        // 编辑按钮
        result +=
                "<i style='cursor: pointer;' title='编辑' class='icon-pencil bigger-130 blue u_edit_icon' id='" + id
                        + "'></i>&nbsp;&nbsp;";
        //重置密码
        result +=
                "<i style='cursor: pointer;' title='密码重置' class='icon-key bigger-130 green u_password_icon' id='" + id
                        + "'></i>&nbsp;&nbsp;";

        if (!user.getLocked()) {
            // 锁定按钮
            result +=
                    "<i style='cursor: pointer;' title='锁定' class='icon-unlock bigger-130 red u_lock_icon' id='" + id
                            + "'></i>";
        } else {
            // 锁定按钮
            result +=
                    "<i style='cursor: pointer;' title='已锁定' class='icon-lock bigger-130 black u_unlock_icon' id='" + id
                            + "'></i>";
        }

        userList.add(result);
    }

    /**
     * 新增检测员用户
     *
     * @param user
     * @return
     */
    public int insertUser(User user) {
        passwordHelper.encryptPassword(user);
        user.setRoleIdsStr(HUABO_TSETOR_ROLE_ID);
        //user.setRoleIds(new ArrayList<>(Arrays.asList(Long.parseLong(HUABO_TSETOR_ROLE_ID))));
        return huaboUserDao.insertUser(user);
    }


    /**
     * 新增服务站管理员账号
     *
     * @param user
     * @return
     */
    public int insertStationUser(User user) {
        passwordHelper.encryptPassword(user);

        switch (user.getType()) {//服务站类型
            case 0:
                user.setRoleIdsStr(HUABO_A_STATION_USER_ROLE_ID);
                break;
            case 1:
                user.setRoleIdsStr(HUABO_I_STATION_USER_ROLE_ID);
                break;
            case 2:
                user.setRoleIdsStr(HUABO_M_STATION_USER_ROLE_ID);
                break;
        }
        return huaboUserDao.insertUser(user);
    }

    /**
     * 更新用户/锁定用户/修改密码
     *
     * @param user
     * @return
     */
    public int updateUser(User user) {
        return huaboUserDao.updateUser(user);
    }

    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     */
    public User getUserByUserName(String username) {
        return huaboUserDao.getUserByUserName(username);
    }

    /**
     * 通过主键名查找用户
     *
     * @param id
     * @return
     */
    public User selectByPrimaryKey(Integer id) {
        return huaboUserDao.selectByPrimaryKey(id);
    }

    /**
     * 重置密码
     *
     * @param user
     * @return
     */
    public int resetPassword(User user) {
        passwordHelper.encryptPassword(user);
        return huaboUserDao.updateUser(user);
    }

    /**
     * 根据检测站获取还没有分配设备的检测员列表
     *
     * @param params
     * @return
     */
    public List<User> getUserListNoDevice(Map<String, Object> params) {
        params.put("roleIds", HUABO_TSETOR_ROLE_ID);
        return huaboUserDao.getUserListNoDevice(params);
    }

    /**
     * 根据检测站获取检测员列表
     *
     * @param params
     * @return
     */
    public List<User> getUserListByStation(Map<String, Object> params) {
        params.put("roleIds", HUABO_TSETOR_ROLE_ID);
        return huaboUserDao.getUserListByStation(params);
    }
}
