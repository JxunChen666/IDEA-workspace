package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.CarOffModel;
import com.fangjian.zhenbao.business.huabo.entity.FaultAlert;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 告警dao层
 * @date 2019-06-28 16:21
 */
@Repository
public class AlertDao extends SystemBaseDao {

    /**
     * 获取最新的报警列表
     *
     * @param params
     * @return
     */
    public List<FaultAlert> getNewestAlert(Map<String, Object> params) {
        return getList("AlertMapper.getNewestAlert", params);
    }

    /**
     * 获取长期不在线车辆
     *
     * @param params
     * @return
     */
    public List<CarOffModel> getCarOffList(Map<String, Object> params) {
        return getList("AlertMapper.getCarOffList", params);
    }

    /**
     * 获取长期不在线车辆总数
     *
     * @param params
     * @return
     */
    public long getCarOffListCount(Map<String, Object> params) {
        return get("AlertMapper.getCarOffListCount", params);
    }
}
