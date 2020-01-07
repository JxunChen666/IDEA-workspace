package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.CommercialCar;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author FangJian
 * @description: 商用车车型表dao层
 * @date 2019-12-06 15:59
 */
@Repository
public class CommercialCarDao extends SystemBaseDao{

    public CommercialCar selectByPrimaryKey(long id){
        return get("CommercialCarMapper.selectByPrimaryKey",id);
    }
}
