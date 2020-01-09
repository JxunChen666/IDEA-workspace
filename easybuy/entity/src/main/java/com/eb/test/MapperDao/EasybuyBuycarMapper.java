package com.eb.test.MapperDao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.eb.test.model.*;

/**
 * 
 * @author weizhen  12/06
 *
 */
public interface EasybuyBuycarMapper {
	//购物车mapper 用户操作购物车表的信息 
	@Select("<script>"
			+ "select *from easybuy_buycar"
			+ "<where>"
			+ "<if test='userid!=null'> and users=#{userid}</if>"
			+ "<if test='goodid!=null'> and goods=#{goodid}</if>"
			+ "</where>"
			+ "</script>")
	List<EasybuyBuycar> getUserBuycar(Integer userid,Integer goodid);//根据用户id 商品id查询用户的购物车
	//统计购物车数量 ===
	@Select("<script>"
			+ "select sum(coun) from easybuy_buycar"
			+ "<where>"
			+ "<if test='_parameter!=null'>users=#{userid}</if>"
			+ "</where>"
			+ "</script>")
	Integer getBuycarCount(Integer userid);
	//统计购物车价格===
	@Select("<script>"
			+ "SELECT SUM(ep.`price`*eb.`coun`) FROM easybuy_product ep ,easybuy_buycar eb "
			+ "<where>"
			+"ep.`id`=eb.`goods`"
			+ "<if test='_parameter!=null'>and users=#{userid}</if>"
			+ "</where>"
			+ "</script>")
	Integer getBuycarMoney(Integer userid);
	//购物车添加
	@Insert("insert into easybuy_buycar values(default,#{users},#{goods},#{coun})")
	Integer BuycarInsert(EasybuyBuycar eb);
	//购物车修改
	@Insert("<script>"
			+ "update easybuy_buycar"
			+ "<set>"
			+ "<if test='users!=null'>users=#{users},</if>"
			+ "<if test='goods!=null'>goods=#{goods},</if>"
			+ "<if test='coun!=null'>coun=#{coun},</if>"
			+ "</set>"
			+ "where users=#{users} and goods=#{goods}"
			+ "</script>")
	Integer BuycarUpdate(EasybuyBuycar eb);
	//购物车删除根据主键
	@Delete("<script>"
			+ "delete from easybuy_buycar"
			+ "<where>"
			+ "<if test='_parameter!=null'>id=#{id}</if>"
			+ "</where>"
			+ "</script>")
	Integer BuycarDelete(Integer id);
	//购物车删除根据users
	@Delete("<script>"
			+ "delete from easybuy_buycar"
			+ "<where>"
			+ "<if test='_parameter!=null'>users=#{users}</if>"
			+ "</where>"
			+ "</script>")
	Integer BuycarDeleteByUsers(Integer id);
	//根据id查询用户详细信息
	@Select("<script>"
			+ "select *from easybuy_user"
			+ "<where>"
			+ "<if test='_parameter!=null'>id=#{id}</if>"
			+ "</where>"
			+ "</script>")
	List<EasybuyUser> selectUserbyId(Integer id);
	//根据id查询用户默认地址 注 是 buycaraddress表
		@Select("<script>"
				+ "select *from easybuy_address"
				+ "<where>"
				+ "<if test='_parameter!=null'>userId=#{id} and isdefault=1</if>"
				+ "</where>"
				+ "</script>")
		List<EasybuyAddress> selectUseDefaultrAddressbyId(Integer id);
	//新增
		@Insert("insert into easybuy_order values(default,#{userid},#{loginname},#{useraddress},#{createtime},#{cost},#{status},#{type},#{serialnumber})")
		Integer OrderInsert(EasybuyOrder eo);
}
