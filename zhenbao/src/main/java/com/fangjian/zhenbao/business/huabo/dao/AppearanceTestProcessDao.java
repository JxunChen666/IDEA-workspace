package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.AppearanceTestProcess;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author FangJian
 * @description: 3847外观检测dao层
 * @date 2019-07-22 09:58
 */
@Repository
public class AppearanceTestProcessDao extends SystemBaseDao {

    public AppearanceTestProcess getByNumber(String number) {
        return get("AppearanceTestProcessMapper.getByNumber", number);
    }
}
