package com.fangjian.zhenbao.business.system.service;

import com.fangjian.zhenbao.business.system.dao.TypeNameDao;
import com.fangjian.zhenbao.business.system.entity.TypeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FangJian
 * @description: 数据字典service层
 * @date 2019-07-21 16:19
 */
@Service
public class TypeNameService {
    @Autowired
    private TypeNameDao typeNameDao;

    /**
     * 获取数据字典列表
     *
     * @param typeId
     * @return
     */
    public List<TypeName> getTypeNamesByTypeId(Integer typeId) {
        return typeNameDao.getTypeNamesByTypeId(typeId);
    }

    /**
     * 获取一条数据字典
     *
     * @param typeName
     * @return
     */
    public TypeName getByTypeIdAndValue(TypeName typeName) {
        return typeNameDao.getByTypeIdAndValue(typeName);
    }
}
