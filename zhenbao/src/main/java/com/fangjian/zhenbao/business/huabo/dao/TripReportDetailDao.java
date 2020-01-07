package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.OutOfRangeModel;
import com.fangjian.zhenbao.business.huabo.entity.TripReportDetail;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 行程详情点dao层
 * @date 2019-08-06 14:35
 */
@Repository
public class TripReportDetailDao extends SystemBaseDao {
    /**
     * 获取NOx排放不合格记录列表
     *
     * @param params
     * @return
     */
    public List<OutOfRangeModel> getNOxOutOfRange(Map<String, Object> params) {
        return getList("TripReportDetailMapper.getNOxOutOfRange", params);
    }

    /**
     * 获取NOx排放不合格记录列表总数
     *
     * @param params
     * @return
     */
    public long getNOxOutOfRangeCount(Map<String, Object> params) {
        return get("TripReportDetailMapper.getNOxOutOfRangeCount", params);
    }

    /**
     * 获取dpf排放不合格记录列表
     *
     * @param params
     * @return
     */
    public List<OutOfRangeModel> getDpfOutOfRange(Map<String, Object> params) {
        return getList("TripReportDetailMapper.getDpfOutOfRange", params);
    }

    /**
     * 获取dpf排放不合格记录列表总数
     *
     * @param params
     * @return
     */
    public long getDpfOutOfRangeCount(Map<String, Object> params) {
        return get("TripReportDetailMapper.getDpfOutOfRangeCount", params);
    }


    /**
     * 获取dpf排放不合格记录列表
     *
     * @param params
     * @return
     */
    public List<OutOfRangeModel> getReactorOutOfRange(Map<String, Object> params) {
        return getList("TripReportDetailMapper.getReactorOutOfRange", params);
    }

    /**
     * 获取dpf排放不合格记录列表总数
     *
     * @param params
     * @return
     */
    public Long getReactorOutOfRangeCount(Map<String, Object> params) {
        return get("TripReportDetailMapper.getReactorOutOfRangeCount", params);
    }


    /**
     * 获取数据不全项记录列表
     *
     * @param params
     * @return
     */
    public List<TripReportDetail> getIncompleteData(Map<String, Object> params) {
        return getList("TripReportDetailMapper.getIncompleteData", params);
    }

    /**
     * 获取数据不全项记录列表总数
     *
     * @param params
     * @return
     */
    public Long getIncompleteDataCount(Map<String, Object> params) {
        return get("TripReportDetailMapper.getIncompleteDataCount", params);
    }
}
