package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.HuaboCar;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author FangJian
 * @description: 环保检测车辆dao层
 * @date 2019-03-12 15:56
 */
@Repository
public class HuaboCarDao extends SystemBaseDao {

    /**
     * 主键查环保车辆信息
     *
     * @param carId
     * @return
     */
    public HuaboCar selectByPrimaryKey(long carId) {
        return get("HuaboCarMapper.selectByPrimaryKey", carId);
    }
}
