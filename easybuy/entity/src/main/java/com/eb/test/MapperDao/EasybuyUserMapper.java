package com.eb.test.MapperDao;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import com.eb.test.model.EasybuyUser;

public interface EasybuyUserMapper {
	//Security 验证 根据用户名查询  user 
	@Select("select * from easybuy_user where loginName=#{name}")
	EasybuyUser selectUserByName(String name);
	
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyUser record);

    int insertSelective(EasybuyUser record);

    EasybuyUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyUser record);

    int updateByPrimaryKey(EasybuyUser record);
    
    /* 登录————判断用户名密码是否正确 */
    @Select("select*from easybuy_user WHERE loginName = #{loginName} AND PASSWORD = #{password}")
    EasybuyUser loginSelect(
		@Param("loginName") String loginName,
		@Param("password") String password
	);
    
    //判断用户名是否重复
    @Select("select count(1) from easybuy_user WHERE loginName = #{loginName}")
    int SelectloginName(String loginName);
}