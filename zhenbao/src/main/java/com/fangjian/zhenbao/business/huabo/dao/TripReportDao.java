package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.TripReport;
import com.fangjian.zhenbao.business.huabo.entity.TripReportDetail;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 车辆行程dao层
 * @date 2019-07-31 15:46
 */
@Repository
public class TripReportDao extends SystemBaseDao {

    /**
     * 获取所有车辆总里程/总油耗
     *
     * @param customer
     * @return
     */
    public Map<String, Double> getAllMileageFuel(Integer customer) {
        return get("TripReportMapper.getAllMileageFuel", customer);
    }

    /**
     * 获取尿素、Nox排放量总计
     *
     * @param customer
     * @return
     */
    public Map<String, BigDecimal> getReactorNox(Integer customer) {
        return get("TripReportMapper.getReactorNox", customer);
    }


    /**
     * 获取今天所有车辆总里程/总油耗
     *
     * @param customer
     * @return
     */
    public Map<String, Double> getTodayMileageFuel(Integer customer) {
        return get("TripReportMapper.getTodayMileageFuel", customer);
    }

    /**
     * 获取今天尿素、Nox排放量总计
     *
     * @param customer
     * @return
     */
    public Map<String, BigDecimal> getTodayReactorNox(Integer customer) {
        return get("TripReportMapper.getTodayReactorNox", customer);
    }

    /**
     * 历史行程（取某一天的行程）
     *
     * @param params
     * @return
     */
    public List<TripReport> getHistoryTrips(Map<String, Object> params) {
        return getList("TripReportMapper.getHistoryTrips", params);
    }

    /**
     * 历史行程（取某一天的行程）总数
     *
     * @param params
     * @return
     */
    public Long getHistoryTripsCount(Map<String, Object> params) {
        return get("TripReportMapper.getHistoryTripsCount", params);
    }

    /**
     * 获取行程的所有详情点
     *
     * @param id
     * @return
     */
    public List<TripReportDetail> getTripReportDetails(Integer id) {
        return getList("TripReportDetailMapper.getTripReportDetails", id);
    }
}
