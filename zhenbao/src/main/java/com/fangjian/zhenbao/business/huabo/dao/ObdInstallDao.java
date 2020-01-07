package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.ObdInstall;
import com.fangjian.zhenbao.business.huabo.entity.ObdInstallModel;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: OBD安装单dao层
 * @date 2019-12-05 11:23
 */
@Repository
public class ObdInstallDao extends SystemBaseDao {

    /**
     * 获取OBD安装单列表
     *
     * @param params
     * @return
     */
    public List<ObdInstallModel> getObdInstallList(Map<String, Object> params) {
        return getList("ObdInstallMapper.getObdInstallList", params);
    }

    /**
     * 获取OBD安装单列表总数
     *
     * @param params
     * @return
     */
    public long getObdInstallListCount(Map<String, Object> params) {
        return get("ObdInstallMapper.getObdInstallListCount", params);
    }

    /**
     * 获取OBD安装单
     *
     * @param id
     * @return
     */
    public ObdInstall getObdInstallById(String id) {
        return get("ObdInstallMapper.selectByPrimaryKey", id);
    }

    /**
     * 修改OBD安装单信息
     *
     * @param obdInstall
     * @return
     */
    public int updateObdInstall(ObdInstall obdInstall) {
        return update("ObdInstallMapper.updateByPrimaryKeySelective", obdInstall);
    }
}
