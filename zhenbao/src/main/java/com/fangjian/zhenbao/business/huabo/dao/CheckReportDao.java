package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.CheckReport;
import com.fangjian.zhenbao.business.huabo.entity.CheckReportModel;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 检测报告查询dao层
 * @date 2019-03-11 17:57
 */
@Repository
public class CheckReportDao extends SystemBaseDao {
    /**
     * 分页按条件获取检测报告列表    商用车
     *
     * @param params
     * @return
     */
    public List<CheckReportModel> getReportByCondition(Map<String, Object> params) {
        return getList("CheckReportMapper.getReportByCondition", params);
    }

    /**
     * 按条件获取检测报告总数      商用车
     *
     * @param params
     * @return
     */
    public long getReportByConditionCount(Map<String, Object> params) {
        return get("CheckReportMapper.getReportByConditionCount", params);
    }



    /**
     * 分页按条件获取检测报告列表    乘用车
     *
     * @param params
     * @return
     */
    public List<CheckReportModel> getReportByCondition2(Map<String, Object> params) {
        return getList("CheckReportMapper.getReportByCondition2", params);
    }

    /**
     * 按条件获取检测报告总数      乘用车
     *
     * @param params
     * @return
     */
    public long getReportByConditionCount2(Map<String, Object> params) {
        return get("CheckReportMapper.getReportByConditionCount2", params);
    }


    /**
     * 获取报告详情
     *
     * @param reportId
     * @return
     */
    public CheckReport selectByPrimaryKey(long reportId) {
        return get("CheckReportMapper.selectByPrimaryKey", reportId);
    }

    /**
     * 通过内部编号查找检测报告
     *
     * @param number
     * @return
     */
    public CheckReport getReportByNumber(String number) {
        return get("CheckReportMapper.getReportByNumber", number);
    }
}
