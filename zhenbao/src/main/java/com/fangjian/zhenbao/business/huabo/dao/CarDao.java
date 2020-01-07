package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.Car;
import com.fangjian.zhenbao.business.huabo.entity.CarModel;
import com.fangjian.zhenbao.business.huabo.entity.CarTypeModel;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 操作用户车辆的dao层
 * @date 2019-03-11 15:04
 */
@Repository
public class CarDao extends SystemBaseDao {

    /**
     * 新增检测员车辆
     *
     * @param car
     * @return
     */
    public int addCar(Car car) {
        return save("CarMapper.insertSelective", car);
    }

    public Car selectByPrimaryKey(Long id) {
        return get("CarMapper.selectByPrimaryKey", id);
    }

    /**
     * 根据状态统计在线或不在线或总计车辆
     *
     * @param params
     * @return
     */
    public int getCarCountByStatus(Map<String, Object> params) {
        return get("CarMapper.getCarCountByStatus", params);
    }

    /**
     * 根据条件获取商用车车辆列表
     *
     * @param params
     * @return
     */
    public List<CarModel> getCarListByCondition(Map<String, Object> params) {
        return getList("CarMapper.getCarListByCondition", params);
    }

    /**
     * 根据条件获取商用车车辆总数
     *
     * @param params
     * @return
     */
    public long getCarListByConditionCount(Map<String, Object> params) {
        return get("CarMapper.getCarListByConditionCount", params);
    }

    /**
     * 根据条件获取乘用车车辆列表
     *
     * @param params
     * @return
     */
    public List<CarModel> getCarListByCondition2(Map<String, Object> params) {
        return getList("CarMapper.getCarListByCondition2", params);
    }

    /**
     * 根据条件获取乘用车车辆总数
     *
     * @param params
     * @return
     */
    public long getCarListByConditionCount2(Map<String, Object> params) {
        return get("CarMapper.getCarListByConditionCount2", params);
    }

    public Car selectCarByVIN(String vin) {
        return get("CarMapper.selectCarByVIN", vin);
    }

    /**
     * 获取车辆使用性质分类
     *
     * @param customer
     * @return
     */
    public List<CarTypeModel> getUserProperty(int customer) {
        return getList("CarMapper.getUserProperty", customer);
    }

    /**
     * 获取车辆排放阶段分类
     *
     * @param customer
     * @return
     */
    public List<CarTypeModel> getDischarge(int customer) {
        return getList("CarMapper.getDischarge", customer);
    }

    /**
     * 获取车辆详情
     *
     * @param carId
     * @return
     */
    public Map<String, Object> getInfoByCarId(Integer carId) {
        return get("CarMapper.getInfoByCarId", carId);
    }

    /**
     * 根据obd盒子ID获取车辆
     *
     * @param deviceId
     * @return
     */
    public Car getCarByDeviceId(String deviceId) {
        return get("CarMapper.getCarByDeviceId", deviceId);
    }
}
