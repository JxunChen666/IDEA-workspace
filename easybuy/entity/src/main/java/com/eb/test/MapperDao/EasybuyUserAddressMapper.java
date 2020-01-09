package com.eb.test.MapperDao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.eb.test.model.EasybuyAddress;
import com.eb.test.model.EasybuyUserAddress;



public interface EasybuyUserAddressMapper {
	
    //查询收货地址
	@Select("select * from  easybuy_address where userid=#{userid}")
	List<EasybuyAddress> selectAddress(Integer userid);
	
	//设置当前用户所有收货地址为非默认状态isDefault=0
	@Update("update easybuy_address set isdefault = default where userid=#{userid}")
	int updateisDefault_0(EasybuyAddress eba);
	
	//设置默认收货地址isDefault=1
	@Update("update easybuy_address set isdefault = #{isdefault} where id=#{id}")
	int updateisDefault(EasybuyAddress eba);
	
	//删除地址
	@Delete("delete from easybuy_address where id=#{id}")
	int delAddress(Integer id);
	
	//查询单条记录 修改所需
	@Select("select * from easybuy_address where id=#{id}")
	EasybuyAddress selectByIdAddress(Integer id);
	
	//修改地址
	@Update("update easybuy_address set\t"
			+ "name=#{name},email=#{email},addressdetail=#{addressdetail},"
			+ "code=#{code},mobile=#{mobile},phone=#{phone},build=#{build},"
			+ "basttime=#{basttime}\t"
			+ "where id=#{id}")
	int updateByIdAddress(EasybuyAddress eba);
	
	
	//新增地址
	@Insert("insert into easybuy_address(id,userid,remark,name,email,addressdetail,code,mobile,phone,build,basttime,isdefault)"
			+ " values(default,#{userid},#{remark},#{name},#{email},#{addressdetail},#{code},#{mobile},#{phone},#{build},#{basttime},default)")			
	int insertAddress(EasybuyAddress eba);
	
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyUserAddress record);

    int insertSelective(EasybuyUserAddress record);

    EasybuyUserAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyUserAddress record);

    int updateByPrimaryKey(EasybuyUserAddress record);
}