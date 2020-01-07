package com.fangjian.zhenbao.business.huabo.service;

import com.fangjian.zhenbao.base.PageBean;
import com.fangjian.zhenbao.base.utils.DateUtils;
import com.fangjian.zhenbao.business.huabo.dao.AlertDao;
import com.fangjian.zhenbao.business.huabo.entity.CarModel;
import com.fangjian.zhenbao.business.huabo.entity.CarOffModel;
import com.fangjian.zhenbao.business.huabo.entity.FaultAlert;
import com.fangjian.zhenbao.business.system.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FangJian
 * @description: 告警service层
 * @date 2019-06-28 16:31
 */
@Service
public class AlertService {
    @Autowired
    private AlertDao alertDao;

    /**
     * 获取最新的报警列表
     *
     * @param params
     * @return
     */
    public List<FaultAlert> getNewestAlert(Map<String, Object> params) {
        return alertDao.getNewestAlert(params);
    }

    /**
     * 获取长期不在线车辆
     *
     * @param page
     * @param carOffModel
     * @param user
     * @return
     */
    public Map<String, Object> getCarOffList(PageBean page, CarOffModel carOffModel, User user) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();

        //params.put("cityCode", user.getCityCode());//根据当前检测站的账号去查找是属于那个检测站id
        params.put("customer", user.getOrganizationId());//根据当前检测站的账号去查找是属于谁家的数据
        params.put("start", page.getStart());
        params.put("pageSize", page.getPageSize());
        params.put("sort", page.getSortCol());
        params.put("order", ("desc".equals(page.getSortWay()) ? Sort.Direction.DESC : Sort.Direction.ASC));

        String carName = carOffModel.getCarName();
        if (StringUtils.isNotEmpty(carName)) {
            params.put("carName", carName);
        }
        params.put("offTime", carOffModel.getOffTime());

        List<CarOffModel> carOffModelList = alertDao.getCarOffList(params);
        long count = alertDao.getCarOffListCount(params);

        List<List<Object>> aaData = new ArrayList<>();
        for (CarOffModel c : carOffModelList) {
            List<Object> list = new ArrayList<>();
            //1表示table页面展示列表 2表示导出excel列表
            builder(c, list, 1);
            aaData.add(list);
        }

        resultMap.put("aaData", aaData);
        resultMap.put("iTotalRecords", count);
        resultMap.put("iTotalDisplayRecords", count);
        return resultMap;
    }

    private void builder(CarOffModel c, List<Object> list, int kind) {
        int type = c.getType();
        if (1 == kind) {
            switch (type) {
                case 10:
                    list.add("<font style='color:#008B00;'>" + (StringUtils.isNotEmpty(c.getCarName()) ? c.getCarName() : "未上牌") + "</font>");
                    break;
                case 20:
                    list.add("<font style='color:#FF7F00;'>" + (StringUtils.isNotEmpty(c.getCarName()) ? c.getCarName() : "未上牌") + "</font>");
                    break;
            }
        } else {
            switch (type) {
                case 10:
                    list.add(StringUtils.isNotEmpty(c.getCarName()) ? c.getCarName() : "未上牌");
                    break;
                case 20:
                    list.add(StringUtils.isNotEmpty(c.getCarName()) ? c.getCarName() : "未上牌");
                    break;
            }
        }

        list.add(c.getCarIdentityCode());
        list.add(c.getCarDeviceId());
        list.add(c.getUserName());
        list.add(c.getUserTruename());
        list.add(c.getUserMobile());
        if (1 == kind) {
            list.add(type == 10 ? "<span class=\"label label-success\">商用车</span>" : "<span class=\"label label-warning\">乘用车</span>");
        } else {
            list.add(type == 10 ? "商用车" : "乘用车");
        }

        long redisAlertTime = c.getRedisAlertTime();
        list.add(DateUtils.sequenceToDateTime(redisAlertTime));
        list.add(DateUtils.secondsToDayHourMinute(System.currentTimeMillis() / 1000 - redisAlertTime));
    }

    /**
     * 长期不在线车辆导出excel
     *
     * @param carOffModel
     * @param user
     * @return
     */
    public List<List<Object>> getExportCarOffList(CarOffModel carOffModel, User user) {
        Map<String, Object> params = new HashMap<>();

        //params.put("cityCode", user.getCityCode());//根据当前检测站的账号去查找是属于那个检测站id
        params.put("customer", user.getOrganizationId());//根据当前检测站的账号去查找是属于谁家的数据

        String carName = carOffModel.getCarName();
        if (StringUtils.isNotEmpty(carName)) {
            params.put("carName", carName);
        }
        params.put("offTime", carOffModel.getOffTime());

        List<CarOffModel> carOffModelList = alertDao.getCarOffList(params);

        List<List<Object>> aaData = new ArrayList<>();
        for (CarOffModel c : carOffModelList) {
            List<Object> list = new ArrayList<>();
            //1表示table页面展示列表 2表示导出excel列表
            builder(c, list, 2);
            aaData.add(list);
        }

        return aaData;
    }
}
