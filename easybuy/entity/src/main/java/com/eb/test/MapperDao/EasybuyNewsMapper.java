package com.eb.test.MapperDao;

import com.eb.test.model.EasybuyNews;

public interface EasybuyNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyNews record);

    int insertSelective(EasybuyNews record);

    EasybuyNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyNews record);

    int updateByPrimaryKey(EasybuyNews record);
}