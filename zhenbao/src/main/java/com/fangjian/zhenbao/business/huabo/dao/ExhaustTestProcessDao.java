package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.ExhaustTestProcess;
import com.fangjian.zhenbao.business.huabo.entity.TestProcessBean;
import com.fangjian.zhenbao.business.huabo.entity.TestRepairOrder;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 3847检测结果dao层
 * @date 2019-07-21 14:07
 */
@Repository
public class ExhaustTestProcessDao extends SystemBaseDao {
    /**
     * 按条件返回3847检测结果列表
     *
     * @param params
     * @return
     */
    public List<TestProcessBean> getTestResults(Map<String, Object> params) {
        return getList("ExhaustTestProcessMapper.getTestResults", params);
    }

    /**
     * 按条件返回3847检测结果列表总数
     *
     * @param params
     * @return
     */
    public Long getTestResultsCount(Map<String, Object> params) {
        return get("ExhaustTestProcessMapper.getTestResultsCount", params);
    }

    public ExhaustTestProcess getByNumber(String number) {
        return get("ExhaustTestProcessMapper.getByNumber", number);
    }

    /**
     * 获取检测不通过的维修记录
     *
     * @param params
     * @return
     */
    public List<TestRepairOrder> getTestRepairOrders(Map<String, Object> params) {
        return getList("ExhaustTestProcessMapper.getTestRepairOrders", params);
    }

    /**
     * 获取检测不通过的维修记录总数
     *
     * @param params
     * @return
     */
    public long getTestRepairOrdersCount(Map<String, Object> params) {
        return get("ExhaustTestProcessMapper.getTestRepairOrdersCount", params);
    }
}
