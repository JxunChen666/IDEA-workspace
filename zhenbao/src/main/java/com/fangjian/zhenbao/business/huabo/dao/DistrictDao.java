package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.District;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author FangJian
 * @description: 省份简称对应dao层
 * @date 2019-11-29 15:28
 */
@Repository
public class DistrictDao extends SystemBaseDao {
    /**
     * 获取一条省份简称对应信息
     *
     * @param disId
     * @return
     */
    public District selectByPrimaryKey(Integer disId) {
        return get("DistrictMapper.selectByPrimaryKey", disId);
    }




}
