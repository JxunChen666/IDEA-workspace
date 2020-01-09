package com.eb.test.MapperDao;

import com.eb.test.model.EasybuyOrderDetail;

public interface EasybuyOrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyOrderDetail record);

    int insertSelective(EasybuyOrderDetail record);

    EasybuyOrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyOrderDetail record);

    int updateByPrimaryKey(EasybuyOrderDetail record);
}