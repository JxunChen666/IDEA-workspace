package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.Area;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FangJian
 * @description: 三联联动获取省市区县的id
 * @date 2019-03-05 11:18
 */
@Repository
public class AreaDao extends SystemBaseDao {
    /**
     * 父id获取区域列表
     *
     * @param parentId
     * @return
     */
    public List<Area> getAreaByPaId(Integer parentId) {
        return getList("AreaMapper.getAreaByPaId", parentId);
    }

    /**
     * 主键获取区域
     *
     * @param areaId
     * @return
     */
    public Area selectByPrimaryKey(Integer areaId) {
        return get("AreaMapper.selectByPrimaryKey", areaId);
    }
}
