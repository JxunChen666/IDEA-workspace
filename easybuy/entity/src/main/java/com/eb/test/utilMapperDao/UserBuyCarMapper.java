package com.eb.test.utilMapperDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.eb.test.utilmodel.UserBuyCar;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface UserBuyCarMapper {
	//查询购物车订单
	@Select("SELECT p.*,b.users,b.goods,b.coun from easybuy_buycar b,easybuy_product p \r\n" + 
			"WHERE users=#{users} and p.id=b.goods")
	public List<UserBuyCar> slectMyCar(@Param("users") Integer users);
}
