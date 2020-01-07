package com.fangjian.zhenbao.business.system.dao;

import com.fangjian.zhenbao.business.system.entity.TypeName;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FangJian
 * @description: 数据字典dao层
 * @date 2019-07-21 16:15
 */
@Repository
public class TypeNameDao extends SystemBaseDao {
    /**
     * 获取数据字典列表
     *
     * @param typeId
     * @return
     */
    public List<TypeName> getTypeNamesByTypeId(Integer typeId) {
        return getList("TypeNameMapper.getTypeNamesByTypeId", typeId);
    }

    /**
     * 获取一条数据字典
     *
     * @param typeName
     * @return
     */
    public TypeName getByTypeIdAndValue(TypeName typeName) {
        return get("TypeNameMapper.getByTypeIdAndValue", typeName);
    }
}
