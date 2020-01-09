package com.eb.test.utilMapperDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.eb.test.utilmodel.UserIcon;

@Mapper
public interface UserIconMapper {
	
	//查询头像
	@Select("select DISTINCT i.uid,i.fileName FROM easy_myicon i,easybuy_user u\r\n" + 
			"where\r\n" + 
			"i.uid=#{uid}")
	public UserIcon selecUicontById(Integer uid);
	
	//修改新增头
	@Options(useGeneratedKeys = true,keyColumn = "uid")
	@Insert("insert into easy_myicon(uid,fileName) values (#{uid},#{fileName}) on duplicate key update fileName=VALUES(fileName);")
	public int InsetOrUpd(UserIcon userIcon);
}
