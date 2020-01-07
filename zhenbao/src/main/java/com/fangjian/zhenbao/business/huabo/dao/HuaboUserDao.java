package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import com.fangjian.zhenbao.business.system.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 环保项目用户管理
 * @date 2019-03-07 10:28
 */
@Repository
public class HuaboUserDao extends SystemBaseDao {
    /**
     * 根据条件查询用户列表
     *
     * @param params
     * @return
     */
    public List<User> getUserByCondition(Map<String, Object> params) {
        return getList("UserMapper.getUserByCondition", params);
    }

    /**
     * 根据条件查询用户总数
     *
     * @param params
     * @return
     */
    public long getCountByCondition(Map<String, Object> params) {
        return get("UserMapper.getCountByCondition", params);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    public int insertUser(User user) {
        return save("UserMapper.insertSelective", user);
    }

    /**
     * 更新用户/锁定用户/修改密码
     *
     * @param user
     * @return
     */
    public int updateUser(User user) {
        return update("UserMapper.updateByPrimaryKeySelective", user);
    }

    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     */
    public User getUserByUserName(String username) {
        return get("UserMapper.findUserByUsername", username);
    }

    /**
     * 通过主键名查找用户
     *
     * @param id
     * @return
     */
    public User selectByPrimaryKey(Integer id) {
        return get("UserMapper.selectByPrimaryKey", id);
    }

    /**
     * 根据检测站获取还没有分配设备的检测员列表
     *
     * @param params
     * @return
     */
    public List<User> getUserListNoDevice(Map<String, Object> params) {
        return getList("UserMapper.getUserListNoDevice", params);
    }

    /**
     * 根据检测站获取检测员列表
     *
     * @param params
     * @return
     */
    public List<User> getUserListByStation(Map<String, Object> params) {
        return getList("UserMapper.getUserListByStation", params);
    }
}
