package com.fangjian.zhenbao.business.user.dao;

import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import com.fangjian.zhenbao.business.user.entity.ServiceStation;
import com.fangjian.zhenbao.business.user.entity.StationBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author fangjian
 * @date 2018/11/30 0030 下午 16:59
 */
@Repository
public class StationDao extends SystemBaseDao {

    /**
     * 获取所有的服务站基础信息(显示地图)
     *
     * @return
     */
    public List<StationBean> getAllStationMap(Map<String, Object> params) {
        return getList("ServiceStationMapper.getAllStationMap", params);
    }

    /**
     * 按条件获取所有的服务站信息
     *
     * @param params
     * @return
     */
    public List<ServiceStation> getAllStations(Map<String, Object> params) {
        return getList("ServiceStationMapper.getAllStations", params);
    }

    /**
     * 获取服务站（检测站）总数
     *
     * @param params
     * @return
     */
    public long getCount(Map<String, Object> params) {
        return get("ServiceStationMapper.getCount", params);
    }

    /**
     * 主键获取检测站详情
     *
     * @param id
     * @return
     */
    public ServiceStation selectByPrimaryKey(Integer id) {
        return get("ServiceStationMapper.selectByPrimaryKey", id);
    }

    /**
     * 新增检测站
     *
     * @param ss
     * @return
     */
    public int addServiceStation(ServiceStation ss) {
        return save("ServiceStationMapper.insertSelective", ss);
    }

    /**
     * 更新检测站信息
     *
     * @param ss
     * @return
     */
    public int updateServiceStation(ServiceStation ss) {
        return update("ServiceStationMapper.updateByPrimaryKeySelective", ss);
    }

    /**
     * 删除检测站
     *
     * @param id
     * @return
     */
    public int deleteServiceStation(Integer id) {
        return delete("ServiceStationMapper.deleteByPrimaryKey", id);
    }
}
