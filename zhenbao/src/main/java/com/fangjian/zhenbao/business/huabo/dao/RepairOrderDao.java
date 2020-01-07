package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.RepairGoods;
import com.fangjian.zhenbao.business.huabo.entity.RepairOrder;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FangJian
 * @description: 维修订单dao层
 * @date 2019-07-30 10:07
 */
@Repository
public class RepairOrderDao extends SystemBaseDao {

    /**
     * 获取维修订单详情
     *
     * @param id
     * @return
     */
    public RepairOrder selectByPrimaryKey(long id) {
        return get("RepairOrderMapper.selectByPrimaryKey", id);
    }

    /**
     * 获取维修订单的商品
     *
     * @param repairOrderId
     * @return
     */
    public List<RepairGoods> getGoodsByOrderId(Long repairOrderId) {
        return getList("RepairGoodsMapper.getGoodsByOrderId", repairOrderId);
    }
}
