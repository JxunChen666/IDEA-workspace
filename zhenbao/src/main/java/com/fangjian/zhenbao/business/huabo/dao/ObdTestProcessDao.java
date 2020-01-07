package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.ObdFaultBean;
import com.fangjian.zhenbao.business.huabo.entity.ObdTestProcess;
import com.fangjian.zhenbao.business.huabo.entity.ObdTestProcessBean;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: obd检测流程dao层
 * @date 2019-04-17 11:55
 */
@Repository
public class ObdTestProcessDao extends SystemBaseDao {

    /**
     * 按条件查询obd检测流程列表
     *
     * @param params
     * @return
     */
    public List<ObdTestProcessBean> getObdTestProcessList(Map<String, Object> params) {
        return getList("ObdTestProcessMapper.getObdTestProcessList", params);
    }

    /**
     * 按条件查询obd检测流程列表总数
     *
     * @param params
     * @return
     */
    public Long getObdTestProcessCount(Map<String, Object> params) {
        return get("ObdTestProcessMapper.getObdTestProcessCount", params);
    }

    /**
     * 获取检测过程详情
     *
     * @param id
     * @return
     */
    public ObdTestProcess selectByPrimaryKey(Long id) {
        return get("ObdTestProcessMapper.selectByPrimaryKey", id);
    }

    public ObdTestProcess getByNumber(String number) {
        return get("ObdTestProcessMapper.getByNumber", number);
    }

    /**
     * 获取obd故障监控列表
     *
     * @param params
     * @return
     */
    public List<ObdFaultBean> getObdFault(Map<String, Object> params) {
        return getList("ObdTestProcessMapper.getObdFault", params);
    }

    /**
     * 获取obd故障监控列表总数
     *
     * @param params
     * @return
     */
    public long getObdFaultCount(Map<String, Object> params) {
        return get("ObdTestProcessMapper.getObdFaultCount", params);
    }
}
