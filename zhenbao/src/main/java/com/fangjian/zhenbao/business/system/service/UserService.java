package com.fangjian.zhenbao.business.system.service;

import com.fangjian.zhenbao.base.PageBean;
import com.fangjian.zhenbao.business.system.dao.UserDao;
import com.fangjian.zhenbao.business.system.entity.TcUser;
import com.fangjian.zhenbao.business.system.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChuJing
 * @date 2016年1月7日
 */
@Service
public class UserService {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordHelper passwordHelper;

    //private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    private static final Logger logger = LogManager.getLogger(UserService.class.getName());

    /**
     * 根据检测站ID获取底下的检测员
     *
     * @param cityCode
     * @return
     */
    public List<User> getUserByCityCode(String cityCode) {
        return userDao.getUserByCityCode(cityCode);
    }

    /**
     * <p>
     *
     * @param page
     * @param user
     * @return
     * @author ChuJing, 2016年1月7日
     */
    public Map<String, Object> findAllUsers(PageBean page, User user) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", page.getStart());
        params.put("pageSize", page.getPageSize());
        params.put("locked", 0);
        if (StringUtils.isNotEmpty(user.getUsername())) {
            params.put("username", user.getUsername());
        }
        List<User> users = userDao.getAllUsers(params);
        long count = userDao.getCount(params);
        Map<String, String> roleMap = roleService.userMapRole();
        List<List<Object>> aaData = new ArrayList<List<Object>>();

        for (User useriterater : users) {
            List<Object> tempList = new ArrayList<Object>();
            builder(useriterater, tempList, roleMap);
            aaData.add(tempList);
        }
        resultMap.put("aaData", aaData);
        resultMap.put("iTotalRecords", count);
        resultMap.put("iTotalDisplayRecords", count);
        return resultMap;
    }

    /**
     * <p>
     *
     * @param user
     * @return
     * @author ChuJing, 2016年1月7日
     */
    public int addUser(User user) {
        // 加密密码
    /*	String[] toEmail = {"yfsun@yfsun.cn", user.getEmail()};
        ms.sendTextMail(toEmail, "用户添加成功", "用户名:" + user.getUsername() + "    密码:" + user.getPassword());*/
        passwordHelper.encryptPassword(user);
        return userDao.addUser(user);
    }

    /**
     * <p>
     *
     * @param l
     * @return
     * @author ChuJing, 2016年1月7日
     */
    public User getUserById(long l) {
        return userDao.getUserById(l);
    }

    /**
     * <p>
     *
     * @param user
     * @return
     * @author ChuJing, 2016年1月7日
     */
    @CacheEvict(value = "permissions", key = "#{user.username}", allEntries = true, beforeInvocation = true)
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * <p>
     *
     * @param userName
     * @return
     * @author ChuJing, 2016年1月7日
     */
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    public int locked(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("locked", 1);//锁定
        return userDao.lockUser(params);
    }

    /**
     * 密码重置
     * <p>
     *
     * @param user
     * @return
     * @author ChuJing, 2016年1月18日
     */
    public int passwordReset(User user) {
        int result = 0;
        try {
            passwordHelper.encryptPassword(user);
            result = userDao.passwordReset(user);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getFullStackTrace(e));
        }
        return result;
    }

    /**
     * <p>
     *
     * @param user
     * @param list
     * @param map
     * @author ChuJing, 2016年1月7日
     */
    private void builder(User user, List<Object> list, Map<String, String> map) {
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
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //list.add(user.getCreateUser());
        if (user.getTime() != null) {
            list.add(user.getTime());
        } else {
            list.add(null);
        }
         /*list.add(user.getUpdateUser());
         if(user.getUpdateUser() != null){
        	 list.add(df.format(user.getUpdateTime()));
         }else{
        	 list.add(null);
         }*/
        list.add(user.getId());
    }

    /**
     * 根据用户名获取用户对象
     */
    public TcUser getUserByUserName(Map<String, Object> params) {
        return userDao.getUserByUserName(params);
    }

    public List<User> getByCCode(String cityCode) {
        return userDao.getByCityCode(cityCode);
    }

    public List<User> getUserNameByCCode(String cityCode) {
        return userDao.getUserNameByCityCode(cityCode);
    }
}
