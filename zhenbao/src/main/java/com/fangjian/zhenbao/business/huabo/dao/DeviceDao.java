package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.Device;
import com.fangjian.zhenbao.business.huabo.entity.DeviceModel;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 终端设备dao层
 * @date 2019-03-08 15:29
 */
@Repository
public class DeviceDao extends SystemBaseDao {
    /**
     * 条件获取设备列表
     *
     * @param params
     * @return
     */
    public List<DeviceModel> getDeviceByCondition(Map<String, Object> params) {
        return getList("DeviceMapper.getDeviceByCondition", params);
    }

    /**
     * 条件获取设备总数
     *
     * @param params
     * @return
     */
    public long getDeviceByConditionCount(Map<String, Object> params) {
        return get("DeviceMapper.getDeviceByConditionCount", params);
    }

    /**
     * 通过主键查询设备信息
     *
     * @param devId
     * @return
     */
    public Device selectByPrimaryKey(String devId) {
        return get("DeviceMapper.selectByPrimaryKey", devId);
    }

    /**
     * 更新设备信息
     *
     * @param device
     * @return
     */
    public int updateDevice(Device device) {
        return save("DeviceMapper.updateByPrimaryKeySelective", device);
    }

    /**
     * 获取设备列表
     *
     * @param params
     * @return
     */
    public List<Device> getDeviceList(Map<String, Object> params) {
        return getList("DeviceMapper.getDeviceList", params);
    }

    /**
     * 获取设备列表总数
     *
     * @param params
     * @return
     */
    public long getDeviceListCount(Map<String, Object> params) {
        return get("DeviceMapper.getDeviceListCount", params);
    }
}
