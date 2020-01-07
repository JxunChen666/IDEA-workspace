package com.fangjian.zhenbao.business.system.dao;

import com.fangjian.zhenbao.business.system.entity.Role;
import com.fangjian.zhenbao.business.system.entity.TcUser;
import com.fangjian.zhenbao.business.system.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author ChuJing
 * @date 2016年1月7日
 */
@Component
public class UserDao extends SystemBaseDao {

    /**
     * 根据检测站ID获取底下的检测员
     *
     * @param cityCode
     * @return
     */
    public List<User> getUserByCityCode(String cityCode) {
        return getList("UserMapper.getUserByCityCode", cityCode);
    }

    /**
     * <p>
     *
     * @param params
     * @return
     * @author ChuJing, 2016年1月7日
     */
    public List<User> getAllUsers(Map<String, Object> params) {
        return getList("UserMapper.getByPage", params);
    }

    /**
     * <p>
     *
     * @param params
     * @return
     * @author ChuJing, 2016年1月7日
     */
    public long getCount(Map<String, Object> params) {
        return get("UserMapper.getCount", params);
    }

    /**
     * <p>
     *
     * @param user
     * @return
     * @author ChuJing, 2016年1月7日
     */
    public int addUser(User user) {
        return save("UserMapper.addUser", user);
    }

    /**
     * <p>
     *
     * @param user
     * @return
     * @author ChuJing, 2016年1月7日
     */
    public int updateUser(User user) {
        return update("UserMapper.updateUser", user);
    }

    public User getUserById(long l) {
        return get("UserMapper.findUserByID", l);
    }

    /**
     * <p>
     *
     * @param username
     * @return
     * @author ChuJing, 2016年1月7日
     */
    public User getUserByUserName(String username) {
        return get("UserMapper.findUserByUsername", username);
    }

    /**
     * 锁定用户
     * <p>
     *
     * @param params
     * @return
     * @author ChuJing, 2016年1月8日
     */
    public int lockUser(Map<String, Object> params) {
        return update("UserMapper.deleteUser", params);
    }

    /**
     * <p>
     *
     * @param user
     * @return
     * @author ChuJing, 2016年1月18日
     */
    public int passwordReset(User user) {
        return update("UserMapper.passwordReset", user);
    }

    /**
     * 根据用户名获取用户对象
     */
    public TcUser getUserByUserName(Map<String, Object> params) {
        return get("TcUserMapper.getUserByUserName", params);
    }

    public List<User> getByCityCode(String cityCode) {
        return getList("UserMapper.getAllByCityCode", cityCode);
    }

    public List<User> getUserNameByCityCode(String cityCode) {
        return getList("UserMapper.getUserNameByCityCode", cityCode);
    }

    /**********************************************角色管理****************************************************/
    public List<Role> getAllRoles(Map<String, Object> params) {
        return getList("RoleMapper.getByPage", params);
    }

    public long getRoleCount(Map<String, Object> params) {
        return get("RoleMapper.getCount", params);
    }

    public int addRole(Role role) {
        return save("RoleMapper.addRole", role);
    }

    public Role getRoleByName(String rolename) {
        return get("RoleMapper.findRoleByName", rolename);
    }

    public int updateRole(Role role) {
        return update("RoleMapper.updateRole", role);
    }

    public Role getRoleById(Long id) {
        return get("RoleMapper.findRoleByID", id);
    }

    public int deleteRole(Long id) {
        return delete("RoleMapper.deleteRole", id);
    }
}
