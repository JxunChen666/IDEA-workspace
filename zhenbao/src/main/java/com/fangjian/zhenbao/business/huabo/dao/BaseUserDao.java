package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.BaseUser;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author FangJian
 * @description: 图鸽用户dao层
 * @date 2019-07-23 14:24
 */
@Repository
public class BaseUserDao extends SystemBaseDao {

    /**
     * 新增一个图鸽用户
     *
     * @param baseUser
     * @return
     */
    public int addUser(BaseUser baseUser) {
        return save("BaseUserMapper.insertSelective", baseUser);
    }

    /**
     * 根据手机号码获取用户
     *
     * @param userMobile
     * @return
     */
    public BaseUser getUserByMobile(String userMobile) {
        return get("BaseUserMapper.getUserByMobile", userMobile);
    }

    /**
     * 根据唯一用户名获取用户
     *
     * @param userName
     * @return
     */
    public BaseUser getUserByUserName(String userName) {
        return get("BaseUserMapper.getUserByUserName", userName);
    }


    /**
     * 查询是否有服务站的图鸽用户(一个服务站只能有一个管理员)
     *
     * @param serviceId
     * @return
     */
    public BaseUser getByManageStationId(Integer serviceId) {
        return get("BaseUserMapper.getByManageStationId", serviceId);
    }

    /**
     * 根据主键获取图鸽用户
     *
     * @param userId
     * @return
     */
    public BaseUser getByUserId(int userId) {
        return get("BaseUserMapper.selectByPrimaryKey", userId);
    }
}
